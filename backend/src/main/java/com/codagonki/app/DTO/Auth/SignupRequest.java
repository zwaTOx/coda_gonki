package com.codagonki.app.DTO.Auth;

// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
    
    @NotBlank(message = "Поле email обязательно")
    // @Email(message = "ошибка валидации email")
    private String email;
    
    @NotBlank(message = "Поле пароль обязательно")
    // @Size(min = 6, message = ">6")
    private String password;
    
    @NotBlank(message = "Поле подтверждения пароля обязательно")
    private String verifyPassword;
    
    private String nickname; 
    // private final String role = "USER";
}