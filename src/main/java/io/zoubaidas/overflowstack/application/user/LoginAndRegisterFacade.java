package io.zoubaidas.overflowstack.application.user;

import io.zoubaidas.overflowstack.application.user.login.LoginCommand;
import io.zoubaidas.overflowstack.application.user.login.LoginFailedException;
import io.zoubaidas.overflowstack.application.user.register.RegisterCommand;
import io.zoubaidas.overflowstack.application.user.register.RegistrationFailedException;
import io.zoubaidas.overflowstack.domain.user.IUserRepository;
import io.zoubaidas.overflowstack.domain.user.User;


public class LoginAndRegisterFacade {
    private IUserRepository userRepository;

    public LoginAndRegisterFacade(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(RegisterCommand command) throws RegistrationFailedException {
        User existingUser = userRepository.findByUsername(command.getUsername()).orElse(null);

        if (existingUser != null) {
            throw new RegistrationFailedException("Used username ");
        }

        try {
            User user = User.builder()
                    .username(command.getUsername())
                    .email(command.getEmail())
                    .firstName(command.getFirstName())
                    .lastName(command.getLastName())
                    .clearPwd(command.getPassword())
                    .build();
            userRepository.save(user);
        } catch (Exception e) {
            throw new RegistrationFailedException(e.getMessage());
        }
    }

    public UserDTO login(LoginCommand command) throws LoginFailedException {
        User user = userRepository.findByUsername(command.getUsername()).orElseThrow(() -> new LoginFailedException("User doesn't exist"));

        if (!user.login(command.getPassword()))
            throw new LoginFailedException("Wrong password");

        return UserDTO.builder()
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

    }
}
