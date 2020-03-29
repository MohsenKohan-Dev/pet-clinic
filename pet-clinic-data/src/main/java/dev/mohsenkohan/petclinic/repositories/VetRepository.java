package dev.mohsenkohan.petclinic.repositories;

import dev.mohsenkohan.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
