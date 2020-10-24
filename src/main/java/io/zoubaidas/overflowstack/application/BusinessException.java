package io.zoubaidas.overflowstack.application;

public class BusinessException extends RuntimeException {
    private String message;

    public BusinessException(String message) {
        this.message = message;
    }
}
