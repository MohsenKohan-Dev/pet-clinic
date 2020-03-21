package dev.mohsenkohan.petclinicdata.repositories;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapRepositoryImpl<K, V> implements MapRepository<K, V> {

    private final Map<K, V> map;

    public MapRepositoryImpl(Map<K, V> map) {
        this.map = map;
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
    public V save(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public void delete(V value) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(value));
    }

    @Override
    public void deleteById(K key) {
        map.remove(key);
    }
}
