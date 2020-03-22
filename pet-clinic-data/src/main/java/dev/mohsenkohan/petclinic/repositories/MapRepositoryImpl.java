package dev.mohsenkohan.petclinic.repositories;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
@Scope("prototype")
public class MapRepositoryImpl<K, V> implements MapRepository<K, V> {

    private final Map<K, V> map;

    public MapRepositoryImpl() {
        this.map = new HashMap<>();
    }

    @Override
    public Set<V> findAll() {
        return new HashSet<>(map.values());
    }

    @Override
    public V findByKey(K key) {
        return map.get(key);
    }

    @Override
    public V save(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public void delete(V value) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(value));
    }

    @Override
    public void deleteByKey(K key) {
        map.remove(key);
    }
}
