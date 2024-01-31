package com.keepgoingLikeline.emotionDiary_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.keepgoingLikeline.emotionDiary_backend.dto.AddUserRequest;
import com.keepgoingLikeline.emotionDiary_backend.entity.UserEntity;
import com.keepgoingLikeline.emotionDiary_backend.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Long save(AddUserRequest dto) {
		/*
        UserEntity user = new UserEntity();

        user.setEmail(dto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));

        return userRepository.save(user).getId();
        */
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		return userRepository.save(UserEntity.builder()
				.email(dto.getEmail())
				.password(encoder.encode(dto.getPassword()))
				.build()).getId();
	}
	
	public UserEntity findById(Long userId) {
		return userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
	}
	
	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("Unexpected user"));
	}
}
