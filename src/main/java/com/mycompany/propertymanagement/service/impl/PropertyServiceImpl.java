package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    PropertyRepository propertyRepository;

      @Autowired                 //to memory allocate
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

      PropertyEntity pe =  propertyConverter.convertDTOtoEntity(propertyDTO);
      propertyRepository.save(pe);
        return null;
    }
}
