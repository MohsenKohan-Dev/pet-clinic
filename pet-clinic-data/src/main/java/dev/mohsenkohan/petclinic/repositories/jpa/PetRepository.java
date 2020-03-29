package dev.mohsenkohan.petclinic.repositories.jpa;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    Set<Pet> findAllByOwner(Owner owner);

    Set<Pet> findAllByType(PetType type);
}
