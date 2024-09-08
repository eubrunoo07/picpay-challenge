package io.eubrunoo07.picpay.challenge.exception;

import io.eubrunoo07.picpay.challenge.exception.exceptions.CpfOrCnpjAlreadyExistsException;
import io.eubrunoo07.picpay.challenge.exception.exceptions.DocumentIsInvalidException;
import io.eubrunoo07.picpay.challenge.exception.exceptions.EmailALreadyExistsException;
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

  }
