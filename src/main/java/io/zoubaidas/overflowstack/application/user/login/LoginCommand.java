package io.zoubaidas.overflowstack.application.user.login;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class LoginCommand {
    private String email;
    private String password;
}
