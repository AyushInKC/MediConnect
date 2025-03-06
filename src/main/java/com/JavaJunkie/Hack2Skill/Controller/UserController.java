package com.JavaJunkie.Hack2Skill.Controller;
import com.JavaJunkie.Hack2Skill.DTO.UserLoginDTO;
import com.JavaJunkie.Hack2Skill.DTO.UserSignUpDTO;
import com.JavaJunkie.Hack2Skill.Models.UserModel;
import com.JavaJunkie.Hack2Skill.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

   private final UserService userService;
   public UserController(UserService userService){
       this.userService=userService;
   }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserSignUpDTO userDTO) {
        return ResponseEntity.ok(userService.signup(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(userService.login(userLoginDTO));
    }

    @PutMapping("/update/{email}")
    public ResponseEntity<String> updateUser(@PathVariable String email, @RequestBody UserModel updatedUser) {
        return ResponseEntity.ok(userService.updateUserDetails(email, updatedUser));
    }
}
