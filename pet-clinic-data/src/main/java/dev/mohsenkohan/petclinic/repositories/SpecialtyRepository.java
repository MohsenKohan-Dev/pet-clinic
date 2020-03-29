package dev.mohsenkohan.petclinic.repositories;

import dev.mohsenkohan.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
