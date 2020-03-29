package dev.mohsenkohan.petclinic.services.vet;

import dev.mohsenkohan.petclinic.model.Vet;
import dev.mohsenkohan.petclinic.repositories.jpa.VetRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VetServiceJpaImpl implements VetService {

    private final VetRepository vetRepository;

    public VetServiceJpaImpl(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long id) {
        return vetRepository.findById(id).orElseThrow();
    }

    @Override
    public Vet save(Vet entity) {
        return vetRepository.save(entity);
    }

    @Override
    public void delete(Vet entity) {
        vetRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        vetRepository.deleteById(id);
    }
}
