package fr.diginamic.PGDP.exceptions;

import fr.diginamic.PGDP.exceptions.collaborations.CollaborationNotFoundException;
import fr.diginamic.PGDP.exceptions.collaborations.UserCantAccessToProjectException;
import fr.diginamic.PGDP.exceptions.collaborations.UserCantUpdateProjectException;
import fr.diginamic.PGDP.exceptions.projects.InvalidEndDateException;
import fr.diginamic.PGDP.exceptions.projects.InvalidNameException;
import fr.diginamic.PGDP.exceptions.projects.ProjectNotFoundException;
import fr.diginamic.PGDP.exceptions.users.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Classe regroupant toutes les exceptions personnalisées */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /** Users exceptions */

    /** Fonction retournant une exception si l'utilisateur n'est pas trouvé.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ UserNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundUser(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Utilisateur non trouvé.", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /** Fonction retournant une exception si le nom renseigné est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidLastNameException.class })
    protected ResponseEntity<Object> handleInvalidLastName(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez renseigner votre nom.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Fonction retournant une exception si le prénom renseigné est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidFirstNameException.class })
    protected ResponseEntity<Object> handleInvalidFirstName(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez renseigner votre prénom.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Fonction retournant une exception si le pseudo renseigné est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidPseudoException.class })
    protected ResponseEntity<Object> handleInvalidPseudo (Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez renseigner un pseudonyme.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Fonction retournant une exception si l'email renseigné est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidEmailException.class })
    protected ResponseEntity<Object> handleInvalidEmail(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez renseigner votre email.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Fonction retournant une exception si le mot de passe renseigné est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidPasswordException.class })
    protected ResponseEntity<Object> handleInvalidPassword (Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez entrer un mot de passe valide.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Project exceptions */

    /** Fonction retournant une exception si le projet n'est pas trouvé.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ ProjectNotFoundException.class })
    protected ResponseEntity<Object> handleNotFoundProject(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Projet non trouvé.", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    /** Fonction retournant une exception si le nom du projet est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({InvalidNameException.class })
    protected ResponseEntity<Object> handleInvalidProjectName(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Veuillez renseigner le nom du projet.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Fonction retournant une exception si la date de fin du projet est invalide.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ InvalidEndDateException.class })
    protected ResponseEntity<Object> handleInvalidProjectEndDate(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Date de fin non valide. La date doit être supérieure à la date d'aujourd'hui.", new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    /** Collaborations Exception */

    /** Fonction retournant une exception si l'utilisateur essaye de modifier un projet sans les droit de le faire.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ CollaborationNotFoundException.class })
    protected  ResponseEntity<Object> handleCollaborationNotFound(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Aucun lien n'a été trouvé entre le projet et l'utilisateur.", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    /** Fonction retournant une exception si l'utilisateur essaye d'accéder à un projet dans le quel il n'est pas collaborateur.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ UserCantAccessToProjectException.class })
    protected  ResponseEntity<Object> handleUserCantAccessToProject(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Vous n'avez pas accés à ce projet.", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }

    /** Fonction retournant une exception si l'utilisateur essaye de modifier un projet sans les droit de le faire.
     *
     * @param ex Variable contenant l'exception
     * @param request Variable contenant la requête http
     * @return ResponseEntity<Object>
     */
    @ExceptionHandler({ UserCantUpdateProjectException.class })
    protected  ResponseEntity<Object> handleUserCantUpdateProject(Exception ex, WebRequest request){
        return handleExceptionInternal(ex, "Vous n'avez pas les droit nécessaire pour modifier le projet.", new HttpHeaders(), HttpStatus.FORBIDDEN, request);
    }
}
