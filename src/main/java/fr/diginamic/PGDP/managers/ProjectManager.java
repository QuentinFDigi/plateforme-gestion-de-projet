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
import fr.diginamic.PGDP.services.AuthService;
import fr.diginamic.PGDP.services.ProjectService;
import fr.diginamic.PGDP.transformers.ProjectTransformer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Classe contenant la logique des diverses opérations mener sur un projet */
@Service
public class ProjectManager {

    /** Variable permettant de faire appel à la classe projectRepository pour communiquer avec la base de données */
    private final ProjectRepository projectRepository;

    /** Variable permettant de faire appel à la classe projectService afin de faire des vérifications métier */
    private final ProjectService projectService;

    /** Variable permettant de faire appel à la classe projectTransformer afin de transformer la classe projet en diverses DTO */
    private final ProjectTransformer projectTransformer;

    /** Variable permettant de gérer les fonctionnalité de l'authentification */
    private final AuthManager authManager;

    /** Variable permettant de faire appel à la classe collaborationRepository pour communiquer avec la base de données */
    private final CollaborationRepository collaborationRepository;

    /** Constructeur pour les différents services
     *
     * @param projectRepository variable permettant de faire des échanges avec la table projet en bdd
     * @param projectService variable permettant de faire des test métier
     * @param projectTransformer variable permettant de transformer des projects en projectsDto
     * @param authManager variable permettant de gérer les fonctionnalité de l'authentification
     * @param collaborationRepository variable permettant de faire des échanges avec la table collaborations en bdd
     */
    public ProjectManager(ProjectRepository projectRepository, ProjectService projectService, ProjectTransformer projectTransformer, AuthManager authManager, CollaborationRepository collaborationRepository) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.projectTransformer = projectTransformer;
        this.authManager = authManager;
        this.collaborationRepository = collaborationRepository;
    }

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
        User user = authManager.currentUser();

        return collaborationRepository.findByUserAndProject(user,project).orElseThrow(UserCantAccessToProjectException::new);
    }

    /** Fonction permettant de vérifier les droit d'un utilisateur
     *
     * @param id identifiant
     */
    public void verifyUserPerm(long id){
        projectService.verifyUserPerm(verifyUser(id));
    }

    /** Fonction permettant d'ajouter un nouveau projet en utilisant le transformer puis le repository afin de sauvegarder les données
     *
     * @param projectAddOrModifyDto variable contenant les données d'un projet
     * @return projectDto
     */
    public ProjectDto addProject(ProjectAddOrModifyDto projectAddOrModifyDto) {
        User currentUser = authManager.currentUser();
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

        return authManager.currentUser().getCreatedProjects().stream()
                .map(projectTransformer::projectToProjectDto)
                .collect(Collectors.toList());
    }

    /** Fonction retournant la liste des projets où l'utilisateur collabore
     *
     * @return Liste des projectsDto où l'utilisateur collabore
     */
    public List<ProjectDto> findAllProjectsWhereCurrentUserCollaborate() {
        return collaborationRepository.findByUser(authManager.currentUser()).stream()
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
