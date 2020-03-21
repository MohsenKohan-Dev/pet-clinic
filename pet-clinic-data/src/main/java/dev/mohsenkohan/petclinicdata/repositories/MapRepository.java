package dev.mohsenkohan.petclinicdata.repositories;

import java.util.Set;

public interface MapRepository<K, V> {

    Set<V> findAll();

    V findById(K key);

    V save(K key, V value);

    void delete(V value);

    void deleteById(K key);
}
