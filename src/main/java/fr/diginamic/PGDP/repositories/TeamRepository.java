package fr.diginamic.PGDP.repositories;

import fr.diginamic.PGDP.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository pour l'entité {@link Team}.
 * Permet d'effectuer des opérations CRUD sur la table "teams".
 *
 * @author Romain Wyon
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    /**
     * Recherche une équipe par son nom.
     *
     * @param name Nom de l'équipe
     * @return Un {@link Optional} contenant l'équipe si elle est trouvée, sinon vide
     */
    Optional<Team> findByName(String name);
}
