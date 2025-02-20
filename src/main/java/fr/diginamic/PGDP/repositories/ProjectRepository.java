package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/** Classe qui va communiquer avec la table Project dans la base de données */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /** Fonction permettant de trouver un projet grâce à son ID */
    Optional<Project> findById(long id);
}
