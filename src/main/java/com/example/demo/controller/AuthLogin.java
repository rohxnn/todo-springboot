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
        LoginResponse message = loginService.checkLogin(login.getUsername(), login.getPassword());
        if (authHeader == null || authHeader.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new LoginResponse("Bad Request", "Missing Authorization Header"));
        } else if (message.getAccessToken() == null) {
            return ResponseEntity.status(401).body(new LoginResponse(message.getMessage(), null)); // Use message from LoginResponse if available
        } else {
            // Security: Avoid sending the entire token in the response. Consider a separate token management mechanism.
            return ResponseEntity.ok(new LoginResponse("Login Successful", message.getAccessToken()));
        }
    }
}
