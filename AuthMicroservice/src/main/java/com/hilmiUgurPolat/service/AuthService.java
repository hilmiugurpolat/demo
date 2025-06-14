package com.hilmiUgurPolat.service;

import com.hilmiUgurPolat.dto.CreateUserRequestDto;
import com.hilmiUgurPolat.dto.LoginResponseDTO;
import com.hilmiUgurPolat.dto.RegisterRequestDTO;
import com.hilmiUgurPolat.entity.Auth;
import com.hilmiUgurPolat.manager.UserProfileManager;
import com.hilmiUgurPolat.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
    private final UserProfileManager userProfileManager;

    public Auth register(RegisterRequestDTO dto) {
        Auth auth = authRepository.save(Auth.builder()
                .userName(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());
        userProfileManager.createUser(CreateUserRequestDto.builder()
                .authId(auth.getId())
                .email(auth.getEmail())
                .userName(auth.getUserName())
                .build());
        return auth;
    }

    public Boolean login(LoginResponseDTO dto) {
        return authRepository.existsByUserNameAndPassword(dto.getUserName(), dto.getPassword());
    }
}
