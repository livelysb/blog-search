package com.sample.blogsearch.api.controller;

import com.sample.blogsearch.api.controller.response.ErrorApiResponse;
import com.sample.blogsearch.domain.common.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class BlogSearchControllerAdvice {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorApiResponse handleBindException(MethodArgumentNotValidException e) {
        return new ErrorApiResponse(ErrorType.BAD_REQUEST,
                e.getBindingResult().getFieldErrors().stream()
                        .map(v -> {
                            if (v.getCodes() != null && Arrays.asList(v.getCodes()).contains("typeMismatch")) {
                                return "'" + v.getField() + "' 값을 올바르게 입력해주세요.";
                            } else {
                                return v.getDefaultMessage();
                            }
                        }).toList().toString());
    }

}
