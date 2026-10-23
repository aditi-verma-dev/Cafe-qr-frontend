package com.cafeqr.cafeQR.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cafeqr.cafeQR.Entity.User;
import com.cafeqr.cafeQR.Repository.UserRepository;
import com.cafeqr.cafeQR.Security.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already taken");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.ok("Registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginData) {
        Optional<User> found = userRepository.findByUsername(loginData.getUsername());

        if (found.isEmpty() ||
            !passwordEncoder.matches(loginData.getPassword(), found.get().getPassword())) {
            return ResponseEntity.status(401).body("Wrong username or password");
        }

        String token = jwtService.generateToken(found.get().getUsername());
        return ResponseEntity.ok(Map.of("token", token));
    }
} 
