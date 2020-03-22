package dev.mohsenkohan.petclinic.services.owner;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.repositories.MapRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMapImpl implements OwnerService {

    private final MapRepository<Long, Owner> mapRepository;

    public OwnerServiceMapImpl(MapRepository<Long, Owner> mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        for (Owner owner : mapRepository.findAll()) {
            if (owner.getLastName().equals(lastName)) {
                return owner;
            }
        }
        return null;
    }

    @Override
    public Set<Owner> findAll() {
        return mapRepository.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return mapRepository.findByKey(id);
    }

    @Override
    public Owner save(Owner entity) {
        return mapRepository.save(entity.getId(), entity);
    }

    @Override
    public void delete(Owner entity) {
        mapRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        mapRepository.deleteByKey(id);
    }
}
