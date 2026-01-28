package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class UserNotFoundException extends RuntimeException {
    /** Fonction retournant une exception si l'utilisateur n'est pas trouvé. */
    public UserNotFoundException() {
        super("Utilisateur non trouvé.",new Throwable("Utilisateur non trouvé."));
    }
}
