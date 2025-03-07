package com.JavaJunkie.Hack2Skill.Repository;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorRepository extends MongoRepository<DoctorModel,String> {

    List<DoctorModel> findByNameContainingIgnoreCase(String name);
    List<DoctorModel> findByPhone(String phone);
    List<DoctorModel> findByDesignationContainingIgnoreCase(String designation);
    List<DoctorModel> findByHospitalContainingIgnoreCase(String hospital);
    List<DoctorModel> findByQualificationContainingIgnoreCase(String qualification);
    List<DoctorModel> findByDistrictContainingIgnoreCase(String district);
}
