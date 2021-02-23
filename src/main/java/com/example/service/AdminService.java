package com.example.service;

import com.example.entity.AdminEntity;
import com.example.request.AdminRequest;
import com.example.response.ResultResponse;

import java.util.List;

public interface AdminService {
     AdminEntity create(AdminRequest adminRequest);
     ResultResponse adminLogin(AdminRequest adminRequest);
     AdminEntity getAdminById(Integer id);
     List<AdminEntity> getAdmins();
}
