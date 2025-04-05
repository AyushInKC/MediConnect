package com.JavaJunkie.Hack2Skill.Controller;
import com.JavaJunkie.Hack2Skill.DTO.UserLoginDTO;
import com.JavaJunkie.Hack2Skill.DTO.UserLoginResponseDTO;
import com.JavaJunkie.Hack2Skill.DTO.UserSignUpDTO;
import com.JavaJunkie.Hack2Skill.Models.UserModel;
import com.JavaJunkie.Hack2Skill.Service.EmailService;
import com.JavaJunkie.Hack2Skill.Service.HospitalService;
import com.JavaJunkie.Hack2Skill.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

   private final UserService userService;
   private final EmailService emailService;
   private final HospitalService hospitalService;

   public UserController(UserService userService, EmailService emailService, HospitalService hospitalService){
       this.userService=userService;
       this.emailService=emailService;
       this.hospitalService=hospitalService;
   }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignUpDTO userDTO) {
        return ResponseEntity.ok(userService.signup(userDTO));
    }

    @PostMapping("/login")
    public UserLoginResponseDTO login(@RequestBody UserLoginDTO userLoginDTO) {
       return userService.login(userLoginDTO);
    }

    @PutMapping("/updateProfilePicture/{email}")
    public ResponseEntity<String> updateProfilePicture(@PathVariable String email,@RequestParam("file") MultipartFile file) throws IOException {
       return ResponseEntity.ok(userService.updateProfilePicture(email,file));
    }
    @PutMapping("/updateData/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody UserModel updatedUser) {
        return ResponseEntity.ok(userService.updateUserDetails(email, updatedUser));
    }

    @PostMapping("/send-mail")
    public String sendEmail(@RequestParam String to, @RequestParam String subject, @RequestParam String body) {
        return emailService.sendEmail(to, subject, body);
    }

    @GetMapping("/nearby-hospitals")
    public ResponseEntity<Map<String, Object>> getNearbyHospitals(
            @RequestParam("latitude") double latitude,
            @RequestParam("longitude") double longitude
    ) {
        Map<String, Object> response = hospitalService.findNearbyHospitals(latitude, longitude);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
