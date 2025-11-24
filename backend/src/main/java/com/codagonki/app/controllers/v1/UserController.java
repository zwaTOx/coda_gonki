package com.codagonki.app.controllers.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codagonki.app.DTO.User.UpdateProfileRequest;
import com.codagonki.app.DTO.User.UserProfileResponse;
import com.codagonki.app.dependencies.CurrentUser;
import com.codagonki.app.models.User;
import com.codagonki.app.services.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getCurrentUser(@CurrentUser User user) {
        UserProfileResponse userInfo = userService.getUserInfo(user);
        return ResponseEntity.ok(userInfo);
    }

    @PatchMapping("/me")
    public ResponseEntity<UserProfileResponse> updateUserProfile(
            @CurrentUser User user,
            @Valid @RequestBody UpdateProfileRequest updateRequest) {
        UserProfileResponse updatedUser = userService.updateUserProfile(user, updateRequest);
        return ResponseEntity.ok(updatedUser);
    }
}
