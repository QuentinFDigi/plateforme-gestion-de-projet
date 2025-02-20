package fr.diginamic.PGDP.controllers;

import fr.diginamic.PGDP.configs.JwtService;
import fr.diginamic.PGDP.dtos.users.LoginUserDto;
import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.responses.LoginResponse;
import fr.diginamic.PGDP.services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getJwtExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User newUser = authenticationService.signUp(registerUserDto);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}
