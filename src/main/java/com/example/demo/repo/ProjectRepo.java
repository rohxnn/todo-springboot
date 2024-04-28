package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//model
import com.example.demo.model.LoginModel;
import com.example.demo.model.ProjectInfo;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectInfo, Long> {
List<ProjectInfo> findByUser(LoginModel l);
}
