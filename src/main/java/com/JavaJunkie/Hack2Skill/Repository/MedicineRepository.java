package com.JavaJunkie.Hack2Skill.Repository;

import com.JavaJunkie.Hack2Skill.Models.DoctorModel;
import com.JavaJunkie.Hack2Skill.Models.MedicineModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends MongoRepository<MedicineModel, String> {
    MedicineModel findByName(String name);
}
