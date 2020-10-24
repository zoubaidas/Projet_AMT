package io.zoubaidas.overflowstack.infrastructure.persistence.exception;

import lombok.Value;

@Value
public class IntegrityConstraintViolationException extends RuntimeException{
    private String message;
}
