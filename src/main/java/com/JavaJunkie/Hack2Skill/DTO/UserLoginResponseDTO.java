package com.JavaJunkie.Hack2Skill.DTO;

import lombok.Data;

@Data
public class UserLoginResponseDTO {
    private String accessToken;
    private String refreshToken;
    private String name;
    private String email;

    public UserLoginResponseDTO(String accessToken, String refreshToken,String name,String email) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.name=name;
        this.email=email;
    }
}
