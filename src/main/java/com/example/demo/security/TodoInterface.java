package com.example.demo.security;

import java.util.List;

import com.example.demo.model.LoginResponse;
import com.example.demo.model.ProjectInfo;

public interface TodoInterface {
  public LoginResponse checkLogin(String userName, String password);
  public List<ProjectInfo> getProjectDetails(long userId);
}
