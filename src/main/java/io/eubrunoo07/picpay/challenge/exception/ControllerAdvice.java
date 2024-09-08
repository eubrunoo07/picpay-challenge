package io.eubrunoo07.picpay.challenge.exception;

import io.eubrunoo07.picpay.challenge.exception.exceptions.*;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError methodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ApiError(e.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailALreadyExistsException.class)
    public ApiError emailALreadyExistsException(EmailALreadyExistsException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CpfOrCnpjAlreadyExistsException.class)
    public ApiError cpfOrCnpjAlreadyExistsException(CpfOrCnpjAlreadyExistsException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DocumentIsInvalidException.class)
    public ApiError documentIsInvalidException(DocumentIsInvalidException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PasswordTooShortException.class)
    public ApiError passwordTooShortException(PasswordTooShortException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotExistsException.class)
    public ApiError userNotExistsException(UserNotExistsException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MerchantCannotPerformTransferException.class)
    public ApiError merchantCannotPerformTransferException(MerchantCannotPerformTransferException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BalanceIsLessThanTransferValueException.class)
    public ApiError balanceIsLessThanTransferValueException(BalanceIsLessThanTransferValueException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TransferValueIsInvalidException.class)
    public ApiError transferValueIsInvalidException(TransferValueIsInvalidException e){
        return new ApiError(e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SenderIsAlsoReceiveException.class)
    public ApiError senderIsAlsoReceiveException(SenderIsAlsoReceiveException e){
        return new ApiError(e.getMessage());
    }
  }
