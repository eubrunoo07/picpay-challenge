package io.eubrunoo07.picpay.challenge.exception.exceptions;

public class BalanceIsLessThanTransferValueException extends RuntimeException{
    public BalanceIsLessThanTransferValueException(String message) {
        super(message);
    }
}
