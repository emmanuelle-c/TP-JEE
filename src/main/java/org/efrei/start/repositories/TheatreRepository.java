package org.efrei.start.repositories;

import org.efrei.start.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, String>{

}
