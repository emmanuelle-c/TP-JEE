package org.efrei.start.services;

import org.efrei.start.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.efrei.start.dto.CreateFilm;
import org.efrei.start.models.Director;
import org.efrei.start.models.Film;

@Service
public class FilmService {

    private final FilmRepository repository;

    private final DirectorService directorService;

    @Autowired
    public FilmService(FilmRepository repository, DirectorService directorService) {
        this.repository = repository;
        this.directorService = directorService;
    }

    public List<Film> findAll() {
        return repository.findAll();
    }

    public Film findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateFilm createFilm) {
        Film film = new Film();
        Director director = directorService.findById(createFilm.getDirectorId());
        film.setTitle(createFilm.getTitle());
        film.setCategory(createFilm.getCategory());
        film.setDuration(createFilm.getDuration());
        film.setDirector(director);
        repository.save(film);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public void update(String id, CreateFilm film) {
        Film updateFilm = findById(id);
        Director director = directorService.findById(film.getDirectorId());
        updateFilm.setTitle(film.getTitle());
        updateFilm.setDuration(film.getDuration());
        updateFilm.setCategory(film.getCategory());
        updateFilm.setDirector(director);
        repository.save(updateFilm);
    }
}
