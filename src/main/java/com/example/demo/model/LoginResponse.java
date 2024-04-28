package com.example.demo.model;

public class LoginResponse {
  private int id;
  private String message;
  private String accessToken;
   
  public LoginResponse(int id, String message, String accessToken) {
    this.id = id;
    this.message = message;
    this.accessToken = accessToken;
  }

  public LoginResponse(String message, String accessToken) {
    this.message = message;
    this.accessToken = accessToken;
  }

  public int getId() {
    return id;
  }
  public String getMessage() {
    return message;
  }

  public String getAccessToken() {
    return accessToken;
}

}