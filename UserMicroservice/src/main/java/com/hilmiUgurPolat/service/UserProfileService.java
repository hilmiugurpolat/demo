package com.hilmiUgurPolat.service;


import com.hilmiUgurPolat.document.UserProfile;
import com.hilmiUgurPolat.dto.request.CreateUserRequestDto;
import com.hilmiUgurPolat.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProfileService {
    private final UserProfileRepository userProfileRepository;


    public void createUser(CreateUserRequestDto dto) {
        userProfileRepository.save(UserProfile.builder()
                .authId(dto.getAuthId())
                .userName(dto.getUserName())
                .email(dto.getEmail())
                .build());

    }

    public List<UserProfile> getAll() {
        return userProfileRepository.findAll();
    }
}
