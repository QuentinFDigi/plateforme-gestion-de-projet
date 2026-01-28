package fr.diginamic.PGDP.transformers;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/** Classe qui va permettre de faire diverses transformations entre la classe project et les projectsDto */
@Component
public class ProjectTransformer {

    /** Fonction qui transforme un projet en un projetDto
     *
     * @param project variable contenant les données d'un projet
     * @return projectDto
     */
    public ProjectDto projectToProjectDto(Project project){
        return ProjectDto.builder()
                .name(project.getName())
                .startDate(project.getStartDate())
                .endDate(project.getEndDate())
                .description(project.getDescription())
                .contact(project.getContact())
                .build();
    }

    /** Fonction qui transforme un projetAjoutOuModifie en un projet lors de l'ajout d'un projet
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return project
     */
    public Project projectAddDtoToProject(ProjectAddOrModifyDto projectAddOrModifyDto, User currentUser){
        return Project.builder().name(projectAddOrModifyDto.getName())
                .startDate(LocalDate.now())
                .endDate(projectAddOrModifyDto.getEndDate())
                .description(projectAddOrModifyDto.getDescription())
                .contact(projectAddOrModifyDto.getContact() == null ? currentUser.getEmail() : projectAddOrModifyDto.getContact())
                .creator(currentUser)
                .build();
    }

    /** Fonction qui transforme un projetAjoutOuModifie en un projet lors de la modification d'un projet
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @param project variable contenant les données du projet à modifier
     * @return project
     */
    public Project projectModifyDtoToProject(ProjectAddOrModifyDto projectAddOrModifyDto, Project project){
        project.setName(projectAddOrModifyDto.getName());
        project.setEndDate(projectAddOrModifyDto.getEndDate());
        project.setDescription(projectAddOrModifyDto.getDescription());
        project.setContact(projectAddOrModifyDto.getContact() == null ? project.getContact() : projectAddOrModifyDto.getContact());

        return  project;
    }
}
