package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class InvalidFirstNameException extends RuntimeException {
    /** Fonction retournant une exception si le prénom renseigné est invalide. */
    public InvalidFirstNameException() {
        super("Veuillez renseigner votre prénom.",new Throwable("Veuillez renseigner votre prénom."));
    }
}
