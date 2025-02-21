package fr.diginamic.PGDP.exceptions.projects;

/** Classe enfant de RunTimeException */
public class ProjectNotFoundException extends RuntimeException {
    /** Fonction retournant une exception si le projet n'est pas trouvé. */
    public ProjectNotFoundException(String projectId) {
        super("Projet non trouvé, project id : " + projectId, new Throwable("Projet non trouvé"));
    }
}
