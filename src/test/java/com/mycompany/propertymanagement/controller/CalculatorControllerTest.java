package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.CalculatorDTO;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@DisplayName("test addtion scenario sucess")
@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {
    @InjectMocks                  //to give it to memory other wise we get null pointer exception
    private CalculatorController calculatorController;      //we can call calculator class here so that we can call its method

   static Double num1;
    static Double num2;
    static Double num3;

    @BeforeAll                         //the intialization happen only once
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
    static void afterAll(){                     ////the De-intialization happen only once
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
    @Test
    @DisplayName("Test multiplication")
    void testMultiply(){
        CalculatorDTO calculatorDTO=new CalculatorDTO();
calculatorDTO.setNum1(num1);
calculatorDTO.setNum2(num2);
calculatorDTO.setNum3(num3);
calculatorDTO.setNum4(2.0);

     ResponseEntity<Double> responseEntity = calculatorController.multiply(calculatorDTO);
     assertEquals(1328.25,responseEntity.getBody());
     assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCodeValue(),"expecting the status as created");
    }

}



