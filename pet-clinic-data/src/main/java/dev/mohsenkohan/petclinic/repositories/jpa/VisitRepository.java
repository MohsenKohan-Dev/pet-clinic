package dev.mohsenkohan.petclinic.repositories.jpa;

import dev.mohsenkohan.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
