package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Collaboration;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/** Repository pour l'entité {@link Collaboration}.
 * Permet d'effectuer des opérations CRUD sur la table "collaborations".
 */
@Repository
public interface CollaborationRepository extends JpaRepository<Collaboration, Long> {
    /** Fonction permettant de retrouver toutes les collaborations d'un utilisateur
     *
     * @param user variable contenant les données d'un utilisateur
     * @return liste des collaboration d'un utilisateur
     */
    List<Collaboration> findByUser(User user);

    /** Fonction permettant de retrouver toutes les collaborations d'un projet
     *
     * @param project variable contenant les données d'un projet
     * @return liste des collaboration d'un projet
     */
    List<Collaboration> findByProject(Project project);

    /** Fonction permettant de trouver une collaboration liée à un utilisateur et un projet
     *
     * @param user variable contenant les données d'un utilisateur
     * @param project variable contenant les données d'un projet
     * @return collaboration
     */
    Optional<Collaboration> findByUserAndProject(User user, Project project);
}
