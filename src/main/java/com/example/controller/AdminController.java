package com.example.controller;

import com.example.entity.AdminEntity;
import com.example.request.AdminRequest;
import com.example.response.ResultResponse;
import com.example.impl.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "Admin Rest Api", description = "Admin Rest Service")
@RestController
@RequestMapping(value = "/api")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @ApiOperation(value = "List of Admins", response = AdminEntity.class )
    @RequestMapping(value = "/admin/getAdmins", method = RequestMethod.GET)
    public List<AdminEntity> getAdmins() {
        return adminServiceImpl.getAdmins();
    }

    @ApiOperation(value = "Create Admin ", response = AdminEntity.class)
    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public AdminEntity createAdmin(@RequestBody AdminRequest adminRequest){
        return adminServiceImpl.create(adminRequest);
    }

    @ApiOperation(value = "Login in the System ", response = ResultResponse.class)
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultResponse adminLogin(@RequestBody AdminRequest adminRequest) {
        return adminServiceImpl.adminLogin(adminRequest);
    }

    @ApiOperation(value = "Get Admin ", response = AdminEntity.class)
    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET)
    @ResponseBody
    public AdminEntity getAdminById(@PathVariable Integer id){
        return adminServiceImpl.getAdminById(id);
    }
}
