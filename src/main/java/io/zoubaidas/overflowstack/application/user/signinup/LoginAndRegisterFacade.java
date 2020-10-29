package io.zoubaidas.overflowstack.application.user.signinup;

import io.zoubaidas.overflowstack.application.user.UserDTO;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginCommand;
import io.zoubaidas.overflowstack.application.user.signinup.login.LoginFailedException;
import io.zoubaidas.overflowstack.application.user.signinup.register.RegisterCommand;
import io.zoubaidas.overflowstack.application.user.signinup.register.RegistrationFailedException;
import io.zoubaidas.overflowstack.domain.user.IUserRepository;
import io.zoubaidas.overflowstack.domain.user.User;


public class LoginAndRegisterFacade {
    private IUserRepository userRepository;

    public LoginAndRegisterFacade(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO register(RegisterCommand command) throws RegistrationFailedException {
        User existingUser = userRepository.findByUsername(command.getUsername()).orElse(null);

        if (existingUser != null) {
            throw new RegistrationFailedException("Used username ");
        }
        User user = User.builder()
                .username(command.getUsername())
                .email(command.getEmail())
                .firstName(command.getFirstName())
                .lastName(command.getLastName())
                .clearPwd(command.getPassword())
                .build();
        userRepository.save(user);

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();
    }

    public UserDTO login(LoginCommand command) throws LoginFailedException {
        User user = userRepository.findByUsername(command.getUsername()).orElseThrow(() -> new LoginFailedException("User doesn't exist"));

        if (!user.login(command.getPassword()))
            throw new LoginFailedException("Wrong password");

        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

    }
}
