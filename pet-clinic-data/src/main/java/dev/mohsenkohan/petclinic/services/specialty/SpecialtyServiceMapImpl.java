package dev.mohsenkohan.petclinic.services.specialty;

import dev.mohsenkohan.petclinic.model.Specialty;
import dev.mohsenkohan.petclinic.repositories.MapRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialtyServiceMapImpl implements SpecialtyService {

    private final MapRepository<Long, Specialty> mapRepository;

    public SpecialtyServiceMapImpl(MapRepository<Long, Specialty> mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Specialty findById(Long id) {
        return mapRepository.findById(id);
    }

    @Override
    public Specialty save(Specialty entity) {
        return mapRepository.save(entity);
    }

    @Override
    public void delete(Specialty entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteById(id);
    }
}
