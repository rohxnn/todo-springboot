package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.LoginModel;
@Repository
public interface LoginRepo extends JpaRepository<LoginModel, Integer> {
  LoginModel findByUsernameAndPassword(String Username,  String Password);
  @Query("SELECT l.token FROM LoginModel l WHERE l.username = ?1 AND l.password = ?2")
  String findTokenByUsernameAndPassword(String username, String password);

}
