package fr.diginamic.PGDP.dtos.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/** Classe contenant la structure d'affichage d'un utilisateur */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    /** Variable conteant l'id de l'utilisateur */
    private long id;

    /** Variable contenant le prénom et le nom de l'utilisateur */
    private String fullName;

    /** Variable contenant le pseudo de l'utilisateur */
    private String pseudo;

    /** Variable contenant l'email de l'utilisateur */
    private String email;

    /** Variable indiquant si l'utilisateur à vérifier son adresse mail */
    private boolean emailConfirmed;

    @Override
    public String toString() {
        return "UserDto{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", emailConfirmed=" + emailConfirmed +
                '}';
    }
}
