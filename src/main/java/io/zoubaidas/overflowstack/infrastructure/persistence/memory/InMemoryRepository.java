package io.zoubaidas.overflowstack.infrastructure.persistence.memory;

import io.zoubaidas.overflowstack.domain.IEntity;
import io.zoubaidas.overflowstack.domain.IRepository;
import io.zoubaidas.overflowstack.domain.Id;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public abstract class InMemoryRepository<ENTITY extends IEntity<ENTITY, ID>, ID extends Id> implements IRepository<ENTITY, ID> {
    private Map<ID, ENTITY> store = new ConcurrentHashMap<>();

    public void save(ENTITY entity) {
        store.put(entity.getId(), entity);
    }

    public void remove(ID id) {
        store.remove(id);
    }

    public Optional<ENTITY> findById(ID id) {
        ENTITY entity = store.get(id);
        if (entity == null) {
            return Optional.empty();
        }
        ENTITY clonedEntity = entity.deepClone();
        return Optional.of(clonedEntity);
    }

    public Collection<ENTITY> findAll() {
        return store.values().stream()
                .map(entity -> entity.deepClone())
                .collect(Collectors.toList());
    }
}
