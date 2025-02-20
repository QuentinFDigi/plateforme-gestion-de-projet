package fr.diginamic.PGDP.entities;

import fr.diginamic.PGDP.Roles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/** Classe gérant un utilisateur */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    /** ID auto-générer en base de données */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
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

    /** Variable contenant les différentes collaboration de l'utilsiateur */
    @OneToMany(mappedBy = "collaboration")
    private List<Collaboration> collaborations;

    /** Variable contenant la liste des projets créer par l'utilisateur */
    @OneToMany(mappedBy = "project")
    private List<Project> projectsCreated;

    /** Fonction ajouter un nouveau projet créer par l'utilsiateur courant
     *
     * @param project donnée du projet créer
     */
    public void createProject(Project project){
        projectsCreated.add(project);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(Roles.USER::name);
    }
    @Override
    public String getUsername() {
        return this.email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }
    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(pseudo, user.pseudo)
                && Objects.equals(email, user.email)
                && Objects.equals(password, user.password)
                && Objects.equals(emailConfirmed, user.emailConfirmed);
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
