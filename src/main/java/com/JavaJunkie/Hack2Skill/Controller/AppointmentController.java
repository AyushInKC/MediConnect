package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Models.AppointmentModel;
import com.JavaJunkie.Hack2Skill.Repository.AppointmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    public AppointmentController(AppointmentRepository appointmentRepository){
        this.appointmentRepository=appointmentRepository;
    }
    @PostMapping("/save-appointment")
    public ResponseEntity<AppointmentModel> saveAppointment(@RequestBody AppointmentModel appointment) {
        AppointmentModel savedAppointment = appointmentRepository.save(appointment);
        return ResponseEntity.ok(savedAppointment);
    }

    @GetMapping("/list-appointment")
    public ResponseEntity<List<AppointmentModel>> listAllAppointments() {
        List<AppointmentModel> appointments = appointmentRepository.findAll();
        return ResponseEntity.ok(appointments);
    }

}
