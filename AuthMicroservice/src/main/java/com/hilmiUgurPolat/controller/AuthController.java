package com.hilmiUgurPolat.controller;


import com.hilmiUgurPolat.dto.LoginResponseDTO;
import com.hilmiUgurPolat.dto.RegisterRequestDTO;
import com.hilmiUgurPolat.entity.Auth;
import com.hilmiUgurPolat.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.hilmiUgurPolat.config.RestApis.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AUTHSERVICE)
public class AuthController {
    private final AuthService authService;

    @PostMapping(REGISTER)
    public ResponseEntity<Auth> register(@RequestBody RegisterRequestDTO dto) {
        if (!dto.getPassword().equals(dto.getPassword()))
            throw new RuntimeException("şifreler uyuşmuyor");
        return ResponseEntity.ok(authService.register(dto));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<Boolean> login(@RequestBody LoginResponseDTO dto){
        return ResponseEntity.ok(authService.login(dto));

    }

}
