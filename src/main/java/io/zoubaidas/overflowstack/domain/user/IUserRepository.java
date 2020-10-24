package io.zoubaidas.overflowstack.domain.user;

import io.zoubaidas.overflowstack.domain.IRepository;

import java.util.Optional;

public interface IUserRepository extends IRepository<User, UserId> {
    public Optional<User> findByUsername(String username);

}
