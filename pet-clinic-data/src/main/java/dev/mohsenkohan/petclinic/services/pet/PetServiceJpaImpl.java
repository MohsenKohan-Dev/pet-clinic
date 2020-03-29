package dev.mohsenkohan.petclinic.services.pet;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.repositories.jpa.PetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class PetServiceJpaImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceJpaImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAllByOwner(Owner owner) {
        return petRepository.findAllByOwner(owner);
    }

    @Override
    public Set<Pet> findAllByType(PetType type) {
        return petRepository.findAllByType(type);
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElseThrow();
    }

    @Override
    public Pet save(Pet entity) {
        return petRepository.save(entity);
    }

    @Override
    public void delete(Pet entity) {
        petRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }
}
