package org.efrei.start.dto;

import java.util.List;

import org.efrei.start.models.Film;

public class CreateDirector {
    private String name;

    private String firstname;

    private List<Film> films;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Film> getFilms() {
        return this.films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

}
