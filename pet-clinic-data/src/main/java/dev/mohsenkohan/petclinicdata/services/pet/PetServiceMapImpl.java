package dev.mohsenkohan.petclinicdata.services.pet;

import dev.mohsenkohan.petclinicdata.model.Pet;
import dev.mohsenkohan.petclinicdata.repositories.MapRepository;

import java.util.Set;

public class PetServiceMapImpl implements PetService {

    private final MapRepository<Long, Pet> mapRepository;

    public PetServiceMapImpl(MapRepository<Long, Pet> map) {
        this.mapRepository = map;
    }

    @Override
    public Set<Pet> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return mapRepository.findById(id);
    }

    @Override
    public Pet save(Pet entity) {
        return mapRepository.save(entity.getId(), entity);
    }

    @Override
    public void delete(Pet entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteById(id);
    }
}
