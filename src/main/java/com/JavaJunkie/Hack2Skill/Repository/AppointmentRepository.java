package com.JavaJunkie.Hack2Skill.Repository;

import com.JavaJunkie.Hack2Skill.Models.AppointmentModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppointmentRepository extends MongoRepository<AppointmentModel,String> {

}
