package com.JavaJunkie.Hack2Skill.Controller;

import com.JavaJunkie.Hack2Skill.Service.MedicalChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/medical-chat")
public class MedicalChatController {
     private final MedicalChatService medicalChatService;

     public MedicalChatController(MedicalChatService medicalChatService){
         this.medicalChatService=medicalChatService;
     }
    @PostMapping
    public ResponseEntity<Map<String, String>> chatWithMediBot(@RequestBody Map<String, String> request) {
        String userMessage = request.get("message");

        if (userMessage == null || userMessage.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of("response", "Message cannot be empty"));
        }

        String botResponse = medicalChatService.getMedicalResponse(userMessage);

        return ResponseEntity.ok(Map.of("response", botResponse));
    }


}
