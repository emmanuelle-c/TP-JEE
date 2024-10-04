package org.efrei.start.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.efrei.start.models.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, String>{

}
