package com.hilmiUgurPolat.service;

import com.hilmiUgurPolat.dto.LoginResponseDTO;
import com.hilmiUgurPolat.dto.RegisterRequestDTO;
import com.hilmiUgurPolat.entity.Auth;
import com.hilmiUgurPolat.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public Auth register(RegisterRequestDTO dto) {
        return authRepository.save(Auth.builder()
                .userName(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build());

    }

    public Boolean login(LoginResponseDTO dto) {
        return authRepository.existsByUserNameAndPassword(dto.getUserName(),dto.getPassword());
    }
}
