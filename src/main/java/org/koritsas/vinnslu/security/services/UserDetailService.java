package org.koritsas.vinnslu.security.services;

import org.koritsas.vinnslu.security.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {

    private UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);


    }

}
