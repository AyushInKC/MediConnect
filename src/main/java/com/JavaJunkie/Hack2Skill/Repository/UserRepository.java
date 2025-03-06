package com.JavaJunkie.Hack2Skill.Repository;
import com.JavaJunkie.Hack2Skill.Models.UserModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<UserModel,String> {
     Optional<UserModel> findByEmail(String email);
}
