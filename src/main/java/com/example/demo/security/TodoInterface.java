package com.example.demo.security;

import com.example.demo.model.LoginResponse;

public interface TodoInterface {
  public LoginResponse checkLogin(String userName, String password);
}
