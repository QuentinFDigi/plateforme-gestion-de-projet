package fr.diginamic.PGDP.entities;

import jakarta.persistence.*;
import java.util.List;

/**
 * Représente une équipe avec un identifiant, un nom, une liste de contacts (emails) et une description.
 *
 * @author Romain Wyon
 */
@Entity
@Table(name = "teams")
public class Team {

    /**
     * Identifiant unique de l'équipe, généré automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nom de l'équipe.
     */
    @Column(nullable = false, unique = true)
    private String name;

    /**
     * Liste des contacts (adresses email) associés à l'équipe.
     */
    @ElementCollection
    @CollectionTable(name = "team_contacts", joinColumns = @JoinColumn(name = "team_id"))
    @Column(name = "email", nullable = false)
    private List<String> contacts;

    /**
     * Description de l'équipe.
     */
    @Column(columnDefinition = "TEXT")
    private String description;

    /**
     * Constructeur par défaut.
     */
    public Team() {}

    /**
     * Constructeur avec paramètres.
     *
     * @param name Nom de l'équipe
     * @param contacts Liste des emails des contacts
     * @param description Description de l'équipe
     */
    public Team(String name, List<String> contacts, String description) {
        this.name = name;
        this.contacts = contacts;
        this.description = description;
    }

    // Getters et setters

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
