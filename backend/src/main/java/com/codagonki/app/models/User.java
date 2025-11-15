package com.codagonki.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")  
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(unique = true)
    private String nickname;
    
    private String role;
    
    @Column(name = "hashed_password")
    private String hashedPassword;  

    @Column(nullable = false)
    @Builder.Default
    private Integer rating = 0;
}