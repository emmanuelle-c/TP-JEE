package org.efrei.start.dto;

import java.util.List;

import org.efrei.start.models.Film;

public class CreateTheatre {
    private String name;

    private String address;

    private List<Film> films;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }


}
