package fr.diginamic.PGDP.dtos.users;

/** Classe gérnant la structure de la modification d'un utilisateur */
public class UserUpdateDto {

    /** Variable contenant le nom à modifier d'un utilisateur */
    private String lastName;

    /** Variable contenant le prénom à modifier d'un utilisateur */
    private String firstName;

    /** Variable contenant le pseudo à modifier d'un utilisateur */
    private String pseudo;

    /** Variable contenant le mail à modifier d'un utilisateur */
    private String email;

    /** Variable contenant le mot de passe à modifier d'un utilisateur */
    private String password;

    /** Getter
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /** Setter
     *
     * @param lastName nom de l'utilisateur
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /** Getter
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /** Setter
     *
     * @param firstName prénom de l'utilisateur
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
     * @param email email de l'uitilisateur
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Getter
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /** Setter
     *
     * @param password mot de passe de l'utilisateur
     */
    public void setPassword(String password) {
        this.password = password;
    }

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
