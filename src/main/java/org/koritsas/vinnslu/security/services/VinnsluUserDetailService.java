package org.koritsas.vinnslu.security.services;

import org.koritsas.vinnslu.security.VinnsluUserDetails;
import org.koritsas.vinnslu.security.models.Role;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.security.repos.VinnsluUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VinnsluUserDetailService implements UserDetailsService {

    private VinnsluUserRepository vinnsluUserRepository;

    @Autowired
    public VinnsluUserDetailService(VinnsluUserRepository vinnsluUserRepository){
        this.vinnsluUserRepository = vinnsluUserRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        VinnsluUser user = vinnsluUserRepository.findByEmail(email);

        if (user == null){
            throw new UsernameNotFoundException("No user found with email " + email);
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        for (Role role : user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new VinnsluUserDetails(user);
    }
}
