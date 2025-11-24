package com.codagonki.app.DTO.Auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Поле email обязательно")
    // @Email(message = "ошибка валидации email")
    private String email;
    
    @NotBlank(message = "Поле пароль обязательно")
    // @Size(min = 6, message = ">6")
    private String password;
}
