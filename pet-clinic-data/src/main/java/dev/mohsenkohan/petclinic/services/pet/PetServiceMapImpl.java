package dev.mohsenkohan.petclinic.services.pet;

import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.repositories.MapRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
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
        return mapRepository.save(entity);
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
