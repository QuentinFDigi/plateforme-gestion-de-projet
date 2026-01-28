package fr.diginamic.PGDP.exceptions.projects;

/** Classe enfant de RunTimeException */
public class InvalidNameException extends RuntimeException {
    /** Fonction retournant une exception si le nom renseigné est invalide. */
    public InvalidNameException() {
        super("Veuillez renseigner le nom du projet.", new Throwable("Veuillez renseigner le nom du projet."));
    }
}
