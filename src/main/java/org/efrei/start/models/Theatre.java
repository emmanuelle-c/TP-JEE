package org.efrei.start.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name= "name")
    private String name;

    @Column(name= "address")
    private String address;

    @OneToMany
    private List<Film> films;

    public Theatre() {}

    public Theatre(String name, String address, List<Film> films) {
        this.name = name;
        this.address = address;
        this.films = films;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

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
