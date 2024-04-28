package com.example.demo.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//service
import org.springframework.stereotype.Service;
///model
import com.example.demo.model.LoginModel;
import com.example.demo.model.LoginResponse;
import com.example.demo.model.ProjectInfo;
//repository
import com.example.demo.repo.LoginRepo;
import com.example.demo.repo.ProjectRepo;
//interface
import com.example.demo.security.TodoInterface;

@Service
public class TodoService implements TodoInterface {

@Autowired
private LoginRepo loginService;
@Autowired
private ProjectRepo projectService;

  public LoginResponse checkLogin(String userName, String password) {
    LoginModel user = loginService.findByUsernameAndPassword(userName, password);
    if (user == null) {
      return new LoginResponse("Invalid username or password", null);
    } else {
      String accessToken = user.getToken();
      return new LoginResponse(user.getId(),"Logged in successfully", accessToken);
    }
  }

  public List<ProjectInfo> getProjectDetails(long userId) {
    return projectService.findByUser(userId);
  }
}
