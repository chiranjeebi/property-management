package com.mycompany.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

     private String title;
    private String descripition;
    private String ownerName;
    private String ownerEmail;
    private Double price;
    private String address;
}
