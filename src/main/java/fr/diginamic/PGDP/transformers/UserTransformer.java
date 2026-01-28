package fr.diginamic.PGDP.transformers;

import fr.diginamic.PGDP.dtos.users.RegisterUserDto;
import fr.diginamic.PGDP.dtos.users.UserDto;
import fr.diginamic.PGDP.dtos.users.UserUpdateDto;
import fr.diginamic.PGDP.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Classe qui va permettre de faire diverses transformations entre la classe user et les usersDto
 */
@Service
public class UserTransformer {

    /**
     * Variable permettant d'accéder au passwordEncoder pour encoder les mots de passe
     */
    private final PasswordEncoder passwordEncoder;

    public UserTransformer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Fonction qui transforme un utilisateur en un utilisateurDto
     *
     * @param user variable contenant les données d'un utilisateur
     * @return userDto
     */
    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFullName(user.getFirstName() + " " + user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setEmailConfirmed(user.isEmailConfirmed());

        return userDto;
    }

    /**
     * Fonction permettant de transformer un utilisateurModifierDto en Utilisateur
     *
     * @param userUpdateDto variable contenant les modifications apportées à un utilisateur
     * @param user          variable qui contient les informations de l'utilisateur à modifier
     * @return user
     */
    public User userUpdateDtoToUser(UserUpdateDto userUpdateDto, User user) {
        user.setLastName(userUpdateDto.getLastName());
        user.setFirstName(userUpdateDto.getFirstName());
        user.setPseudo(userUpdateDto.getPseudo());
        user.setEmail(userUpdateDto.getEmail());
        user.setPassword(passwordEncoder.encode(userUpdateDto.getPassword()));

        return user;
    }

    public User registerUserDtoToUser(RegisterUserDto registerUserDto) {
        return User.builder()
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .emailConfirmed(false)
                .firstName(registerUserDto.getFirstName())
                .lastName(registerUserDto.getLastName())
                .pseudo(registerUserDto.getPseudo())
                .build();
    }
}
