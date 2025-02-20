package fr.diginamic.PGDP.transformers;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.entities.Project;
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
        ProjectDto projectDto = new ProjectDto();

        projectDto.setName(project.getName());
        projectDto.setStartDate(project.getStartDate());
        projectDto.setEndDate(project.getEndDate());
        projectDto.setDescription(project.getDescription());
        projectDto.setContact(project.getContact());

        return projectDto;
    }

    /** Fonction qui transforme un projetAjoutOuModifie en un projet lors de l'ajout d'un projet
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return project
     */
    public Project projectAddDtoToProject(ProjectAddOrModifyDto projectAddOrModifyDto){
        Project project = new Project();

        project.setName(projectAddOrModifyDto.getName());
        project.setStartDate(LocalDate.now());
        project.setEndDate(projectAddOrModifyDto.getEndDate());
        project.setDescription(projectAddOrModifyDto.getDescription());
        // TODO : "test@test.com" à modifier par l'adresse mail de l'utilisateur courant
        project.setContact(projectAddOrModifyDto.getContact() == null ? "test@test.com" : projectAddOrModifyDto.getContact());

        return project;
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
        // TODO : "test@test.com" à modifier par l'adresse mail de l'utilisateur courant
        project.setContact(projectAddOrModifyDto.getContact() == null ? project.getContact() : projectAddOrModifyDto.getContact());

        return  project;
    }
}
