package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.impl.PropertyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.framework;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class PropertyServiceImplTest {

    @InjectMocks
    private PropertyServiceImpl propertyServiceImpl;
    @Mock
    private PropertyConverter propertyConverter;
@Mock
    private PropertyRepository propertyRepository;

    @Test
    void testSaveProperty_Success(){
        PropertyDTO dto=new PropertyDTO();
        dto.setTitle("dummy");

        PropertyEntity propertyEntity=new PropertyEntity();
        propertyEntity.setTitle("Dummy");

       PropertyEntity savedEntity =new PropertyEntity();
       savedEntity.setTitle("Dummy");
       savedEntity.setId(1L);

       PropertyDTO savedDTO=new PropertyDTO();
       savedDTO.setTitle("Dummy");
       savedDTO.setId(1L);

        Mockito.when(propertyConverter.convertDTOtoEntity(Mockito.any())).thenReturn(propertyEntity);
   Mockito.when(propertyRepository.save(Mockito.any())).thenReturn(savedEntity);
   Mockito.when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);

    PropertyDTO result =    propertyServiceImpl.saveProperty(dto);
        Assertions.assertEquals(savedDTO.getId(),result.getId());


    }

    @Test
    void testGetAllProperties_success(){

       List<PropertyEntity> propertyEntities = new ArrayList<>();
        PropertyEntity propertyEntity =new PropertyEntity();
        propertyEntity.setId(1L);
        propertyEntity.setTitle("dummy");
        propertyEntities.add(propertyEntity);

        PropertyDTO savedDTO=new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);

        Mockito.when(propertyRepository.findAll()).thenReturn(propertyEntities);
        Mockito.when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);
       List<PropertyDTO> listPropsDTO= propertyServiceImpl.getAllProperties();
Assertions.assertEquals(1,listPropsDTO.size());
    }

    @Test
void testUpdateProperty_Success(){

        PropertyDTO savedDTO =new PropertyDTO();
        savedDTO.setTitle("Dummy");
        savedDTO.setId(1L);
        savedDTO.setPrice(324.4);
        savedDTO.setDescription("dhadsd");
        savedDTO.setAddress("xyz");
        savedDTO.setOwnerName("dsa@gmail.com");
        savedDTO.setOwnerName("jhon");



      PropertyEntity pe=new PropertyEntity();
      pe.setId(1L);
        pe.setTitle("Dummy");
      pe.setPrice(324.4);
        pe.setDescription("dhadsd");
        pe.setAddress("xyz");
        pe.setOwnerName("dsa@gmail.com");
        pe.setOwnerName("jhon");
        when(propertyRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pe));
when(propertyConverter.convertEntitytoDTO(Mockito.any())).thenReturn(savedDTO);

       PropertyDTO updatedPeoperty= propertyServiceImpl.updateProperty(savedDTO,1L);
       Assertions.assertEquals(savedDTO.getTitle(),updatedPeoperty.getTitle());
        Assertions.assertEquals(savedDTO.getPrice(),updatedPeoperty.getPrice());
        Assertions.assertEquals(savedDTO.getDescription(),updatedPeoperty.getDescription());
        Assertions.assertEquals(savedDTO.getOwnerEmail(),updatedPeoperty.getOwnerEmail());
        Assertions.assertEquals(savedDTO.getAddress(),updatedPeoperty.getAddress());
    }


    @Test
    void testUpdatePropertyDescription_Success(){




    }

}
