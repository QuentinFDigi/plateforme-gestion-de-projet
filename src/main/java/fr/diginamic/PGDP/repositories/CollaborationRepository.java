package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Collaboration;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** Classe qui va communiquer avec la table Collaboration dans la base de données */
@Repository
public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {
    /** Fonction permettant de retrouver toutes les collaborations d'un utilisateur */
    List<Collaboration> findByUser(User user);
    /** Fonction permettant de trouver une collaboration liée à un utilisateur et un projet */
    Optional<Collaboration> findByUserAndProject(User user, Project project);
}
