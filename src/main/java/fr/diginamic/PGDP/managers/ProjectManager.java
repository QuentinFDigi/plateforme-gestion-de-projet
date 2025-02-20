package fr.diginamic.PGDP.managers;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.entities.Collaboration;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.exceptions.collaborations.UserCantAccessToProjectException;
import fr.diginamic.PGDP.exceptions.projects.ProjectNotFoundException;
import fr.diginamic.PGDP.repositories.CollaborationRepository;
import fr.diginamic.PGDP.repositories.ProjectRepository;
import fr.diginamic.PGDP.services.AuthenticationService;
import fr.diginamic.PGDP.services.ProjectService;
import fr.diginamic.PGDP.transformers.ProjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private CollaborationRepository collaborationRepository;

    /** Fonction permettant de retrouver un projet grâce à son ID
     *
     * @param id identifiant du projet
     * @return projectDto
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

    /** Fonction qui appelle le projectService afin de vérifier si l'utilisateur participe au projet
     *
     * @param id identifiant du projet
     */
    public Collaboration verifyUser(long id) {
        Project project = projectRepository.findById(id).orElseThrow(ProjectNotFoundException::new);
        User user = authenticationService.currentUser();

        return collaborationRepository.findByUserAndProject(user,project).orElseThrow(UserCantAccessToProjectException::new);
    }

    public void verifyUserPerm(long id){
        projectService.verifyUserPerm(verifyUser(id));
    }

    /** Fonction permettant d'ajouter un nouveau projet en utilisant le transformer puis le repository afin de sauvegarder les données
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return projectDto
     */
    public ProjectDto addProject(ProjectAddOrModifyDto projectAddOrModifyDto) {
        User currentUser = authenticationService.currentUser();
        Project project = projectTransformer.projectAddDtoToProject(projectAddOrModifyDto, currentUser);

        Collaboration collaboration = new Collaboration(project,currentUser);

        collaborationRepository.save(collaboration);
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



    /** Fonction retournant la liste des projets créés par l'utilisateur
     *
     * @return Liste des projectsDto créer par l'utilisateur courant
     */
    public List<ProjectDto> findAllProjectsCreatedByCurrentUser() {
//        User currentUser = authenticationService.currentUser();
//
//        List<Project> projects = new ArrayList<>(currentUser.getProjectsCreated());
//
//        List<ProjectDto> projectDtos = new ArrayList<>();
//
//        for (Project project : projects){
//            projectDtos.add(projectTransformer.projectToProjectDto(project));
//        }
//
//        return projectDtos;

        return authenticationService.currentUser().getProjectsCreated().stream()
                .map(projectTransformer::projectToProjectDto)
                .collect(Collectors.toList());
    }

    /** Fonction retournant la liste des projets où l'utilisateur collabore
     *
     * @return Liste des projectsDto où l'utilisateur collabore
     */
    public List<ProjectDto> findAllProjectsWhereCurrentUserCollaborate() {
        return collaborationRepository.findByUser(authenticationService.currentUser()).stream()
                .map(Collaboration::getProject)
                .map(projectTransformer::projectToProjectDto)
                .collect(Collectors.toList());
    }

    /** Fonction retournant l'intégralité des projets où l'utilisateur participe
     *
     * @return Liste des projectsDto où l'utilisateur participe
     */
    public List<ProjectDto> findAllProjectsOfCurrentUser() {
        return Stream.concat(
                        findAllProjectsCreatedByCurrentUser().stream(),
                        findAllProjectsWhereCurrentUserCollaborate().stream()
                )
                .distinct()
                .collect(Collectors.toList());
    }
}
