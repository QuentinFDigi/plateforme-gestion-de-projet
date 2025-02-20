package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.entities.Collaboration;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.entities.ProjectRole;
import fr.diginamic.PGDP.entities.User;
import fr.diginamic.PGDP.exceptions.collaborations.UserCantAccessToProjectException;
import fr.diginamic.PGDP.exceptions.collaborations.UserCantUpdateProjectException;
import fr.diginamic.PGDP.exceptions.projects.InvalidEndDateException;
import fr.diginamic.PGDP.exceptions.projects.InvalidNameException;
import fr.diginamic.PGDP.exceptions.projects.ProjectNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

/** Classe contenant les diverses vérifications métier d'un projet */
@Service
public class ProjectService {

    /** Fonction permettant la vérification des informations données pour la création ou la modification d'un projet
     *
     * @param projectAddOrModifyDto variabgle contenant les informations à vérifier
     */
    public void verify(ProjectAddOrModifyDto projectAddOrModifyDto) {
        if (Objects.equals(projectAddOrModifyDto.getName(), "")){
            throw new InvalidNameException();
        }else if (projectAddOrModifyDto.getEndDate().isBefore(LocalDate.now()) && projectAddOrModifyDto.getEndDate() != null){
            throw new InvalidEndDateException();
        }
    }

    /** Fonction permettant de vérifier si l'utilisateur a les droits de modification
     *
     * @param collaboration variable contenant les données d'une collaboration
     */
    public void verifyUserPerm(Collaboration collaboration) {
        if(collaboration.getProjectRole() == ProjectRole.VISITOR){
            throw new UserCantUpdateProjectException();
        }
    }
}
