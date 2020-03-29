package dev.mohsenkohan.petclinic.services.pet.type;

import dev.mohsenkohan.petclinic.model.PetType;
import dev.mohsenkohan.petclinic.repositories.map.MapRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeServiceMapImpl implements PetTypeService {

    private final MapRepository<Long, PetType> mapRepository;

    public PetTypeServiceMapImpl(MapRepository<Long, PetType> mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public Set<PetType> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public PetType findById(Long id) {
        return mapRepository.findById(id);
    }

    @Override
    public PetType save(PetType entity) {
        return mapRepository.save(entity);
    }

    @Override
    public void delete(PetType entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteById(id);
    }
}
