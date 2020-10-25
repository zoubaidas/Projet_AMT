package io.zoubaidas.overflowstack.application.user.signinup.login;

import io.zoubaidas.overflowstack.application.BusinessException;
import lombok.Builder;
import lombok.Value;

public class LoginFailedException extends BusinessException {

    public LoginFailedException(String message) {
        super(message);
    }
}
