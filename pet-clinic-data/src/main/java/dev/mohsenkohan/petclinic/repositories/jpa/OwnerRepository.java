package dev.mohsenkohan.petclinic.repositories.jpa;

import dev.mohsenkohan.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Optional<Owner> findByLastName(String lastName);

    Collection<Owner> findAllByLastNameLike(String lastName);
}
