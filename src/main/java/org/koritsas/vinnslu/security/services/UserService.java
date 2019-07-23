package org.koritsas.vinnslu.security.services;

import org.koritsas.vinnslu.main.exceptions.UserExistsException;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.security.repos.VinnsluUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private VinnsluUserRepository repository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(VinnsluUserRepository repository, PasswordEncoder passwordEncoder){
        this.repository=repository;
        this.passwordEncoder=passwordEncoder;
    }

    public VinnsluUser registerNewUserAccount(VinnsluUser vinnsluUser){



        if (repository.findByEmail(vinnsluUser.getEmail())!=null){
             throw new UserExistsException(vinnsluUser);
        }



        VinnsluUser newVinnsluUser = new VinnsluUser();

        newVinnsluUser.setFirstName(vinnsluUser.getFirstName());
        newVinnsluUser.setLastName(vinnsluUser.getLastName());
        newVinnsluUser.setEmail(vinnsluUser.getEmail());
        newVinnsluUser.setPassword(passwordEncoder.encode(vinnsluUser.getPassword()));


        return repository.save(newVinnsluUser);
    }
}
