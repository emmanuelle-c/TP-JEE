package org.efrei.start.services;

import java.util.List;

import org.efrei.start.dto.CreateTheatre;
import org.efrei.start.models.Theatre;
import org.efrei.start.repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {

    private final TheatreRepository theatreRepository;

    @Autowired
    public TheatreService(TheatreRepository theatreRepository){
        this.theatreRepository = theatreRepository;
    }

    public List<Theatre> findAll() {
        return theatreRepository.findAll();
    }

    public Theatre findById(String id) {
        return theatreRepository.findById(id).orElse(null);
    }

    public void deleteById(String id){
        theatreRepository.deleteById(id);
    }

    public void create(CreateTheatre createTheatre) {
        Theatre theatre = new Theatre();
        theatre.setName(createTheatre.getName());
        theatre.setAddress(createTheatre.getAddress());
        theatreRepository.save(theatre);
    }

    public void update(String id, CreateTheatre theatre) {
        Theatre updateTheatre = findById(id);
        updateTheatre.setName(theatre.getName());
        updateTheatre.setAddress(theatre.getAddress());
        theatreRepository.save(updateTheatre);
    }
}
