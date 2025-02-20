package fr.diginamic.PGDP.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/** Classe gérant la structure d'un projet */
@Entity
@Table(name = "project")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "project")
    private List<Collaboration> collaborators;

    @ManyToOne()
    @JoinColumn(name="id_User")
    private User creator;

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
