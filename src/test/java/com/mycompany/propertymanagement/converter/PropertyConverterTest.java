package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PropertyConverterTest {

    @InjectMocks
    private PropertyConverter propertyConverter;

    @Test
    void testConvertDTOtoEntity_Sucess(){

        PropertyDTO dto =new PropertyDTO();

        dto.setTitle("dummy 3 ");
        dto.setPrice(324.54);
       PropertyEntity propertyEntity = propertyConverter.convertDTOtoEntity(dto);
        Assertions.assertEquals(dto.getPrice(), propertyEntity.getPrice());
        Assertions.assertEquals(dto.getTitle(), propertyEntity.getTitle());

    }


    @Test
void testConvertEntitytoDTO(){


     PropertyEntity entity=new PropertyEntity();

        entity.setTitle("dummy 4 ");
        entity.setPrice(23456.54);
        PropertyDTO propertyDTO = propertyConverter.convertEntitytoDTO(entity);
        Assertions.assertEquals(entity.getPrice(), propertyDTO.getPrice());
        Assertions.assertEquals(entity.getTitle(), propertyDTO.getTitle());

    }

}
