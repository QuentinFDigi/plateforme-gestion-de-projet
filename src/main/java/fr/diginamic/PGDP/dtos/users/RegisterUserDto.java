package fr.diginamic.PGDP.dtos.users;

import fr.diginamic.PGDP.dtos.RegisterDto;
import fr.diginamic.PGDP.transformers.UserTransformer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterUserDto implements RegisterDto {
    private final UserTransformer userTransformer;
    private String lastName;
    private String firstName;
    private String pseudo;
    private String email;
    private String password;
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

    public boolean getEmailConfirmed() {
        return this.emailConfirmed;
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
