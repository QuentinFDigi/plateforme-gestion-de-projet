package fr.diginamic.PGDP.controllers;

import fr.diginamic.PGDP.configs.JwtService;
import fr.diginamic.PGDP.dtos.users.LoginUserDto;
import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.managers.AuthManager;
import fr.diginamic.PGDP.responses.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/** Classe permettant la gestion de l'authentification */
@RequestMapping("/auth")
@RestController
public class AuthenticationController {

    /** Variable permettant l'appel à la classe AuthManager qui gère toutes les fonctionnalités */
    private final AuthManager authManager;

    /** Variable permettant l'appel à la classe jwtService qui contient la logique du token */
    private final JwtService jwtService;

    /** COnstructeur permettant d'initialiser les différents services
     *
     * @param authManager variable permettant l'appel à la classe AuthManager qui gère toutes les fonctionnalités
     * @param jwtService variable permettant l'appel à la classe jwtService qui contient la logique du token
     */
    public AuthenticationController(AuthManager authManager, JwtService jwtService) {
        this.authManager = authManager;
        this.jwtService = jwtService;
    }

    /** Fonction permettant la connexion d'un utilisateur
     *
     * @param loginUserDto variable contenant les données de connexion d'un utilisateur
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authManager.authenticate(loginUserDto);
        String jwtToken = jwtService.generateToken(authenticatedUser);
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getJwtExpirationTime());
        return ResponseEntity.ok(loginResponse);
    }

    /** Fonction permettant l'inscription de l'utilisateur
     *
     * @param registerUserDto variable contenant les données d'inscription d'un utilisateur
     * @return responseEntity(user)
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User newUser = authManager.signUp(registerUserDto);
        return ResponseEntity.ok(newUser);
    }

    /** Fonction permettant la déconnexion d'un utilisateur
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout() {
        // TODO :  A réaliser
        return "logout";
    }
}
