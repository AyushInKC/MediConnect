package com.JavaJunkie.Hack2Skill.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "medicinesdb")
public class MedicineModel {
    @Id
    private String id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private String image;
    private String description;
    private Integer stock;
}
