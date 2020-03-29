package dev.mohsenkohan.petclinic.repositories;

import dev.mohsenkohan.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
