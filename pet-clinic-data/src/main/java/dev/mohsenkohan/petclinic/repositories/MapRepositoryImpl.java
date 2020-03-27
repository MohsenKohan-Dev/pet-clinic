package dev.mohsenkohan.petclinic.repositories;

import dev.mohsenkohan.petclinic.model.BaseEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
@Scope("prototype")
public class MapRepositoryImpl<K extends Number, V extends BaseEntity> implements MapRepository<K, V> {

    private Long id;
    private final Map<Long, V> map;

    public MapRepositoryImpl() {
        id = 1L;
        this.map = new HashMap<>();
    }

    @Override
    public Set<V> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public V findById(K key) {
        return map.get(key);
    }

    @Override
    public V save(V value) {
        value.setId(nextId());
        map.put(value.getId(), value);
        return value;
    }

    @Override
    public void delete(V value) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(value));
    }

    @Override
    public void deleteById(K key) {
        map.remove(key);
    }

    private Long nextId() {
        return id++;
    }
}
