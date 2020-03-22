package dev.mohsenkohan.petclinicdata.services.vet;

import dev.mohsenkohan.petclinicdata.model.Vet;
import dev.mohsenkohan.petclinicdata.repositories.MapRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMapImpl implements VetService {

    private final MapRepository<Long, Vet> mapRepository;

    public VetServiceMapImpl(MapRepository<Long, Vet> map) {
        this.mapRepository = map;
    }

    @Override
    public Set<Vet> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return mapRepository.findByKey(id);
    }

    @Override
    public Vet save(Vet entity) {
        return mapRepository.save(entity.getId(), entity);
    }

    @Override
    public void delete(Vet entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteByKey(id);
    }
}
