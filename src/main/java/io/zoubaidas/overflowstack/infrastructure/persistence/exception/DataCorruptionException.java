package io.zoubaidas.overflowstack.infrastructure.persistence.exception;


public class DataCorruptionException extends RuntimeException{
    public DataCorruptionException(String message){
        super(message);
    }
}
