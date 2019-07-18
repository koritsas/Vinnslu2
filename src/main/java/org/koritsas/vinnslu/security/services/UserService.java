package org.koritsas.vinnslu.security.services;

import org.koritsas.vinnslu.main.exceptions.UserExistsException;
import org.koritsas.vinnslu.security.models.User;
import org.koritsas.vinnslu.security.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository repository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder){
        this.repository=repository;
    }

    public User registerNewUserAccount(User user){

        if (repository.findByEmail(user.getEmail())!=null){
             throw new UserExistsException(user);
        }

        User newUser= new User();

        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));


        return repository.save(newUser);
    }
}
