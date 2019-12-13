package com.Desafio.web.error;

import lombok.Getter;

@Getter
public class CustomErrorType {
    private String errorMessage;

    public CustomErrorType(String error){
        errorMessage = error;
    }
}
