package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import com.JavaJunkie.Hack2Skill.Repository.DoctorRepository;
import com.JavaJunkie.Hack2Skill.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;
@RestController
@RequestMapping("/doctor")
public class DoctorController {

   private final DoctorRepository doctorRepository;
   private final DoctorService doctorService;


    public DoctorController(DoctorRepository doctorRepository, DoctorService doctorService){
       this.doctorRepository=doctorRepository;
       this.doctorService = doctorService;
   }

   public ResponseEntity<?> findDoctorByName(@RequestParam String Name){
      List<DoctorModel>  doctors=doctorService.findDoctorByName(Name);
       return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
   }

    public ResponseEntity<?> findDoctorByNumber(@RequestParam String phone){
        List<DoctorModel> doctors=doctorService.findDoctorByPhone(phone);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }
    public ResponseEntity<?> findDoctorByDesignation(@RequestParam String designation){
        List<DoctorModel> doctors=doctorService.findDoctorByDesignation(designation);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }

    public ResponseEntity<?> findDoctorByHospital(@RequestParam String district){
        List<DoctorModel> doctors=doctorService.findDoctorByDistrict(district);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }

    public ResponseEntity<?> findDoctorByQualification(){
        return null;
    }

    public ResponseEntity<?> findDoctorByDistrict(){
        return null;
    }
}
