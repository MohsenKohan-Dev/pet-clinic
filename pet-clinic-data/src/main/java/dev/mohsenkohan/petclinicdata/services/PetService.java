package dev.mohsenkohan.petclinicdata.services;

import dev.mohsenkohan.petclinicdata.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    Set<Pet> findAll();
}
