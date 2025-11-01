    package com.codagonki.app.controllers;

    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.codagonki.app.DTO.UserResponse;

    @RestController
    @RequestMapping(path = "api/users")
    public class UserController {

        @GetMapping("/{user_id}")
        public UserResponse user_ping(@PathVariable int user_id) {
            return new UserResponse(user_id);
        }

    }
