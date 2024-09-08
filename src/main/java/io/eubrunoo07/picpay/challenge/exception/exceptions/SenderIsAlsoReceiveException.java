package io.eubrunoo07.picpay.challenge.exception.exceptions;

public class SenderIsAlsoReceiveException extends RuntimeException{
    public SenderIsAlsoReceiveException(String message) {
        super(message);
    }
}
