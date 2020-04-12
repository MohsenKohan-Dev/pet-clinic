package dev.mohsenkohan.petclinic.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

    @Override
    public String toString() {
        return getName();
    }
}
