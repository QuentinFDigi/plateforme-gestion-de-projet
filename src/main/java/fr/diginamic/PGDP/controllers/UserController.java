package fr.diginamic.PGDP.controllers;

import fr.diginamic.PGDP.dtos.users.UserDto;
import fr.diginamic.PGDP.dtos.users.UserUpdateDto;
import fr.diginamic.PGDP.managers.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Classe permettant de gérer la logique système */
@RequestMapping("/users")
@RestController
public class UserController {

    /** Variable permettant de faire appel à la classe userManager
     * et ses fonctions contenant la logique des diverses fonctionnalités */
    @Autowired
    private UserManager userManager;

    /** Fonction retournant une liste d'utilisateur.
     *
     * @return liste de usersDto
     */
    @GetMapping
    public List<UserDto> allUsers(){
        return userManager.allUsers();
    }

    /** Fonction retournant un utilisateur.
     *
     * @param id identifiant de l'utilisateur
     * @return userDto
     */
    @GetMapping("/{id}")
    public UserDto findUser(@PathVariable long id){
        return  userManager.findUserById(id);
    }

    /** Fonction permettant de modifier un utilisateur et de le renvoyer une fois modifier.
     *
     * @param id identifiant de l'utilisateur
     * @param userUpdateDto Variable contenant les modification de l'utilisateur
     * @return userDto
     */
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable long id, @RequestBody UserUpdateDto userUpdateDto){
        userManager.updateVerify(userUpdateDto);
        return userManager.update(id, userUpdateDto);
    }

    /** Fonction permettant de supprimer un utilisateur.
     *
     * @param id identifiant de l'utilisateur
     */
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable long id){
        userManager.deleteUser(id);
    }
}
