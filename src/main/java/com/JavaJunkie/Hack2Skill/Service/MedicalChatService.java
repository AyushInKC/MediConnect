package com.JavaJunkie.Hack2Skill.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
@Service
public class MedicalChatService {
    private final RestTemplate restTemplate;

    private static final String MEDIBOT_URL = "https://medibot-8t2t.onrender.com/medical-chat";
    public MedicalChatService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getMedicalResponse(String userMessage) {
        try {

            Map<String, String> requestBody = Map.of("message", userMessage);


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.exchange(MEDIBOT_URL, HttpMethod.POST, requestEntity, Map.class);

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return (String) response.getBody().get("response");
            } else {
                return "Error: Unable to process your request.";
            }
        } catch (Exception e) {
            return "Sorry, I am having trouble processing your request. Please try again later.";
        }
    }
}