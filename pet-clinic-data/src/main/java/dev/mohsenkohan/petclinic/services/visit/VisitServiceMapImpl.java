package dev.mohsenkohan.petclinic.services.visit;

import dev.mohsenkohan.petclinic.model.Pet;
import dev.mohsenkohan.petclinic.model.Visit;
import dev.mohsenkohan.petclinic.repositories.map.MapRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile({"default", "map"})
public class VisitServiceMapImpl implements VisitService {

    private final MapRepository<Long, Visit> mapRepository;

    public VisitServiceMapImpl(MapRepository<Long, Visit> mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public Set<Visit> findAllByPet(Pet pet) {
        Set<Visit> all = new HashSet<>();

        for (Visit visit : mapRepository.findAll()) {
            if (visit.getPet().getId().equals(pet.getId())) {
                all.add(visit);
            }
        }

        return all;
    }

    @Override
    public Set<Visit> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Visit findById(Long id) {
        return mapRepository.findById(id);
    }

    @Override
    public Visit save(Visit entity) {
        return mapRepository.save(entity);
    }

    @Override
    public void delete(Visit entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteById(id);
    }
}
