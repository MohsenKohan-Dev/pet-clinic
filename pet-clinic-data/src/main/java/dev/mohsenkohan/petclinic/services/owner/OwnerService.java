package dev.mohsenkohan.petclinic.services.owner;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.services.CrudService;

import java.util.Collection;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    Collection<Owner> findAllByLastNameLike(String lastName);
}
