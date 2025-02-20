package fr.diginamic.PGDP.exceptions.teams;

/**
 * Exception levée lorsqu'une équipe recherchée n'existe pas en base de données.
 *
 * @author Romain Wyon
 */
public class TeamNotFoundException extends RuntimeException {

    /**
     * Constructeur prenant un message d'erreur.
     *
     * @param message Message détaillant l'erreur
     */
    public TeamNotFoundException(String message) {
        super(message);
    }
}
