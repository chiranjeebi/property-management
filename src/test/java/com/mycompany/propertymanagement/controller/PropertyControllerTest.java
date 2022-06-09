package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.service.PropertyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class PropertyControllerTest {

      @InjectMocks
      private PropertyController propertyController;  //mocikto is going to create a proxy object and proxy object for property controller and inject to our PropertyControllerTest

      @Mock // mocito wll give memory  to product service and it will inject this dummy/procy property service onject inside the proxy obj of property c
      private PropertyService propertyService;

      @Test
      @DisplayName("sucess scenario for saving property")
      void testSaveProperty(){

            PropertyDTO dto =new PropertyDTO();
            dto.setTitle("dummmy property");


            PropertyDTO savedProperty =new PropertyDTO();
    savedProperty.setId(1L);
    savedProperty.setTitle(dto.getTitle());

            ResponseEntity<PropertyDTO> responseEntity = propertyController.saveProperty(dto);
            Assertions.assertNotNull(responseEntity.getBody().getId());
            Assertions.assertEquals(HttpStatus.CREATED.value(),responseEntity.getStatusCodeValue());

      }


      @Test
      @DisplayName("sucess scenario for fetch all properties properties")
      void getProperties(){
          List<PropertyDTO> propertyList = new ArrayList<>();
          PropertyDTO dto=new PropertyDTO();
          dto.setId(1L);
          dto.setTitle("'dummy prpoerty");
          propertyList.add(dto);
          // do not make the actual call for this propertyService getAllProperties() inside controller rather return dummy object which is  List<PropertyDTO> in the controller
          Mockito.when(propertyService.getAllProperties()).thenReturn(propertyList);


          propertyController.getAllProperties();

      }
}
