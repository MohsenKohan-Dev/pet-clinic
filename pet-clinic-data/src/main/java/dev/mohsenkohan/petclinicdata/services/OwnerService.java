package dev.mohsenkohan.petclinicdata.services;

import dev.mohsenkohan.petclinicdata.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
