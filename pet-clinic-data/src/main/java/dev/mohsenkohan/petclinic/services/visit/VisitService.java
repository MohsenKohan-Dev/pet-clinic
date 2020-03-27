package dev.mohsenkohan.petclinic.services.visit;

import dev.mohsenkohan.petclinic.model.Visit;
import dev.mohsenkohan.petclinic.services.CrudService;

import java.util.Set;

public interface VisitService extends CrudService<Visit, Long> {

    Set<Visit> findAllByPetId(Long id);
}
