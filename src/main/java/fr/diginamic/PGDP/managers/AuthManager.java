package fr.diginamic.PGDP.managers;

import fr.diginamic.PGDP.dtos.users.LoginUserDto;
import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.exceptions.users.UserNotFoundException;
import fr.diginamic.PGDP.repositories.UserRepository;
import fr.diginamic.PGDP.services.AuthService;
import fr.diginamic.PGDP.transformers.UserTransformer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/** Classe contenant la logique des diverses opérations mener sur l'authentification */
@Service
public class AuthManager {

    /** Variable pemrmettant de transformer des users en usersDto */
    private final UserTransformer userTransformer;

    /** Variable permettant d'utiliser les fonctions fournie par spring sécurity dans la classe AuthenticationManager */
    private final AuthenticationManager authenticationManager;

    /** Variable permettant de faire des vérification métier */
    private final AuthService authService;

    /** Variable permettant de communique avec la table users en bdd */
    private final UserRepository userRepository;

    /** Constructeur pour les différents services
     *
     * @param userTransformer variable permettant de transformer les users en usersDto
     * @param authenticationManager variable permettant d'utiliser les fonctions fournie par spring sécurity dans la classe AuthenticationManager
     * @param authService variable permettant de faire des vérification métier
     * @param userRepository variable permettant de communique avec la table users en bdd
     */
    public AuthManager(UserTransformer userTransformer, AuthenticationManager authenticationManager, AuthService authService, UserRepository userRepository) {
        this.userTransformer = userTransformer;
        this.authenticationManager = authenticationManager;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    /** Fonction permettant de créer un utilisateur.
     *
     * @param registerUserDto variable contenant les données d'un utilisateur.
     * @return user
     */
    public User signUp(RegisterUserDto registerUserDto) {
        User registeredUser = userTransformer.registerUserDtoToUser(registerUserDto);
        return userRepository.save(registeredUser);
    }

    /** Fonction permettant la connexion d'un utilisateur
     *
     * @param loginUserDto variable contenant les informations de connexion d'un utilisateur
     * @return user
     */
    public User authenticate(LoginUserDto loginUserDto) {
        authService.verify(loginUserDto);
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
        return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(UserNotFoundException::new);
    }

    /** Fonction qui retourne l'utilisateur courant
     *
     * @return user
     */
    public User currentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }

    /** Fonction qui effectue les vérifications métier pour créer un utilisateur
     *
     * @param registerUserDto Variable contenant les données pour inscrire un utilisateur
     */
    public void verify(RegisterUserDto registerUserDto) {
        authService.registerVerify(registerUserDto);
    }
}
