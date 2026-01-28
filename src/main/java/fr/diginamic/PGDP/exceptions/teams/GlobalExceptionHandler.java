package fr.diginamic.PGDP.exceptions.teams;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Gestionnaire global des exceptions pour capturer et renvoyer des réponses HTTP adaptées.
 *
 * @author Romain Wyon
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gère l'exception TeamNotFoundException.
     *
     * @param ex Exception levée
     * @return Réponse avec le message d'erreur et un statut 404 NOT FOUND
     */
    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<String> handleTeamNotFoundException(TeamNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    /**
     * Gère l'exception DuplicateTeamException.
     *
     * @param ex Exception levée
     * @return Réponse avec le message d'erreur et un statut 409 CONFLICT
     */
    @ExceptionHandler(DuplicateTeamException.class)
    public ResponseEntity<String> handleDuplicateTeamException(DuplicateTeamException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    /**
     * Gère l'exception InvalidTeamDataException.
     *
     * @param ex Exception levée
     * @return Réponse avec le message d'erreur et un statut 400 BAD REQUEST
     */
    @ExceptionHandler(InvalidTeamDataException.class)
    public ResponseEntity<String> handleInvalidTeamDataException(InvalidTeamDataException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    /**
     * Gère toute autre exception non prévue.
     *
     * @param ex Exception levée
     * @return Réponse avec un message générique et un statut 500 INTERNAL SERVER ERROR
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur interne est survenue.");
    }
}
