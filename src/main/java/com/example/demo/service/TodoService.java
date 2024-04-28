package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
//service
import org.springframework.stereotype.Service;
///model
import com.example.demo.model.LoginModel;
import com.example.demo.model.LoginResponse;
//repository
import com.example.demo.repo.LoginRepo;
//interface
import com.example.demo.security.TodoInterface;

@Service
public class TodoService implements TodoInterface {

@Autowired
private LoginRepo loginService;

  public LoginResponse checkLogin(String userName, String password) {
    LoginModel user = loginService.findByUsernameAndPassword(userName, password);
    if (user == null) {
      return new LoginResponse("Invalid username or password", null);
    } else {
      String accessToken = user.getToken();
      return new LoginResponse(user.getId(),"Logged in successfully", accessToken);
    }
  }
}
