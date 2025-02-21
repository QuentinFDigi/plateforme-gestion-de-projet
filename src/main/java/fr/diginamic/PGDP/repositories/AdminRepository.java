package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Admin;
import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Repository pour l'entité {@link Admin}.
 * Permet d'effectuer des opérations CRUD sur la table "admins".
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    /** Fonction permettanbt de récupérer un administrateur grâce à son nom d'utilisateur
     *
     * @param username variable contenant le nom de l'utilisateur
     * @return userDetail
     */
    Optional<UserDetails> findByUsername(String username);
}
