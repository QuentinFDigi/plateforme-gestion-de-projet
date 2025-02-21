package fr.diginamic.PGDP.dtos.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Classe gérnant la structure de la modification d'un utilisateur */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateDto {

    /** Variable contenant le nom à modifier d'un utilisateur */
    @NotBlank(message = "Le nom est obligatoire.")
    private String lastName;

    /** Variable contenant le prénom à modifier d'un utilisateur */
    @NotBlank(message = "Le prénom est obligatoire.")
    private String firstName;

    /** Variable contenant le pseudo à modifier d'un utilisateur */
    @NotBlank(message = "Le pseudo est obligatoire.")
    private String pseudo;

    /** Variable contenant le mail à modifier d'un utilisateur */
    @Email(message = "L'email doit être valide.")
    @NotBlank(message = "L'email est obligatoire.")
    private String email;

    /** Variable contenant le mot de passe à modifier d'un utilisateur */
    @NotBlank(message = "Le mot de passe est obligatoire.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}",
            message = "Le mot de passe doit contenir, au moins un chiffre, au moins une lettre minuscule," +
                    " au moins une lettre majuscule, au moins un caractère spécial, ne doit pas contenir d'espace" +
                    " et faire au moins 8 caractères.")
    private String password;

    @Override
    public String toString() {
        return "UserUpdateDto{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
