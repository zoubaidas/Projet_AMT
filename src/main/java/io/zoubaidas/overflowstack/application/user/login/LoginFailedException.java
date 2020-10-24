package io.zoubaidas.overflowstack.application.user.login;

import io.zoubaidas.overflowstack.application.BusinessException;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LoginFailedException extends BusinessException {

    public LoginFailedException(String message) {
        super(message);
    }
}
