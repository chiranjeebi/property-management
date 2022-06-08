package com.mycompany.propertymanagement.controller;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("test addtion scenario sucess")
@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks
    private CalculatorController calculatorController;

    Double num1;
    Double num2;
    Double num3;

@BeforeEach
    void init(){
        System.out.println("Before each");
     num1= 11.5 ;
     num2=10.5 ;
     num3=5.5 ;
    }
@AfterEach
    void init(){
    num1= null ;
    num2=null ;
    num3=null ;
        System.out.println("After each");
    }


@Test
    void testAddFunction_Sucess(){
  Double result =  calculatorController.add(num1,num2,num3);

//expected value is 22
//perform assertion

    Assertions.assertEquals( 22,result);
}


    void testAddFunction_Fail(){
        Double result =  calculatorController.add(num1-0.5,num2,num3);



        Assertions.assertNotEquals( 23,result);
    }
}



