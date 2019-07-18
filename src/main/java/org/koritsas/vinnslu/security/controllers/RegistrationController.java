package org.koritsas.vinnslu.security.controllers;

import org.koritsas.vinnslu.security.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto dto){

        return ResponseEntity.ok("Registered user " + dto.toString());
    }

}
