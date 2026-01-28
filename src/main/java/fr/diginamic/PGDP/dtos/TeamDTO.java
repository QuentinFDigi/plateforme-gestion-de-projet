package fr.diginamic.PGDP.dtos;

import java.util.List;

/**
 * Data Transfer Object (DTO) pour l'entité {@link com.formation.bootstrap.entities.Team}.
 * Utilisé pour transférer les données entre la couche service et la couche contrôleur.
 *
 * @author Romain Wyon
 */
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

    // Getters et Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
