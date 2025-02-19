package fr.diginamic.PGDP.dtos.users;

import fr.diginamic.PGDP.dtos.LoginDto;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
public class LoginUserDto implements LoginDto {
    private String email;
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
