package com.example.demo.model;

public class LoginResponse {
  private String message;
  private String accessToken;
   
  public LoginResponse(String message, String accessToken) {
    this.message = message;
    this.accessToken = accessToken;
  }

  public String getMessage() {
    return message;
  }

  public String getAccessToken() {
    return accessToken;
}

}