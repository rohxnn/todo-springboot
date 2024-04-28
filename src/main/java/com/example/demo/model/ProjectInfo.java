package com.example.demo.model;

//hibernate
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String status;
  private String description;

  @JoinColumn(name = "created_date")
  private String createdDate;

  @JoinColumn(name = "updated_date")
  private String updatedDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "u_id")
  private LoginModel user;

  public  ProjectInfo() {}

  public ProjectInfo(long id, String title, String status, String description, String createdDate, String updatedDate) {
    this.id = id;
    this.title = title;
    this.status = status;
    this.description = description;
    this.createdDate = createdDate;
    this.updatedDate = updatedDate;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(String updatedDate) {
    this.updatedDate = updatedDate;
  }

  public LoginModel getUser() {
    return user;
  }

  public void setUser(LoginModel user) {
    this.user = user;
  }
}
