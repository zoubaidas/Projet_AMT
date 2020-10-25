package io.zoubaidas.overflowstack.application;

import io.zoubaidas.overflowstack.application.user.signinup.LoginAndRegisterFacade;
import io.zoubaidas.overflowstack.infrastructure.persistence.memory.InMemoryUserRepository;

public class ServiceRegistry {
    private InMemoryUserRepository userRepository;
    private LoginAndRegisterFacade loginAndRegisterFacade;

    public LoginAndRegisterFacade getLoginAndRegisterFacade() {
        return loginAndRegisterFacade;
    }

    public ServiceRegistry() {
        userRepository = new InMemoryUserRepository();
        loginAndRegisterFacade = new LoginAndRegisterFacade(userRepository);
    }
}
