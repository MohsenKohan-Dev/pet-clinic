package dev.mohsenkohan.petclinic.services.owner;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.repositories.map.MapRepository;
import dev.mohsenkohan.petclinic.repositories.map.MapRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapImplTest {

    OwnerServiceMapImpl ownerServiceMap;

    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        MapRepository<Long, Owner> mapRepository = new MapRepositoryImpl<>();
        ownerServiceMap = new OwnerServiceMapImpl(mapRepository);

        Owner owner = new Owner();
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
    }

    @Test
    void findByLastNameFound() {
        Owner owner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(owner);
        assertEquals(lastName, owner.getLastName());
    }

    @Test
    void findByLastNameNotFound() {
        Owner owner = ownerServiceMap.findByLastName("xyz");

        assertNull(owner);
    }
}