package com.example.demo.model;
// hiberante
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LoginModel {

    @Id
    private int id;
    private String username;
    private String password;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
