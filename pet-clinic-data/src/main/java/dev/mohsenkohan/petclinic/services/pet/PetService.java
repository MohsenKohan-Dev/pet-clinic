package dev.mohsenkohan.petclinic.services.pet;

import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.services.CrudService;

import java.util.Set;

public interface PetService extends CrudService<Pet, Long> {

    Set<Pet> findAllByOwnerId(Long id);

    Set<Pet> findAllByPetTypeId(Long id);
}
