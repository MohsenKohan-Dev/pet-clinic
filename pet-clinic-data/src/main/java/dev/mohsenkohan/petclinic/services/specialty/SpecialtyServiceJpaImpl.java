package dev.mohsenkohan.petclinic.services.specialty;

import dev.mohsenkohan.petclinic.model.Specialty;
import dev.mohsenkohan.petclinic.repositories.jpa.SpecialtyRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class SpecialtyServiceJpaImpl implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceJpaImpl(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepository.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long id) {
        return specialtyRepository.findById(id).orElseThrow();
    }

    @Override
    public Specialty save(Specialty entity) {
        return specialtyRepository.save(entity);
    }

    @Override
    public void delete(Specialty entity) {
        specialtyRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }
}
