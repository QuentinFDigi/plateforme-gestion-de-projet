package fr.diginamic.PGDP.exceptions.collaborations;

/** Classe enfant de RunTimeException */
public class UserCantAccessToProjectException extends RuntimeException {
    /** Fonction retournant une exception si l'utilisateur n'a pas accès au projet */
    public UserCantAccessToProjectException() {
        super("Vous n'avez pas accés à ce projet.", new Throwable("Vous n'avez pas accés à ce projet."));
    }
}
