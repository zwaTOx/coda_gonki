package com.codagonki.app.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")  
@Data
@Getter
@Setter
@Builder
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