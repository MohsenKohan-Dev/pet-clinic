package dev.mohsenkohan.petclinic.services.pet;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.services.CrudService;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {

    Set<Pet> findAllByOwner(Owner owner);

    Set<Pet> findAllByType(PetType type);
}
