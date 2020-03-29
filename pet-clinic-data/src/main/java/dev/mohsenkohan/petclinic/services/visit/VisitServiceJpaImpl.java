package dev.mohsenkohan.petclinic.services.visit;

import dev.mohsenkohan.petclinic.model.Visit;
import dev.mohsenkohan.petclinic.repositories.jpa.VisitRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class VisitServiceJpaImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceJpaImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAllByPetId(Long id) {
        return null;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long id) {
        return visitRepository.findById(id).orElseThrow();
    }

    @Override
    public Visit save(Visit entity) {
        return visitRepository.save(entity);
    }

    @Override
    public void delete(Visit entity) {
        visitRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        visitRepository.deleteById(id);
    }
}
