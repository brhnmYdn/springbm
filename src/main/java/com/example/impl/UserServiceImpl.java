package com.example.impl;

import com.example.entity.UserEntity;
import com.example.repository.UserRepository;
import com.example.request.UserRequest;
import com.example.response.ResultResponse;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResultResponse createUser(UserRequest userRequest) {

        ResultResponse resultResponse = new ResultResponse();
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setName(userRequest.getName());
        userEntity.setSurname(userRequest.getSurname());
        userEntity.setPassword(userRequest.getPassword());
        userEntity.setUsername(userRequest.getUsername());
        if (userRepository.getUserEntitiesByEmail(userRequest.getEmail()).size() <= 0){
            resultResponse.setMessage("Success");
            userRepository.save(userEntity);
        }
        else {
            resultResponse.setOperationResult("Unsuccess");
            resultResponse.setMessage("Aynı emaile bağlı birden fazla bir kayıt var.");
        }
        return resultResponse;
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.getUsers();
    }

    @Override
    public ResultResponse deleteUser(Integer id) {
        UserEntity userEntity = userRepository.getUserEntityById(id);
        ResultResponse resultResponse = new ResultResponse();
        try {
            userRepository.delete(userEntity);
            resultResponse.setOperationResult("Deleted");
            LOGGER.info("Deleted User" + userEntity.getId());
        }catch (Exception ex){
            LOGGER.error("Exception on deleting user, " + ex
            .getMessage());
            resultResponse.setOperationResult("UnDeleted");
        }
        return  resultResponse;
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        ResultResponse resultResponse = new ResultResponse();
        if (userRepository.getUserEntitiesByEmail(email).size() > 1){
            resultResponse.setMessage("Birden fazla kayıt vardır. ");
        }
        return userRepository.getUserEntityByEmail(email);
    }
}
