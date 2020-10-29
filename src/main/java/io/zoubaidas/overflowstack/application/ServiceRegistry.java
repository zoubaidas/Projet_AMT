package io.zoubaidas.overflowstack.application;

import io.zoubaidas.overflowstack.application.user.signinup.LoginAndRegisterFacade;
import io.zoubaidas.overflowstack.infrastructure.persistence.memory.InMemoryUserRepository;


public class ServiceRegistry {
    private  static InMemoryUserRepository userRepository = new InMemoryUserRepository();;
    private static LoginAndRegisterFacade loginAndRegisterFacade = new LoginAndRegisterFacade(userRepository);

    public  static LoginAndRegisterFacade getLoginAndRegisterFacade() {
        return loginAndRegisterFacade;
    }

    public ServiceRegistry() {
    }
}
