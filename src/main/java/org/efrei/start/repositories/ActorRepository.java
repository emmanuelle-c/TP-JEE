package org.efrei.start.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.efrei.start.models.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, String> {

}
