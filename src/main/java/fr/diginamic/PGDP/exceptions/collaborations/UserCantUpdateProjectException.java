package fr.diginamic.PGDP.exceptions.collaborations;

/** Classe enfant de RunTimeException */
public class UserCantUpdateProjectException extends RuntimeException {
    /** Fonction retournant une exception si l'utilisateur n'a pas les droits pour modifier un projet. */
    public UserCantUpdateProjectException() {
        super("Vous n'avez pas les droit nécessaire pour modifier le projet.", new Throwable("Vous n'avez pas les droit nécessaire pour modifier le projet."));
    }
}
