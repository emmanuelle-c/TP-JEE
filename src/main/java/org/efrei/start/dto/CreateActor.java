package org.efrei.start.dto;

public class CreateActor {
    private String firstname;

    private String name;

    private String filmId;


    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilmId() {
        return this.filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }
}
