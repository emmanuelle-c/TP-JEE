package org.efrei.start.controllers;

import java.util.List;

import org.efrei.start.dto.CreateDirector;
import org.efrei.start.models.Director;
import org.efrei.start.models.Film;
import org.efrei.start.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService service;

    @Autowired
    public DirectorController(DirectorService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Director>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> findById(@PathVariable String id) {
        Director director = service.findById(id);
        if(director == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateDirector director) {
        service.create(director);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteById(@PathVariable String id) {
        Director director = service.findById(id);
        if (director == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> update(@PathVariable String id, @RequestBody CreateDirector director) {
        Director oldDirector = service.findById(id);
        if (oldDirector == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, director);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
