package fr.diginamic.PGDP.dtos.users;

import fr.diginamic.PGDP.dtos.RegisterDto;
import fr.diginamic.PGDP.transformers.UserTransformer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterUserDto implements RegisterDto {

    /** Variable contenant le nom de famille */
    @NotBlank(message = "Le nom est obligatoire.")
    private String lastName;

    /** Variable contenant le prénom */
    @NotBlank(message = "Le prénom est obligatoire.")
    private String firstName;

    /** Variable conteant le pseudo */
    @NotBlank(message = "Le pseudo est obligatoire.")
    private String pseudo;

    /** Variable contenant l'email */
    @Email(message = "Veuillez entrer un email valide.")
    @NotBlank(message = "L'email est obligatoire.")
    private String email;

    /** Variable contenant le mot de passe */
    @NotBlank(message = "Le mot de passe est obligatoire.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
                message = "Le mot de passe doit contenir, au moins un chiffre, au moins une lettre minuscule," +
                        " au moins une lettre majuscule, au moins un caractère spécial, ne doit pas contenir d'espace" +
                        " et faire au moins 8 caractères.")
    private String password;

    /** Variable contenant le booleen indiquant si l'email à été confirmer */
    private boolean emailConfirmed;

    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getPseudo() {
        return this.pseudo;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" + "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", emailConfirmed=" + emailConfirmed +
                '}';
    }

    @Override
    public RegisterDto setLastName(String lastName) {
        return null;
    }

    @Override
    public RegisterDto setFirstName(String firstName) {
        return null;
    }

    @Override
    public RegisterDto setPseudo(String pseudo) {
        return null;
    }

    @Override
    public RegisterDto setEmail(String email) {
        return null;
    }

    @Override
    public RegisterDto setPassword(String password) {
        return null;
    }
}
