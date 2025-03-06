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
    private String hospital;
    private String phone;
    private String designation;
    private String qualification;
    private String district;
}

