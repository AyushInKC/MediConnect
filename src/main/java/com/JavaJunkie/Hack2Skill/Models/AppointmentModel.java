package com.JavaJunkie.Hack2Skill.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Document(collection = "appointmentdb")
public class AppointmentModel {
   @Id
    private String id;
    private String userId;
    private String doctorId;
    private String doctorName;
    private String specialization;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private String status;
    private String paymentStatus;
    private double paymentAmount;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String upiId;
    private String transactionId;
    private LocalDate bookingDate;

}
