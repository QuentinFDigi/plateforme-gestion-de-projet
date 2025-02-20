package fr.diginamic.PGDP.exceptions.projects;

/** Classe enfant de RunTimeException */
public class InvalidEndDateException extends RuntimeException {
    /** Fonction retournant une exception si la date de fin renseigné est invalide. */
    public InvalidEndDateException() {
        super("Date de fin non valide. La date doit être supérieure à la date d'aujourd'hui.", new Throwable("Date de fin non valide. La date doit être supérieure à la date d'aujourd'hui."));
    }
}
