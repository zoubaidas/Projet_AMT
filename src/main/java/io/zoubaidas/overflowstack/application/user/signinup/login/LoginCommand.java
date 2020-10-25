package io.zoubaidas.overflowstack.application.user.signinup.login;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class LoginCommand {
    private String username;
    private String password;
}
