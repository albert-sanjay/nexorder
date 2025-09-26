package org.alphabet.nexorder.controller;

import org.alphabet.nexorder.dto.AuthRequest;
import org.alphabet.nexorder.dto.AuthResponse;
import org.alphabet.nexorder.service.CustomUserDetailService;
import org.alphabet.nexorder.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final CustomUserDetailService userDetailService;
    private final AuthenticationProvider authManager;
    private final JwtService jwtService;

    public AuthController(CustomUserDetailService userDetailService,
                          AuthenticationProvider authManager,
                          JwtService jwtService) {
        this.userDetailService = userDetailService;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request){
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails user = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(user);

        return ResponseEntity.ok(new AuthResponse(token));
    }

}
