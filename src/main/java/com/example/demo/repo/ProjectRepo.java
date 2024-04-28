package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//model
import com.example.demo.model.ProjectInfo;

@Repository
public interface ProjectRepo extends JpaRepository<ProjectInfo, Long> {
  @Query("SELECT NEW com.example.demo.model.ProjectInfo(p.id, p.title, p.status, p.description, p.createdDate, p.updatedDate) FROM ProjectInfo p INNER JOIN LoginModel l ON p.id = l.id WHERE l.id = :userId")
  List<ProjectInfo> findByUser(Long userId);
}
