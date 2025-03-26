package com.JavaJunkie.Hack2Skill.Models;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Doctors")
public class DoctorModel {
  @Id
  private String id;
  private String name;
  private String specialization;
  private double rating;
  private String experience;
  private String location;
  private String availability;
  private String image;
  private String phone;
  private String email;
  private String description;
  private String price;

}

