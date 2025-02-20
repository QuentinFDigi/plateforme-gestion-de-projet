package fr.diginamic.PGDP.managers;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.exceptions.projects.ProjectNotFoundException;
import fr.diginamic.PGDP.repositories.ProjectRepository;
import fr.diginamic.PGDP.services.ProjectService;
import fr.diginamic.PGDP.transformers.ProjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;

/** Classe contenant la logique des diverses opérations mener sur un projet */
public class ProjectManager {

    /** Variable permettant de faire appel à la classe projectRepository pour communiquer avec la base de données */
    @Autowired
    private ProjectRepository projectRepository;

    /** Variable permettant de faire appel à la classe projectService afin de faire des vérifications métier */
    @Autowired
    private ProjectService projectService;

    /** Variable permettant de faire appel à la classe projectTransformer afin de transformer la classe projet en diverses DTO */
    @Autowired
    private ProjectTransformer projectTransformer;

    /** Fonction permettant de retrouver un projet grâce à son ID
     *
     * @param id
     * @return
     */
    public ProjectDto findById(long id) {
        return projectTransformer.projectToProjectDto(projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new));
    }

    /** Fonction permettant de faire appel au service de vérification afin de vérifier que les données envoyer son correcte
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     */
    public void verify(ProjectAddOrModifyDto projectAddOrModifyDto) {
        projectService.verify(projectAddOrModifyDto);
    }

    /** Fonction permettant d'ajouter un nouveau projet en utilisant le transformer puis le repository afin de sauvegarder les données
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return projectDto
     */
    public ProjectDto addProject(ProjectAddOrModifyDto projectAddOrModifyDto) {
        Project project = projectTransformer.projectAddDtoToProject(projectAddOrModifyDto);

        projectRepository.save(project);

       return projectTransformer.projectToProjectDto(project);
    }

    /** Fonction permettant la modification d'un projet retrouvé grâce à son ID,
     * le modifiant grâce au transformer puis le retransformer en projectDto pour retourner les modifications
     *
     * @param id identifiant du projet
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return projectDto
     */
    public ProjectDto modifyProject(long id, ProjectAddOrModifyDto projectAddOrModifyDto) {
        Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);

        project = projectTransformer.projectModifyDtoToProject(projectAddOrModifyDto, project);
        projectRepository.save(project);

        return projectTransformer.projectToProjectDto(project);
    }

    /** Fonction permettant de supprimer un projet grâce à son identifiant
     *
     * @param id identifiant du projet
     */
    public void delete(long id) {
        Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);

        projectRepository.delete(project);
    }

    public void findAllProjectsOfCurrentUser() {
    }
}
