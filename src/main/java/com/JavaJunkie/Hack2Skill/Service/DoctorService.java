package com.JavaJunkie.Hack2Skill.Service;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import com.JavaJunkie.Hack2Skill.Repository.DoctorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository){
        this.doctorRepository=doctorRepository;
    }
    public List<DoctorModel> findDoctorByName(String name) {
        return doctorRepository.findByNameContainingIgnoreCase(name);
    }


    public List<DoctorModel> listAll() {
        return doctorRepository.findAll();
    }
}
