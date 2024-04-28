package com.example.demo.controller;
//spring framework
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.LoginModel;
import com.example.demo.model.LoginResponse;

import com.example.demo.security.TodoInterface;

@RestController
@RequestMapping("/todo")
public class AuthLogin {

    @Autowired
    TodoInterface loginService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> Login(@RequestBody LoginModel login, @RequestHeader(name = "Authorization") String authHeader) {
        String authorization = "myDearFreindXYZ"; //header value for testing purposes only
        LoginResponse message = loginService.checkLogin(login.getUsername(), login.getPassword());
        if (authHeader == null || authHeader.isEmpty()) {
            return ResponseEntity.badRequest()
              .body(new LoginResponse("Bad Request", "Missing Authorization Header"));
        }  
        else if (message.getAccessToken() == null && authHeader.equals(authorization)) {
            return ResponseEntity.status(401).body(new LoginResponse(message.getMessage(), null)); // Use message from LoginResponse if available
        } else if(message.getAccessToken() != null && authHeader.equals(authorization)) {
            return ResponseEntity.ok(new LoginResponse(message.getId(), "Login Successful", message.getAccessToken()));
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
