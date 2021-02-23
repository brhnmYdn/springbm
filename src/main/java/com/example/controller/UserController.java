package com.example.controller;

import com.example.entity.UserEntity;
import com.example.impl.UserServiceImpl;
import com.example.request.UserRequest;
import com.example.response.ResultResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "User Rest Api", description = "User Rest Service")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse createUser(@RequestBody UserRequest userRequest){
        return userServiceImpl.createUser(userRequest);
    }

    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse deleteUser(@PathVariable Integer id){
        return userServiceImpl.deleteUser(id);
    }


    @RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
    @ResponseBody
    public UserEntity getUserByEmail(@PathVariable String email){
        return userServiceImpl.getUserByEmail(email);
    }


    @RequestMapping(value = "/user/users", method = RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> getUsers(){
        return userServiceImpl.getUsers();
    }
}
