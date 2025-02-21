package fr.diginamic.PGDP.exceptions.collaborations;

public class CollaborationNotFoundException extends RuntimeException {
    public CollaborationNotFoundException() {
        super("Aucun lien n'a été trouvé entre le projet et l'utilisateur.", new Throwable("Aucun lien n'a été trouvé entre le projet et l'utilisateur."));
    }
}
