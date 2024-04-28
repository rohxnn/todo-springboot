package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//model
import com.example.demo.model.ProjectInfo;
//interface
import com.example.demo.security.TodoInterface;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/todo")
public class TodoCrudController {
@Autowired
TodoInterface crudService;

@GetMapping("/get")
  public ResponseEntity<List<ProjectInfo>> getAllTodos(HttpSession session) {
    int userId = (int) session.getAttribute("user");
    List<ProjectInfo> projectDetails = crudService.getProjectDetails(userId);
    if(projectDetails == null){
      return ResponseEntity.notFound().build();
    }else{
    return ResponseEntity.ok(projectDetails);
  }
  }
}
