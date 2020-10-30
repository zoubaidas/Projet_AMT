package io.zoubaidas.overflowstack.domain;

import java.util.Collection;
import java.util.Optional;

public interface IRepository<ENTITY extends IEntity, ID extends Id> {
    void save(ENTITY entity);

    void remove(ID id);

    Optional<ENTITY> findById(ID id);

    Collection<ENTITY> findAll();
}
