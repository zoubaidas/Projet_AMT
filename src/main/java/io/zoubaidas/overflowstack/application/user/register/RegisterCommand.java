package io.zoubaidas.overflowstack.application.user.register;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegisterCommand {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

}
