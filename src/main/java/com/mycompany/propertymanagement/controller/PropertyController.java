package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class PropertyController {
    //RESTfull API is just mapping of a url to a java class function
         //localhost:8081/api/v1/properties/hello/ -->this url mapped to a function that is what RESTful web services
   @Autowired
    private PropertyService propertyService;

@GetMapping("/hello")
    public String sayHello(){

    return  "hello";
    }

    @PostMapping("/properties")
public PropertyDTO saveProperty(@RequestBody PropertyDTO propertyDTO){
   propertyService.saveProperty(propertyDTO);
    System.out.println(propertyDTO);
    return propertyDTO;




}










}
