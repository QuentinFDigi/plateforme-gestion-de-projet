package fr.diginamic.PGDP.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
public class Admin implements UserDetails {

    /** ID auto-générer en base de données */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** variable contenant le nom de l'admin */
    private String username;
    /** variable contenant l'email de l'admin */
    private String email;
    /** variable contenant le mot de passe de l'admin */
    private String password;

    public Admin() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(Roles.ADMIN::name);
    }

    @Override
    public String getUsername() {
        return this.username;
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
}
