package dev.mohsenkohan.petclinic.services.owner;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.repositories.jpa.OwnerRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@Profile("jpa")
public class OwnerServiceJpaImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceJpaImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Collection<Owner> findAllByLastNameLike(String lastName) {
        return ownerRepository.findAllByLastNameLike("%" + lastName + "%");
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName).orElseThrow();
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    @Override
    public Owner save(Owner entity) {
        return ownerRepository.save(entity);
    }

    @Override
    public void delete(Owner entity) {
        ownerRepository.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
