package org.koritsas.vinnslu.security;

import org.koritsas.vinnslu.main.utils.GeometryModelMapper;
import org.koritsas.vinnslu.security.dtos.VinnsluUserDto;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.security.services.VinnsluUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//@RequestMapping("/login")
public class LoginController {

    private VinnsluUserDetailService service;

    @Autowired
    public LoginController(VinnsluUserDetailService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<String> loginUser(@RequestBody VinnsluUserDto dto){

        VinnsluUser user= new VinnsluUser();
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getLastName());
        user.setPassword(dto.getPassword());

        service.loadUserByUsername(dto.getEmail());

        return ResponseEntity.ok("User authorized");

    }
}
