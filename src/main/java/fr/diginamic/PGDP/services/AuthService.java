package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.users.LoginUserDto;
import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.exceptions.users.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {
    // TODO : A changer (obsoléte depuis jakarta.validation)
    public void verify(LoginUserDto loginUserDto) {
        if (Objects.equals(loginUserDto.getEmail(), "")){
            throw new InvalidEmailException();
        } else if (Objects.equals(loginUserDto.getPassword(), "")){
            throw new InvalidPasswordException();
        }
    }
}
