package fr.diginamic.PGDP.exceptions.teams;

/**
 * Exception levée lorsqu'une équipe portant le même nom existe déjà en base de données.
 *
 * @author Romain Wyon
 */
public class DuplicateTeamException extends RuntimeException {

    /**
     * Constructeur prenant un message d'erreur.
     *
     * @param message Message détaillant l'erreur
     */
    public DuplicateTeamException(String message) {
        super(message);
    }
}
