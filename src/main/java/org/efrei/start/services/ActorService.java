package org.efrei.start.services;

import java.util.List;

import org.efrei.start.dto.CreateActor;
import org.efrei.start.models.Actor;
import org.efrei.start.models.Film;
import org.efrei.start.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    private final ActorRepository repository;

    private final FilmService FilmService;

    @Autowired
    public ActorService(ActorRepository repository, FilmService FilmService) {
        this.repository = repository;
        this.FilmService = FilmService;
    }

    public List<Actor> findAll(){
        return repository.findAll();
    }

    public void create(CreateActor createActor) {
        Actor actor = new Actor();
        Film film = FilmService.findById(createActor.getFilmId());
        actor.setFirstname(createActor.getFirstname());
        actor.setName(createActor.getName());
        actor.setFilm(film);
        repository.save(actor);
    }

    public Actor findById(String id){
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        repository.deleteById(id);
    }

    public void update(String id, Actor actor) {
        Actor updateActor = findById(id);
        updateActor.setName(actor.getName());
        updateActor.setFirstname(actor.getFirstname());
        repository.save(updateActor);
    }
}
