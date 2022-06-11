package com.mycompany.propertymanagement.dto;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.meanbean.test.BeanTester;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DTOTester {
    @Test
    @DisplayName("test all DTO's getter setter")
    void testAllDtos(){
        BeanTester beanTester=new BeanTester();
        beanTester.testBean(CalculatorDTO.class); //testbean use to test the class which we want to test
beanTester.testBean(PropertyDTO.class);
beanTester.testBean(UserDTO.class);
    }



}
