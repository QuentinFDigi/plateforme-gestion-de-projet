package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class InvalidEmailException extends RuntimeException {
    /** Fonction retournant une exception si l'email renseigné est invalide. */
    public InvalidEmailException() {
        super("Veuillez renseigner votre email", new Throwable("Veuillez renseigner votre email"));
    }
}
