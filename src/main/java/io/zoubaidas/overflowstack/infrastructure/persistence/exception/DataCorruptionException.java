package io.zoubaidas.overflowstack.infrastructure.persistence.exception;

import lombok.Value;

@Value
public class DataCorruptionException extends RuntimeException{
    private String message;
}
