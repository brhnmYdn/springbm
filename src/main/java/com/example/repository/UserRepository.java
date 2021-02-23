package com.example.repository;

import com.example.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity getUserEntityByEmail(String email);
    UserEntity getUserEntityById(Integer id);
    @Query("select u from UserEntity u")
    List<UserEntity> getUsers();
    List<UserEntity> getUserEntitiesByEmail(String email);

}