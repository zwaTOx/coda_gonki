package com.codagonki.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")  
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}