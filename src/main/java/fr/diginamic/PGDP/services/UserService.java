package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.users.UserUpdateDto;
import fr.diginamic.PGDP.exceptions.users.*;
import org.springframework.stereotype.Service;

import java.util.Objects;

/** Classe contenant les vérifications métier de la classe User */
@Service
public class UserService {

    /** Variable contenant le pattern demandé pour un mot de passe */
    private final String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    /** Fonction permettant de vérifier les données à modifier pour un utilisateur
     *
     * @param userUpdateDto variable contenant les modifications de l'utilisateur
     */
    // TODO : A changer
    public void updateVerify(UserUpdateDto userUpdateDto) {
        if (Objects.equals(userUpdateDto.getLastName(), "")){
            throw new InvalidLastNameException();
        }else if (Objects.equals(userUpdateDto.getFirstName(), "")){
            throw new InvalidFirstNameException();
        }else if (Objects.equals(userUpdateDto.getPseudo(), "")) {
            throw new InvalidPseudoException();
        }else if (Objects.equals(userUpdateDto.getEmail(), "")){
            throw new InvalidEmailException();
        }else if (!userUpdateDto.getPassword().matches(pattern)){
            throw new InvalidPasswordException();
        }
    }
}
