package com.JavaJunkie.Hack2Skill.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Document(collection = "cartdata")
public class CartModel {
    @Id
    private String id;

    private String userId;

    private List<Map<String, Object>> items;

    private Double total;

    private String status;

    private Date orderDate;

    private String deliveryAddress;

    private String paymentStatus;
}

