package io.zoubaidas.overflowstack.infrastructure.persistence.exception;


public class IntegrityConstraintViolationException extends RuntimeException{
    public IntegrityConstraintViolationException(String message){
        super(message);
    }
}
