package org.efrei.start.dto;

import java.util.List;

import org.efrei.start.global.Category;
import org.efrei.start.models.Actor;

public class CreateFilm {
    private String title;

    private String duration;

    private Category category;

    private List<Actor> actors;

    public List<Actor> getActors() {
        return this.actors;
    }
    
    public String getDuration() {
        return this.duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String getTitle() {
        return this.title;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
