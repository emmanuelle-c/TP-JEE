package org.efrei.start.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name", nullable= false)
    private String name;

    @Column(name="firstname")
    private String firstname;

    public Actor(String name, String fisrtname) {
        this.name = name;
        this.firstname = fisrtname;
    }

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public Actor() {}

    public String getName(){
        return name;
    }
    public String getFirstname(){
        return firstname;
    }

    public String getId(){
        return id;
    }

    public Film getFilm(){
        return film;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setFilm(Film film){
        this.film = film;
    }
}
