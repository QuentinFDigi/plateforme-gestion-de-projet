package fr.diginamic.PGDP.exceptions.teams;

/**
 * Exception levée lorsqu'une équipe possède des données invalides (nom vide, emails incorrects...).
 *
 * @author Romain Wyon
 */
public class InvalidTeamDataException extends RuntimeException {

    /**
     * Constructeur prenant un message d'erreur.
     *
     * @param message Message détaillant l'erreur
     */
    public InvalidTeamDataException(String message) {
        super(message);
    }
}
