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
@Table(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "firstname")
    private String firstname;

    @OneToMany
    private List<Film> films;

    public Director(String name, String firstname, List<Film> films) {
        this.name = name;
        this.firstname = firstname;
        this.films = films;
    }
    
    public Director() {}
    
    
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
