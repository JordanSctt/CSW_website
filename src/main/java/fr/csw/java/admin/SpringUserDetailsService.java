package fr.csw.java.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpringUserDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Admin> optionalAdmin = adminRepository.findByLogin(login);

        if (optionalAdmin.isPresent()) {
            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(optionalAdmin.get().getRole()));
            return new User(optionalAdmin.get().getLogin(), optionalAdmin.get().getPassword(),
                    true, true, true, true, roles);
        }
        throw new UsernameNotFoundException("login " + login + " not found");
    }

}
