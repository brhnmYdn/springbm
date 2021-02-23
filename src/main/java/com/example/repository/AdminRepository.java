package com.example.repository;

import com.example.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
    AdminEntity getAdminEntityByEmail(String email);
    AdminEntity getAdminEntityByUsername(String username);
    AdminEntity  getAdminEntityById(Integer id);
    @Query("select a from AdminEntity  a")
    List<AdminEntity> getAdminEntities();
}
