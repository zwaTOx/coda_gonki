package com.codagonki.app.security;
import com.codagonki.app.DTO.SignupRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/api/auth")
public class UserAuth {

    @PostMapping("/register")
    public ResponseEntity<?> register_user(@RequestBody SignupRequest signupRequest) {
        return ResponseEntity.ok(signupRequest);
    }
}
