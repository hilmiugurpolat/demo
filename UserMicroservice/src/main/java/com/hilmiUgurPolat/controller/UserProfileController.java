package com.hilmiUgurPolat.controller;


import com.hilmiUgurPolat.document.UserProfile;
import com.hilmiUgurPolat.dto.request.CreateUserRequestDto;
import com.hilmiUgurPolat.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.hilmiUgurPolat.config.RestApis.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(USERPROFILE)
public class UserProfileController {
    private final UserProfileService userProfileService;

    @PostMapping(CREATE_USER)
    public ResponseEntity<Boolean> createUser(@RequestBody CreateUserRequestDto dto){
        userProfileService.createUser(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping(GET_ALL)
    public ResponseEntity<List<UserProfile>> getAll(){
        return ResponseEntity.ok(userProfileService.getAll());
    }


    @GetMapping("/upper-name")
    public ResponseEntity<String> upperNAme(String name){
        return ResponseEntity.ok(userProfileService.upperName(name));
    }
}
