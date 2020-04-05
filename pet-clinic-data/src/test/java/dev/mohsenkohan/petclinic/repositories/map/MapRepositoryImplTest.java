package dev.mohsenkohan.petclinic.repositories.map;

import dev.mohsenkohan.petclinic.model.BaseEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapRepositoryImplTest {

    MapRepositoryImpl<Long, BaseEntity> mapRepository;
    BaseEntity entity;
    final Long id = 1L;

    @BeforeEach
    void setUp() {
        mapRepository = new MapRepositoryImpl<>();
        entity = new BaseEntity();
        entity = mapRepository.save(entity);
    }

    @Test
    void findAll() {
        Set<BaseEntity> entities = mapRepository.findAll();

        assertEquals(1, entities.size());
        assertTrue(entities.contains(entity));
    }

    @Test
    void findById() {
        BaseEntity entity = mapRepository.findById(id);

        assertEquals(id, entity.getId());
    }

    @Test
    void save() {
        BaseEntity entity = new BaseEntity();
        BaseEntity savedEntity = mapRepository.save(entity);

        assertEquals(2, mapRepository.findAll().size());
        assertNotNull(savedEntity);
        assertEquals(2L, savedEntity.getId());
    }

    @Test
    void delete() {
        mapRepository.delete(entity);

        assertEquals(0, mapRepository.findAll().size());
    }

    @Test
    void deleteById() {
        mapRepository.deleteById(id);

        assertEquals(0, mapRepository.findAll().size());
    }
}