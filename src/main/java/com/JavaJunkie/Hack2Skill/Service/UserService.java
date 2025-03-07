package com.JavaJunkie.Hack2Skill.Service;

import com.JavaJunkie.Hack2Skill.DTO.UserLoginDTO;
import com.JavaJunkie.Hack2Skill.DTO.UserLoginResponseDTO;
import com.JavaJunkie.Hack2Skill.DTO.UserSignUpDTO;
import com.JavaJunkie.Hack2Skill.Models.UserModel;
import com.JavaJunkie.Hack2Skill.Repository.UserRepository;
import com.JavaJunkie.Hack2Skill.Utils.JWTUtility;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtility jwtUtility;
    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder,JWTUtility jwtUtility){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtility=jwtUtility;
    }

    public String signup(UserSignUpDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            return "User already exists!";
        }

        UserModel user = new UserModel();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        userRepository.save(user);
        return "User registered successfully!";
    }

    public UserLoginResponseDTO login(UserLoginDTO loginDTO) {
        Optional<UserModel> user = userRepository.findByEmail(loginDTO.getEmail());

        if (user.isPresent() && passwordEncoder.matches(loginDTO.getPassword(), user.get().getPassword())) {
            String accessToken = jwtUtility.generateAccessToken(loginDTO.getEmail());
            String refreshToken = jwtUtility.generateRefreshToken(loginDTO.getEmail());
            return new UserLoginResponseDTO(accessToken, refreshToken);
        } else {
            throw new RuntimeException("Invalid email or password!");
        }
    }


    public String updateUserDetails(String email, UserModel updatedUser) {
        Optional<UserModel> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setAge(updatedUser.getAge());
            user.setGender(updatedUser.getGender());
            user.setSymptoms(updatedUser.getSymptoms());
            user.setDescription(updatedUser.getDescription());
            user.setCurrentDiagnosis(updatedUser.getCurrentDiagnosis());

            userRepository.save(user);
            return "User details updated successfully!";
        }
        return "User not found!";
    }
}
