package io.eubrunoo07.picpay.challenge.exception.exceptions;

public class PasswordTooShortException extends RuntimeException{
    public PasswordTooShortException(String message) {
        super(message);
    }
}
