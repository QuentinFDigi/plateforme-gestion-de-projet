package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Classe qui va communiquer avec la table User dans la base de données */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /** Fonction permettant de trouver un utilisateur grâce à son adresse mail */
    Optional<User> findByEmail(String email);
    /** Fonction permettant de trouver un utilisateur grâce à son ID */
    Optional<User> findById(long id);
}
