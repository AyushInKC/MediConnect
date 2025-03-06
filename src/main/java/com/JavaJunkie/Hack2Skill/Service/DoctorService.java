package com.JavaJunkie.Hack2Skill.Service;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import com.JavaJunkie.Hack2Skill.Repository.DoctorRepository;
import org.springframework.stereotype.Service;

import javax.print.Doc;
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
    public List<DoctorModel> findDoctorByDistrict(String name) {
        return doctorRepository.findByDistrictContainingIgnoreCase(name);
    }
    public List<DoctorModel> findDoctorByPhone(String name) {
        return doctorRepository.findByPhone(name);
    }
    public List<DoctorModel> findDoctorByQualification(String name) {
        return doctorRepository.findByQualificationContainingIgnoreCase(name);
    }
    public List<DoctorModel> findDoctorByDesignation(String name) {
        return doctorRepository.findByDesignationContainingIgnoreCase(name);
    }

    public List<DoctorModel> listAll() {
        return doctorRepository.findAll();
    }
}
