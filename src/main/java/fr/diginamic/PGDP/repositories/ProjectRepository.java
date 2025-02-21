package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** Repository pour l'entité {@link Project}.
 * Permet d'effectuer des opérations CRUD sur la table "projects".
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    /** Fonction permettant de trouver un projet grâce à son ID
     *
     * @param id identifiant du projet
     * @return project
     */
    Optional<Project> findById(long id);
}
