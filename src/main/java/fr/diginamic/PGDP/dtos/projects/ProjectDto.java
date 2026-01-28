package fr.diginamic.PGDP.dtos.projects;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/** Classe contenant la structure d'affichage d'un projet */
@Getter
@Setter
@Builder
public class ProjectDto {

    /** ID auto-générer en base de données */
    private long id;

    /** Variable contenant le nom d'un projet */
    private String name;

    /** Variable indiquant la date de début d'un projet */
    private LocalDate startDate;

    /** Variable indiquant la date de fin d'un projet */
    private LocalDate endDate;

    /** Variable contenant une description du projet*/
    private String description;

    /** Variable contenant le moyen de contact pour le projet */
    private String contact;


    @Override
    public String toString() {
        return "ProjectDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
