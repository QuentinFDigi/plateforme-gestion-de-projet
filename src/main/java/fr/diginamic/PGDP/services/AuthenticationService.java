package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.users.LoginUserDto;
import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.exceptions.users.UserNotFoundException;
import fr.diginamic.PGDP.repositories.UserRepository;
import fr.diginamic.PGDP.transformers.UserTransformer;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UserTransformer userTransformer;
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationService(UserTransformer userTransformer, AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.userTransformer = userTransformer;
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }

    public User signUp(RegisterUserDto registerUserDto) {
        User registeredUser = userTransformer.registerUserDtoToUser(registerUserDto);
        return userRepository.save(registeredUser);
    }

    public User authenticate(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword()));
        return userRepository.findByEmail(loginUserDto.getEmail()).orElseThrow(UserNotFoundException::new);
    }
}
