package dev.mohsenkohan.petclinicdata.services.owner;

import dev.mohsenkohan.petclinicdata.model.Owner;
import dev.mohsenkohan.petclinicdata.services.CrudService;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
