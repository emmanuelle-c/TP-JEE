package org.efrei.start.services;

import org.efrei.start.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.efrei.start.dto.CreateFilm;
import org.efrei.start.models.Film;

@Service
public class FilmService {

    private final FilmRepository repository;

    @Autowired
    public FilmService(FilmRepository repository) {
        this.repository = repository;
    }

    public List<Film> findAll() {
        return repository.findAll();
    }

    public Film findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void create(CreateFilm createFilm) {
        Film film = new Film();
        film.setTitle(createFilm.getTitle());
        film.setCategory(createFilm.getCategory());
        film.setDuration(createFilm.getDuration());
        repository.save(film);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public void update(String id, Film film) {
        Film updateFilm = findById(id);
        updateFilm.setTitle(film.getTitle());
        updateFilm.setDuration(film.getDuration());
        updateFilm.setCategory(film.getCategory());
        repository.save(updateFilm);
    }
}
