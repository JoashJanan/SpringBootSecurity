package com.SpringSecurityJWTH2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurityJWTH2.Entity.AppUser;
import com.SpringSecurityJWTH2.Repository.UserRepository;
import com.SpringSecurityJWTH2.Service.JwtService;

@RestController
public class UserController {

	@GetMapping("/user/hello")
    public String userHello() {
        return "Hello USER";
    }

    @GetMapping("/admin/hello")
    public String adminHello() {
        return "Hello ADMIN";
    }
}
