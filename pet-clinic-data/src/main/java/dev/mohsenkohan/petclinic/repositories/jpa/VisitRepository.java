package dev.mohsenkohan.petclinic.repositories.jpa;

import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {

    Set<Visit> findAllByPet(Pet pet);
}
