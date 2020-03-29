package dev.mohsenkohan.petclinic.repositories.jpa;

import dev.mohsenkohan.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
