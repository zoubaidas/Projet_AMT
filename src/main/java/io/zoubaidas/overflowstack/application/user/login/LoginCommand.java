package io.zoubaidas.overflowstack.application.user.login;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoginCommand {
    private String email;
    private String password;
}
