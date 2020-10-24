package io.zoubaidas.overflowstack.application.user.register;

import io.zoubaidas.overflowstack.application.BusinessException;

public class RegistrationFailedException extends BusinessException {

    public RegistrationFailedException(String message) {
        super(message);
    }
}
