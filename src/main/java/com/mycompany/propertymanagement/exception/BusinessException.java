package com.mycompany.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    private List<ErrorModel> errors;   //calling errormodel class



    public BusinessException(List<ErrorModel> errors){              //parameterized Constructer
        this.errors=errors;


    }
    private String message;

   public BusinessException(String message){
        this.message= message;

   }
}
