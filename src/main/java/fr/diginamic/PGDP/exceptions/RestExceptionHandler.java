package fr.diginamic.PGDP.exceptions;

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
}
