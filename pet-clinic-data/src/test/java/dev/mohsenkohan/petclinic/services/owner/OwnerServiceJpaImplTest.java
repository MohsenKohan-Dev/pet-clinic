package dev.mohsenkohan.petclinic.services.owner;

import dev.mohsenkohan.petclinic.model.Owner;
import dev.mohsenkohan.petclinic.repositories.jpa.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerServiceJpaImplTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerServiceJpaImpl ownerServiceJpa;

    final String LAST_NAME = "Smith";
    final Long ID = 1L;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(ID);
        owner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastNameFound() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.of(owner));

        Owner owner = ownerServiceJpa.findByLastName(LAST_NAME);

        assertNotNull(owner);
        assertEquals(LAST_NAME, owner.getLastName());

        verify(ownerRepository).findByLastName(anyString());
    }

    @Test
    void findByLastNameNotFound() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> ownerServiceJpa.findByLastName(LAST_NAME));

        verify(ownerRepository).findByLastName(anyString());
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = Set.of(owner);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerServiceJpa.findAll();

        assertNotNull(owners);
        assertEquals(1, owners.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findByIdFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner owner = ownerServiceJpa.findById(ID);

        assertNotNull(owner);
        assertEquals(ID, owner.getId());

        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void findByIdNotFound() {
//        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> ownerServiceJpa.findById(ID));

        verify(ownerRepository).findById(anyLong());
    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerServiceJpa.save(owner);

        assertNotNull(savedOwner);
        assertEquals(owner.getId(), savedOwner.getId());

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        ownerServiceJpa.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerServiceJpa.deleteById(ID);

        verify(ownerRepository).deleteById(anyLong());
    }
}