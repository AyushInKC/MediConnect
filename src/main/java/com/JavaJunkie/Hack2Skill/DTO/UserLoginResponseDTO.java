package com.JavaJunkie.Hack2Skill.DTO;

import lombok.Data;

@Data
public class UserLoginResponseDTO {
    private String accessToken;
    private String refreshToken;

    public UserLoginResponseDTO(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
