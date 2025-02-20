package fr.diginamic.PGDP.controllers;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.dtos.users.UserDto;
import fr.diginamic.PGDP.managers.ProjectManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/** Classe permettant de gérer la logique système */
@RequestMapping("/projects")
@RestController
public class ProjectController {

    /** Variable permettant de faire appel à la classe projectManager
     * et ses fonctions contenant la logique des diverses fonctionnalités */
    @Autowired
    ProjectManager projectManager;

    @GetMapping
    public List<ProjectDto> findAllProjectsOfCurrentUser(){

        // TODO : Créer une fonction retournant la liste des projets de l'utilisateur courant

        return new ArrayList<>();
    }

    /** Fonction retournant un projet selon son identifiant
     *
     * @param id identifiant du projet
     * @return projectDto
     */
    @GetMapping("/{id}")
    public ProjectDto findProject(@PathVariable long id){

        // TODO : Ajouter une vérification si l'utilisateur appartient bien au projet

        return projectManager.findById(id);
    }

    /** Fonction permettant d'ajouter un projet
     *
     * @param projectAddOrModifyDto variable cotenant les données du nouveau projet
     * @return projectDto
     */
    @PostMapping
    public ProjectDto addProject(@RequestBody ProjectAddOrModifyDto projectAddOrModifyDto){

        // TODO : Ajouter une vérification si l'utilisateur appartient bien au projet

        projectManager.verify(projectAddOrModifyDto);
        return projectManager.addProject(projectAddOrModifyDto);
    }

    /** Fonction permettant de modifier un projet
     *
     * @param id identifiant du projet
     * @param projectAddOrModifyDto variable contenant les nouvelles informations du projet
     * @return projectDto
     */
    @PutMapping("/{id}")
    public ProjectDto updateProject(@PathVariable long id, @RequestBody ProjectAddOrModifyDto projectAddOrModifyDto){

        // TODO : Ajouter une vérification si l'utilisateur appartient bien au projet

        projectManager.verify(projectAddOrModifyDto);
        return projectManager.modifyProject(id, projectAddOrModifyDto);
    }

    /** Fonction permettant de supprimer un projet
     *
     * @param id identifiant du projet
     */
    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable long id){
        projectManager.delete(id);
    }

    /** Fonction retournant la liste des taches d'un projet
     *
     * @param idProject identifiant du projet
     * @return projectTasks
     */
    @GetMapping("/{idProject}/tasks")
    public List<Object> allProjectTasks(@PathVariable long idProject){

        // TODO : Créer une fonction retournant la liste des taches d'un projet

        return new ArrayList<>();
    }

    /** Fonction retournant la liste des taches d'une user story
     *
     * @param idProject identifiant du projet
     * @param idUserStory identifiant de la user story
     * @return Liste de task
     */
    @GetMapping("/{idProject}/user_stories/{idUserStory}/tasks")
    public List<Object> allUserStoryTasks(@PathVariable long idProject, @PathVariable long idUserStory){

        // TODO : Créer une fonction retournant la liste des taches d'une user story

        return new ArrayList<>();
    }

    /** Fonction retournant la liste des utilisateurs participant à un projet
     *
     * @param idProject identifiant de l'utilisateur
     * @return Liste de userDto
     */
    @GetMapping("/{idProject}/users")
    public List<UserDto> allProjectUsers(@PathVariable long idProject){

        // TODO : Créer une fonction retournant la liste des utilisateur d'un projet

        return new ArrayList<>();
    }

    /** Fonction retournant la liste des user stories d'un projet
     *
     * @param idProject identifiant d'un projet
     * @return Liste de userStory
     */
    @GetMapping("/{idProject}/user_stories")
    public List<Object> allProjectUserStories(@PathVariable long idProject){

        // TODO : Créer une fonction retournant la liste des user stories

        return new ArrayList<>();
    }

    /** Fonction retournant la liste des sprints d'un projet
     *
     * @param idProject identifiant d'un projet
     * @return Liste de sprint
     */
    @GetMapping("/{idProject}/sprints")
    public List<Object> allProjectSprints(@PathVariable long idProject){

        // TODO :  Créer une fonction retournant la liste des sprint d'un projet

        return new ArrayList<>();
    }

    /** Fonction retournant la liste des backlogs d'un sprint
     *
     * @param idProject identifiant d'un projet
     * @param idSprint identifiant d'un sprint
     * @return liste de backlog
     */
    @GetMapping("/{idProject}/sprints/{idSprint}/backlogs")
    public List<Object> allSprintBacklogs(@PathVariable long idProject, @PathVariable long idSprint){

        // TODO : Créer une fonction retournant la liste des backlogs d'un sprint

        return new ArrayList<>();
    }

    /** Fonction retournant un backlogs d'un sprint
     *
     * @param idProject identifiant du projet
     * @param idSprint identifiant du sprint
     * @param idBacklog identifiant du backlog
     * @return backlog
     */
    @GetMapping("/{idProject}/sprint/{idSprint}/backlog/{idBackLog}")
    public Object findSprintBacklogByID(
            @PathVariable long idProject, @PathVariable long idSprint, @PathVariable long idBacklog){

        // TODO : Créer une fonction retournant un backlog d'un sprint

        return new Object();
    }

}
