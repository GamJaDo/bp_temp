package com.keepgoingLikeline.emotionDiary_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
	private String email;
    private String password;
}
