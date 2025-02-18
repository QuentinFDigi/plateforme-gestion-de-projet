package fr.diginamic.PGDP.managers;

import fr.diginamic.PGDP.dtos.users.UserDto;
import fr.diginamic.PGDP.dtos.users.UserUpdateDto;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.exceptions.users.UserNotFoundException;
import fr.diginamic.PGDP.repositories.UserRepository;
import fr.diginamic.PGDP.services.UserService;
import fr.diginamic.PGDP.transformers.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/** Classe gérant les fonctionnalités de l'utilisateur */
@Component
public class UserManager {

    /** Variable permettant de faire appel à la classe userRepository pour communiquer avec la base de données */
    @Autowired
    private UserRepository userRepository;

    /** Variable permettant de faire appel à la classe UserTransformer qui fera des transformations entre la classe
     * User et les différents UserDto */
    @Autowired
    private UserTransformer userTransformer;

    /** Variable permettant de faire appel à la classe UserService qui fera des vérifications métier */
    @Autowired
    private UserService userService;

    /** Fonction récupérant une liste d'utilisateur puis les transforme en utilisateurDto
     *  et retourne la liste des utilisateur dto
     *
     * @return liste de userDto
     */
    public List<UserDto> allUsers() {
        List<UserDto> usersDto = new ArrayList<>();
        List<User> users = new ArrayList<>(userRepository.findAll());

        for (User user : users) {
            usersDto.add(userTransformer.userToUserDto(user));
        }

        return usersDto;
    }

    /** Fonction récupérant un utilisateur grâce à son ID
     *  et le transformant en utilisateurDto pour le renvoyer
     *
     * @param id identifiant de l'utilisateur
     * @return userDto
     */
    public UserDto findUserById(long id) {
        return userTransformer.userToUserDto(userRepository.findById(id).orElseThrow(UserNotFoundException::new));
    }

    /** Fonction qui appelle le userService pour vérifier si les données entrées sont correctes.
     *
     * @param userUpdateDto variable qui contient les modifications apportées à l'utilisateur
     */
    public void updateVerify(UserUpdateDto userUpdateDto) {
        userService.updateVerify(userUpdateDto);
    }

    /** Fonction récupérant l'utilisateurModifierDto à modifier, le transformant en utilisateur,
     *  sauvegarde les modifications apportées et le transforme en utilisateurDto pour le renvoyer.
     *
     * @param id identifiant de l'utilisateur
     * @param userUpdateDto variable qui contient les modifications apportées à l'utilisateur
     * @return userDto
     */
    public UserDto update(Long id, UserUpdateDto userUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        user = userTransformer.userUpdateDtoToUser(userUpdateDto,user);

        userRepository.save(user);

        return userTransformer.userToUserDto(user);
    }

    /** Fonction qui permet de supprimer un utilisateur selon son ID
     *
     * @param id identifiant de l'utilisateur
     */
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }
}
