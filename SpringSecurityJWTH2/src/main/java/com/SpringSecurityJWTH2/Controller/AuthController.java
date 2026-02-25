package com.SpringSecurityJWTH2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurityJWTH2.Entity.AppUser;
import com.SpringSecurityJWTH2.Repository.UserRepository;
import com.SpringSecurityJWTH2.Service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody AppUser user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repository.save(user);
        return "User Registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody AppUser user) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        user.getPassword()));
        
        // 🔥 Fetch user from DB
        AppUser dbUser = repository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));


        return jwtService.generateToken(
        		dbUser.getUsername(),
        		dbUser.getRole().name());
    }
}
