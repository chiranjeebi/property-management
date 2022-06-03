package com.mycompany.propertymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.aspectj.bridge.IMessage;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private Long id;
    private String ownerName;
 @NotNull(message= "Owner email is mandatory")
 @NotEmpty(message = " cannot be empty")
 @Size(min = 1,max = 50 ,message = "owner email should be between 1 to 50 charecter in length")
    private String ownerEmail;
    private String phone;
    @NotNull(message = "password is mandatory")
@NotEmpty(message = "password cannot be empty")
    private  String password;

}
