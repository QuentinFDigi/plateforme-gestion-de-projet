package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.projects.ProjectAddOrModifyDto;
import fr.diginamic.PGDP.exceptions.projects.InvalidEndDateException;
import fr.diginamic.PGDP.exceptions.projects.InvalidNameException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

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
}
