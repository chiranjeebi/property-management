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

   static Double num1;
    static Double num2;
    static Double num3;

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before All");
        num1= 11.5 ;
        num2=10.5 ;
        num3=5.5 ;
    }


@BeforeEach
    void init(){
        System.out.println("Before each");
     num1= 11.5 ;
     num2=10.5 ;
     num3=5.5 ;
    }

@AfterAll
    static void afterAll(){
        System.out.println("After All");
    num1= null;
    num2=null;
    num3=null;
    }

    @AfterEach
    void destroy(){

        System.out.println("After each");
    }


@Test
@DisplayName("Test addtion for sucess")
@Disabled
    void testAddFunction_Sucess(){
  Double result =  calculatorController.add(num1,num2,num3);
  //expected value is 22
//perform assertion
 Assertions.assertEquals( 22,result);
}
@Test
    @DisplayName("Test addtion for failure")
    void testAddFunction_Failuer(){
        Double result =  calculatorController.add(num1-0.5,num2,num3);
 Assertions.assertNotEquals( 23,result);
    }

    @Test
    @DisplayName("Test subtract for num1 & num2")
    void testSubFunction_num1_gt_num2(){
        Double result =  calculatorController.subtract(num1,num2);
        Assertions.assertEquals(1,result);
    }

    @Test
    @DisplayName("Test subtract for num1 & num2")
    void testSubFunction_num1_lt_num2(){
        Double result =  calculatorController.subtract(num1,num2+1);
        Assertions.assertEquals(1,result);
    }


}



