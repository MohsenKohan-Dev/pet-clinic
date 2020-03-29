package dev.mohsenkohan.petclinic.services.pet;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.repositories.map.MapRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class PetServiceMapImpl implements PetService {

    private final MapRepository<Long, Pet> mapRepository;

    public PetServiceMapImpl(MapRepository<Long, Pet> map) {
        this.mapRepository = map;
    }

    @Override
    public Set<Pet> findAllByOwner(Owner owner) {
        Set<Pet> all = new HashSet<>();

        for (Pet pet : mapRepository.findAll()) {
            if (pet.getOwner().getId().equals(owner.getId())) {
                all.add(pet);
            }
        }

        return all;
    }

    @Override
    public Set<Pet> findAllByType(PetType type) {
        Set<Pet> all = new HashSet<>();

        for (Pet pet : mapRepository.findAll()) {
            if (pet.getType().getId().equals(type.getId())) {
                all.add(pet);
            }
        }

        return all;
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
