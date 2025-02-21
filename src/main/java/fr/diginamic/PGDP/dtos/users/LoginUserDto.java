package fr.diginamic.PGDP.dtos.users;

import fr.diginamic.PGDP.dtos.LoginDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Setter;

/** Classe permettant de récupérer les données de connexion */
@Setter
@AllArgsConstructor
public class LoginUserDto implements LoginDto {
    /** Variable contenant l'email */
    @Email(message = "L'email doit être valide.")
    @NotBlank(message = "L'email est obligatoire.")
    private String email;

    /** Variable contenant le mot de passe */
    @NotBlank(message = "Le mot de passe est obligatoire.")
    private String password;

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
        return "LoginUserDto{" + "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
