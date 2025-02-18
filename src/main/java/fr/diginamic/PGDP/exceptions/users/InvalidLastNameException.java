package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class InvalidLastNameException extends RuntimeException {
    /** Fonction retournant une exception si le nom renseigné est invalide. */
    public InvalidLastNameException() {
        super("Veuillez renseigner votre nom.", new Throwable("Veuillez renseigner votre nom."));
    }
}
