package fr.diginamic.PGDP.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

/** Classe gérant la structure d'un projet */
public class Project {

    /** ID auto-générer en base de données */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    /** Variable contenant le nom d'un projet */
    @Column(nullable = false)
    private String name;

    /** Variable indiquant la date de début d'un projet */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    /** Variable indiquant la date de fin d'un projet */
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    /** Variable contenant une description du projet */
    @Column
    private String description;

    /** Variable contenant le moyen de contact pour le projet */
    @Column
    private String contact;

    /** Constructeur vide pour JPA */
    public Project() {
    }

    /** Constructeur de la classe projet
     *
     * @param name nom du projet
     * @param startDate date du début du projet
     * @param endDate date de fin du projet
     * @param description description du projet
     * @param contact moyen de contact du projet
     */
    public Project(String name, LocalDate startDate, LocalDate endDate, String description, String contact) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.contact = contact;
    }

    /** Getter
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /** Getter
     *
     * @return name
     */
    public String getName() {
        return name;
    }


    /** Setter
     *
     * @param name Nom du projet
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /** Setter
     *
     * @param startDate date de début du projet
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /** Getter
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /** Setter
     *
     * @param endDate date de fin du projet
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /** Getter
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /** Setter
     *
     * @param description description du projet
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /** Getter
     *
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /** Setter
     *
     * @param contact moyen de contact du projet
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return id == project.id && Objects.equals(name, project.name) && Objects.equals(startDate, project.startDate) && Objects.equals(endDate, project.endDate) && Objects.equals(description, project.description) && Objects.equals(contact, project.contact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, description, contact);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
