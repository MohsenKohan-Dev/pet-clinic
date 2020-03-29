package dev.mohsenkohan.petclinic.repositories.map;

import dev.mohsenkohan.petclinic.services.CrudService;

public interface MapRepository<K, V> extends CrudService<V, K> {
}
