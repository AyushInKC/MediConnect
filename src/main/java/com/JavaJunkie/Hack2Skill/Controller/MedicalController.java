package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Models.MedicineModel;
import com.JavaJunkie.Hack2Skill.Repository.MedicineRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/medicines")
public class MedicalController {

    private final MedicineRepository medicineRepository;

    public MedicalController(MedicineRepository medicineRepository){
        this.medicineRepository=medicineRepository;
    }

    @GetMapping("/by-name/{name}")
    public ResponseEntity<MedicineModel> findByName(@PathVariable String name) {
        MedicineModel medicine = medicineRepository.findByName(name);
        if (medicine != null) {
            return ResponseEntity.ok(medicine);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/list-all")
    public ResponseEntity<?> listAll(){
        List<MedicineModel> medicines = medicineRepository.findAll();
        return ResponseEntity.ok(medicines);
    }
}
