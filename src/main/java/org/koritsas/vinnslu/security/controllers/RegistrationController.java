package org.koritsas.vinnslu.security.controllers;

import org.koritsas.vinnslu.security.dtos.VinnsluUserDto;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService=userService;
        this.passwordEncoder=passwordEncoder;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody VinnsluUserDto dto){

        VinnsluUser user = new VinnsluUser();

        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());

        userService.registerNewUserAccount(user);

        return ResponseEntity.ok("Registered user");
    }

}
