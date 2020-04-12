package dev.mohsenkohan.petclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet extends NamedEntity {

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    private Set<Visit> visits;

    private Set<Visit> getVisitsInternal() {
        return visits == null ? new LinkedHashSet<>() : visits;
    }

    public void addVisit(Visit visit) {
        if (visit.isNew()) {
            getVisitsInternal().add(visit);
        }
        visit.setPet(this);
    }
}
