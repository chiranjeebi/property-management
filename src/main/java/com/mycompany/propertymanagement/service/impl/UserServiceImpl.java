package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity>  optUe =userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
        if (optUe.isPresent()){
            List<ErrorModel> errorModelList=new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXITS");
            errorModel.setMessage("The Email Which You Are Trying is already Exits!!!");
            errorModelList.add(errorModel);

            throw new BusinessException(errorModelList);

        }
        UserEntity userEntity= userConverter.convertDTOtoEntity(userDTO);
        userEntity = userRepository.save(userEntity);
        userDTO= userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
UserDTO userDTO=null;
      Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);
   if(optionalUserEntity.isPresent()){
userDTO=userConverter.convertEntityToDTO(optionalUserEntity.get());

   }else {
       List<ErrorModel> errorModelList=new ArrayList<>();
       ErrorModel errorModel=new ErrorModel();
       errorModel.setCode("INVALID_LOGIN");
       errorModel.setMessage("incorrect Email & password");
       errorModelList.add(errorModel);

       throw new BusinessException(errorModelList);
  }
        return userDTO;
    }
}