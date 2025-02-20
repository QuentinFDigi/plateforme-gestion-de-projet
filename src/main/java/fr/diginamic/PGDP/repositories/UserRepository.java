package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Classe qui va communiquer avec la base de données */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    /** Fonction permettant de trouver un utilisateur grâce à son pseudo */
    Optional<UserDetails> findByPseudo(String pseudo);
    /** Fonction permettant de trouver un utilisateur grâce à son ID */
    Optional<User> findById(long id);
}
