package com.example.demo.repo;
//springframework
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//model
import com.example.demo.model.LoginModel;

@Repository
  public interface LoginRepo extends JpaRepository<LoginModel, Integer> {
    LoginModel findByUsernameAndPassword(String userName,  String password); 
  } 