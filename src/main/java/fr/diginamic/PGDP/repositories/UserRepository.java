package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Team;
import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Repository pour l'entité {@link User}.
 * Permet d'effectuer des opérations CRUD sur la table "users".
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /** Fonction permettant de trouver un utilisateur grâce à son email
     *
     * @param email variable contenant l'email de l'utilisateur
     * @return user
     */
    Optional<User> findByEmail(String email);

    /** Fonction permettant de trouver un utilisateur grâce à son pseudo
     *
     * @param pseudo variable contenant le pseudonyme de l'utilisateur
     * @return userDetails
     */
    Optional<UserDetails> findByPseudo(String pseudo);

    /** Fonction permettant de trouver un utilisateur grâce à son ID
     *
     * @param id identifiant de l'utilisateur
     * @return user
     */
    Optional<User> findById(long id);
}
