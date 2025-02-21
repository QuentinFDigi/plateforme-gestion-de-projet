package fr.diginamic.PGDP.dtos.teams;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Data Transfer Object (DTO) pour l'entité {@link fr.diginamic.PGDP.entities.Team}.
 * Utilisé pour transférer les données entre la couche service et la couche contrôleur.
 *
 * @author Romain Wyon
 */
@Getter
@Setter
public class TeamDTO {

    /**
     * Identifiant de l'équipe.
     */
    private Long id;

    /**
     * Nom de l'équipe.
     */
    private String name;

    /**
     * Liste des contacts (emails) de l'équipe.
     */
    private List<String> contacts;

    /**
     * Description de l'équipe.
     */
    private String description;

    /**
     * Constructeur par défaut.
     */
    public TeamDTO() {}

    /**
     * Constructeur avec paramètres.
     *
     * @param id Identifiant de l'équipe
     * @param name Nom de l'équipe
     * @param contacts Liste des emails
     * @param description Description de l'équipe
     */
    public TeamDTO(Long id, String name, List<String> contacts, String description) {
        this.id = id;
        this.name = name;
        this.contacts = contacts;
        this.description = description;
    }

    @Override
    public String toString() {
        return "TeamDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacts=" + contacts +
                ", description='" + description + '\'' +
                '}';
    }
}
