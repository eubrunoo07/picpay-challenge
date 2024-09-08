package io.eubrunoo07.picpay.challenge.exception;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class ApiError {
    private final List<String> errors;

    public ApiError(String error){
        this.errors = Collections.singletonList(error);
    }

    public ApiError(List<String> errors){
        this.errors = errors;
    }
}
