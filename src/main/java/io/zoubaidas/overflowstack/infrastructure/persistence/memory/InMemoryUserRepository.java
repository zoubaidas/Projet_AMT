package io.zoubaidas.overflowstack.infrastructure.persistence.memory;

import io.zoubaidas.overflowstack.domain.user.IUserRepository;
import io.zoubaidas.overflowstack.domain.user.User;
import io.zoubaidas.overflowstack.domain.user.UserId;
import io.zoubaidas.overflowstack.infrastructure.persistence.exception.DataCorruptionException;
import io.zoubaidas.overflowstack.infrastructure.persistence.exception.IntegrityConstraintViolationException;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryUserRepository extends InMemoryRepository<User, UserId> implements IUserRepository {

    @Override
    public void save(User user){
        synchronized (user.getUsername()){
            if(!findByUsername(user.getUsername()).isEmpty()){
                throw new IntegrityConstraintViolationException("username already exists");
            }
        }
        super.save(user);
    }


    public Optional<User> findByUsername(String username){
        List<User> matchingUsers = findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .collect(Collectors.toList());

        matchingUsers.add(User.builder()
                .username("zied")
                .clearPwd("zied")
                .firstName("zied")
                .lastName("zied")
                .email("zied")
                .build());

        if (matchingUsers.size() < 1 ){
            return Optional.empty();
        }

        if (matchingUsers.size() > 1 ){
            throw new DataCorruptionException("More than one User have this username");
        }

        return Optional.of(matchingUsers.get(0).deepClone());
    }
}
