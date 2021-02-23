package com.example.impl;

import com.example.entity.AdminEntity;
import com.example.repository.AdminRepository;
import com.example.request.AdminRequest;
import com.example.response.ResultResponse;
import com.example.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminRepository adminRepository;

    public AdminEntity create(AdminRequest adminRequest){
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setEmail(adminRequest.getEmail());
        adminEntity.setPassword(adminRequest.getPassword());
        adminEntity.setUsername(adminRequest.getUsername());
        return adminRepository.save(adminEntity);
    }

    @Override
    public ResultResponse adminLogin(AdminRequest adminRequest) {
        ResultResponse resultResponse = new ResultResponse();
        AdminEntity adminEntity = adminRepository.getAdminEntityByEmail(adminRequest.getEmail());
        if (adminEntity.getPassword().equals(adminRequest.getPassword()))
        {
            resultResponse.setOperationResult("VALID");
        }
        else {
            resultResponse.setOperationResult("UNVALID");
        }
        return  resultResponse;
    }

    @Override
    public AdminEntity getAdminById(Integer id) {
        return adminRepository.getAdminEntityById(id);
    }

    @Override
    public List<AdminEntity> getAdmins() {
        return adminRepository.getAdminEntities();
    }
}
