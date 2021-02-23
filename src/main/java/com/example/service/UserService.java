package com.example.service;

import com.example.entity.UserEntity;
import com.example.request.UserRequest;
import com.example.response.ResultResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    ResultResponse createUser(UserRequest userRequest);
    List<UserEntity> getUsers();
    ResultResponse deleteUser(Integer id);
    UserEntity getUserByEmail(String email);

}
