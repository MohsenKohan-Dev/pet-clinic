package dev.mohsenkohan.petclinic.repositories;

import java.util.Set;

public interface MapRepository<K, V> {

    Set<V> findAll();

    V findByKey(K key);

    V save(K key, V value);

    void delete(V value);

    void deleteByKey(K key);
}
