package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import com.JavaJunkie.Hack2Skill.Repository.DoctorRepository;
import com.JavaJunkie.Hack2Skill.Service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

   @GetMapping("/by-name")
   public ResponseEntity<?> findDoctorByName(@RequestParam String name){
      List<DoctorModel>  doctors=doctorService.findDoctorByName(name);
       return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
   }

    @GetMapping("/by-number")
    public ResponseEntity<?> findDoctorByNumber(@RequestParam String phone){
        List<DoctorModel> doctors=doctorService.findDoctorByPhone(phone);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }
    @GetMapping("/by-designation")
    public ResponseEntity<?> findDoctorByDesignation(@RequestParam String designation){
        List<DoctorModel> doctors=doctorService.findDoctorByDesignation(designation);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }
    @GetMapping("/by-hospital")
    public ResponseEntity<?> findDoctorByHospital(@RequestParam String hospital){
        List<DoctorModel> doctors=doctorService.findDoctorByDistrict(hospital);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }
    @GetMapping("/by-qualification")
    public ResponseEntity<?> findDoctorByQualification(@RequestParam String qualification){
        List<DoctorModel> doctors=doctorService.findDoctorByQualification(qualification);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }

    @GetMapping("/by-district")
    public ResponseEntity<?> findDoctorByDistrict(@RequestParam String district){
        List<DoctorModel> doctors=doctorService.findDoctorByDistrict(district);
        return doctors.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctors);
    }

    @GetMapping("/list-all")
    public ResponseEntity<?> listAll(){
        List<DoctorModel> doctorModels=doctorService.listAll();
        return doctorModels.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(doctorModels);
    }

}
