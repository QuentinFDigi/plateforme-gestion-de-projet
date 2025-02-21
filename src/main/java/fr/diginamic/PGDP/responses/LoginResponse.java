package fr.diginamic.PGDP.responses;

import lombok.Getter;
import lombok.Setter;

/** Classe contenant la structure d'une réponse lors de la connexion d'un utilisateur */
@Getter
@Setter
public class LoginResponse {

    /** Variable contenant le token pour l'utilisateur */
    private String token;

    /** Variable contenant le temps d'expirassion en millisecondes */
    private long expiresIn;

    /** Setter
     *
     * @param token variable contenant le token pour l'utilisateur
     * @return
     */
    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    /** Setter
     *
     * @param expiresIn variable contenant le temps d'expirassion en millisecondes
     * @return loginResponse
     */
    public LoginResponse setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "token='" + token + '\'' +
                ", expiresIn=" + expiresIn +
                '}';
    }
}
