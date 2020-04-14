package dev.mohsenkohan.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    @NotEmpty
    private String address;

    @Column(name = "city")
    @NotEmpty
    private String city;

    @Column(name = "telephone")
    @Digits(integer = 10, fraction = 0)
    private String telephone;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Pet> pets;

    private Set<Pet> getPetsInternal() {
        return pets == null ? new HashSet<>() : pets;
    }

    public void addPet(Pet pet) {
        if (pet.isNew()) {
            getPetsInternal().add(pet);
        }
        pet.setOwner(this);
    }
}
