package fr.diginamic.PGDP.exceptions.projects;

/** Classe enfant de RunTimeException */
public class ProjectNotFoundException extends RuntimeException {
    /** Fonction retournant une exception si le projet n'est pas trouvé. */
    public ProjectNotFoundException() {
        super("Projet non trouvé", new Throwable("Projet non trouvé"));
    }
}
