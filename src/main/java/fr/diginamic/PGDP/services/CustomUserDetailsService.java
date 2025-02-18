package fr.diginamic.PGDP.services;

import fr.diginamic.PGDP.repositories.AdminRepository;
import fr.diginamic.PGDP.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final AdminRepository adminRepository;

    public CustomUserDetailsService(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByPseudo(username)
                .orElseGet(() -> adminRepository.findByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}
