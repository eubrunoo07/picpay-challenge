package io.eubrunoo07.picpay.challenge.exception.exceptions;

public class CpfOrCnpjAlreadyExistsException extends RuntimeException{
    public CpfOrCnpjAlreadyExistsException(String message) {
        super(message);
    }
}
