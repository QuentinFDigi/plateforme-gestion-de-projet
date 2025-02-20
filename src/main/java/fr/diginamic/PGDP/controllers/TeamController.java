package fr.diginamic.PGDP.controllers;

import fr.diginamic.PGDP.dtos.TeamDTO;
import fr.diginamic.PGDP.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Contrôleur REST pour gérer les opérations sur les équipes.
 * Expose des endpoints pour récupérer, créer et supprimer des équipes.
 *
 * @author Romain Wyon
 */
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    /**
     * Récupère toutes les équipes.
     *
     * @return Liste des équipes
     */
    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    /**
     * Récupère une équipe par son identifiant.
     *
     * @param id Identifiant de l'équipe
     * @return L'équipe correspondante ou une réponse 404 si elle n'existe pas
     */
    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> getTeamById(@PathVariable Long id) {
        Optional<TeamDTO> team = teamService.getTeamById(id);
        return team.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Crée une nouvelle équipe.
     *
     * @param teamDTO Données de l'équipe
     * @return L'équipe créée
     */
    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody TeamDTO teamDTO) {
        return ResponseEntity.ok(teamService.createTeam(teamDTO));
    }

    /**
     * Supprime une équipe par son identifiant.
     *
     * @param id Identifiant de l'équipe à supprimer
     * @return Réponse 204 No Content si la suppression a réussi
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
