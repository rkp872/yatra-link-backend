package com.yatralink.controller;

import com.yatralink.model.User;
import com.yatralink.repository.UserRepository;
import com.yatralink.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository; // used for registration

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already in use");
        }

        // encode password and set default role
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRole() == null) {
            user.setRole("ROLE_USER");
        }
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String,String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password)
            );

            // If authentication is successful, generate token
            String token = jwtUtil.generateToken(email);

            Map<String, Object> resp = new HashMap<>();
            resp.put("token", token);
            // you might want to return user details too
            User user = userRepository.findByEmail(email).orElse(null);
            resp.put("user", user);

            return ResponseEntity.ok(resp);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
