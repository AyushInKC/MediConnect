package com.JavaJunkie.Hack2Skill.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document(collection = "Users")
public class UserModel {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    private Integer age;
    private String gender;
    private String symptoms;
    private String description;
    private String currentDiagnosis;
}
