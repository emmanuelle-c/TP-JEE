package org.efrei.start.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

import org.efrei.start.global.Category;;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private String id;

    @Column(name= "title", nullable= false)
    private String title;

    @Column(name="duration")
    private String duration;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany
    private List<Actor> actors;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;

    public Film() {}

    public Film(String title, String duration, Category category, List<Actor> actors) {
        this.title = title;
        this.duration = duration;
        this.category = category;
        this.actors = actors;
    }

    public String getTitle(){
        return title;
    }

    public String getDuration(){
        return duration;
    }

    public String getId(){
        return id;
    }

    public Category getCategory(){
        return category;
    }

    public List<Actor> geActors(){
        return actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCategory(Category category){
        this.category = category;
    }

    public void setActors(List<Actor> actors){
        this.actors = actors;
    }
}
