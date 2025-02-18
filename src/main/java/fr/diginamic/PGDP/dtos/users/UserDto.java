package fr.diginamic.PGDP.dtos.users;

/** Classe contenant la structure d'affichage d'un utilisateur */
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

    /** Getter
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /** Setter
     *
     * @param id identifiant de l'utilisateur
     */
    public void setId(long id) {
        this.id = id;
    }

    /** Getter
     *
     * @return fullName
     */
    public String getFullName() {
        return fullName;
    }

    /** Setter
     *
     * @param fullName prénom et nom de l'utilisateur
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /** Getter
     *
     * @return pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /** Setter
     *
     * @param pseudo pseudonyme de l'utilisateur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /** Getter
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /** Setter
     *
     * @param email email de l'utilisateur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Getter
     *
     * @return emailConfirmed
     */
    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    /** Setter
     *
     * @param emailConfirmed booléen indiquant si le mail de l'utilisateur est confirmé
     */
    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

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
