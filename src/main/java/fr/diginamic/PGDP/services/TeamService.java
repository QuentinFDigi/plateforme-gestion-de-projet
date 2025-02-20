package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.dtos.TeamDTO;
import fr.diginamic.PGDP.entities.Team;
import fr.diginamic.PGDP.exceptions.teams.DuplicateTeamException;
import fr.diginamic.PGDP.exceptions.teams.InvalidTeamDataException;
import fr.diginamic.PGDP.exceptions.teams.TeamNotFoundException;
import fr.diginamic.PGDP.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service pour gérer la logique métier des équipes.
 * Fournit des méthodes pour récupérer, créer et supprimer des équipes.
 *
 * @author Romain Wyon
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    /**
     * Récupère toutes les équipes sous forme de DTO.
     *
     * @return Liste des équipes
     */
    public List<TeamDTO> getAllTeams() {
        return teamRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Recherche une équipe par son identifiant.
     *
     * @param id Identifiant de l'équipe
     * @return Un DTO de l'équipe
     * @throws TeamNotFoundException si l'équipe n'existe pas
     */
    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException("L'équipe avec l'ID " + id + " n'existe pas."));
        return convertToDTO(team);
    }

    /**
     * Crée une nouvelle équipe.
     *
     * @param teamDTO DTO contenant les informations de l'équipe
     * @return L'équipe créée sous forme de DTO
     * @throws DuplicateTeamException si une équipe avec le même nom existe déjà
     * @throws InvalidTeamDataException si les données de l'équipe sont invalides
     */
    public TeamDTO createTeam(TeamDTO teamDTO) {
        if (teamDTO.getName() == null || teamDTO.getName().trim().isEmpty()) {
            throw new InvalidTeamDataException("Le nom de l'équipe ne peut pas être vide.");
        }

        if (teamRepository.findByName(teamDTO.getName()).isPresent()) {
            throw new DuplicateTeamException("Une équipe avec le nom '" + teamDTO.getName() + "' existe déjà.");
        }

        Team team = new Team(teamDTO.getName(), teamDTO.getContacts(), teamDTO.getDescription());
        return convertToDTO(teamRepository.save(team));
    }

    /**
     * Supprime une équipe par son identifiant.
     *
     * @param id Identifiant de l'équipe
     * @throws TeamNotFoundException si l'équipe n'existe pas
     */
    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new TeamNotFoundException("Impossible de supprimer, l'équipe avec l'ID " + id + " n'existe pas.");
        }
        teamRepository.deleteById(id);
    }

    /**
     * Convertit une entité Team en DTO.
     *
     * @param team Entité Team
     * @return DTO correspondant
     */
    private TeamDTO convertToDTO(Team team) {
        return new TeamDTO(team.getId(), team.getName(), team.getContacts(), team.getDescription());
    }
}
