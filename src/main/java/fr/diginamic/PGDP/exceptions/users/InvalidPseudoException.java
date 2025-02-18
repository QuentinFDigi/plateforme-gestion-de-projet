package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class InvalidPseudoException extends RuntimeException {
    /** Fonction retournant une exception si le pseudo renseigné est invalide. */
    public InvalidPseudoException() {
        super("Veuillez renseigner un pseudonyme.", new Throwable("Veuillez renseigner un pseudonyme."));
    }
}
