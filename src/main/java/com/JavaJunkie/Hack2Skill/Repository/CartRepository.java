package com.JavaJunkie.Hack2Skill.Repository;

import com.JavaJunkie.Hack2Skill.Models.CartModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CartRepository extends MongoRepository<CartModel,String> {

}
