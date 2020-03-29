package dev.mohsenkohan.petclinic.repositories;

import dev.mohsenkohan.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
