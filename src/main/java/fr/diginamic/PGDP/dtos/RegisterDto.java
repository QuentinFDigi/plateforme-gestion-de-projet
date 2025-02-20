package fr.diginamic.PGDP.dtos;

public interface RegisterDto {
    String getLastName();

    RegisterDto setLastName(String lastName);

    String getFirstName();

    RegisterDto setFirstName(String firstName);

    String getPseudo();

    RegisterDto setPseudo(String pseudo);

    String getEmail();

    RegisterDto setEmail(String email);

    String getPassword();

    RegisterDto setPassword(String password);

    String toString();
}
