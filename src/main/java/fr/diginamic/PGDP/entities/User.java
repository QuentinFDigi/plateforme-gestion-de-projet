package fr.diginamic.PGDP.entities;

import jakarta.persistence.*;

import java.util.Objects;

/** Classe gérant un utilisateur */
@Entity
@Table(name = "user")
public class User {

    /** ID auto-générer en base de données */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;

    /** Variable contenant le nom d'un utilisateur */
    @Column(nullable = false)
    private String lastName;

    /** Variable contenant le prénom d'un utilisateur */
    @Column(nullable = false)
    private String firstName;

    /** Variable contenant le pseudonyme d'un utilisateur */
    @Column
    private String pseudo;

    /** Variable contenant l'email d'un utilisateur*/
    @Column(nullable = false)
    private String email;

    /** Variable conteant le mot de passe d'un utilisateur */
    @Column(nullable = false)
    private String password;

    /** Variable indiquant si l'utilisateur a vérifier son email */
    @Column
    private boolean emailConfirmed;

    /** Constructeur vide pour JPA */
    public User() {
    }

    /** Constructeur de la classe "User"
     *
     * @param lastName
     * @param firstName
     * @param pseudo
     * @param email
     * @param password
     */
    public User(String lastName, String firstName, String pseudo, String email, String password) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.emailConfirmed = false;
    }

    /** Getter
     *
     * @return id
     */
    public long getId() {
        return id;
    }

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
     * @param email email de l'utilisateur
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

    /** Getter
     *
     * @return emailConfirmed
     */
    public boolean isEmailConfirmed() {
        return emailConfirmed;
    }

    /** Setter
     *
     * @param emailConfirmed booléen indiquant si le mail de l'utilisateur est vérifier ou non
     */
    public void setEmailConfirmed(boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName) && Objects.equals(pseudo, user.pseudo) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(emailConfirmed, user.emailConfirmed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, pseudo, email, password, emailConfirmed);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", emailConfirmed=" + emailConfirmed +
                '}';
    }
}
