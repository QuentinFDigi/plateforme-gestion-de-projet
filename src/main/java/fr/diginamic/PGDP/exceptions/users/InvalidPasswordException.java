package fr.diginamic.PGDP.exceptions.users;

/** Classe enfant de RunTimeException */
public class InvalidPasswordException extends RuntimeException {
    /** Fonction retournant une exception si le mot de passe renseigné est invalide. */
    public InvalidPasswordException() {
        super("Veuillez entrer un mot de passe valide.", new Throwable("Veuillez entrer un mot de passe valide."));
    }
}
