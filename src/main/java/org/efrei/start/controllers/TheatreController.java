package org.efrei.start.controllers;

import java.util.List;

import org.efrei.start.dto.CreateTheatre;
import org.efrei.start.models.Theatre;
import org.efrei.start.services.TheatreService;
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
@RequestMapping("/theatres")
public class TheatreController {
    private final TheatreService service;

    @Autowired
    public TheatreController(TheatreService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Theatre>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theatre> findById(@PathVariable String id) {
        Theatre theatre = service.findById(id);
        if(theatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(theatre, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateTheatre theatre) {
        service.create(theatre);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Theatre> deleteById(@PathVariable String id) {
        Theatre theatre = service.findById(id);
        if (theatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Theatre> update(@PathVariable String id, @RequestBody CreateTheatre film) {
        Theatre oldTheatre = service.findById(id);
        if (oldTheatre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, film);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
