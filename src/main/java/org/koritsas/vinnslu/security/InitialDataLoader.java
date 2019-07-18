package org.koritsas.vinnslu.security;

import org.koritsas.vinnslu.security.models.Privilege;
import org.koritsas.vinnslu.security.models.Role;
import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.koritsas.vinnslu.security.repos.PrivilegeRepository;
import org.koritsas.vinnslu.security.repos.RoleRepository;
import org.koritsas.vinnslu.security.repos.VinnsluUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {


    private boolean alreadySetup=false;

    private VinnsluUserRepository vinnsluUserRepository;

    private RoleRepository roleRepository;

    private PrivilegeRepository privilegeRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public InitialDataLoader(VinnsluUserRepository vinnsluUserRepository, RoleRepository roleRepository, PrivilegeRepository privilegeRepository, PasswordEncoder passwordEncoder){
        this.vinnsluUserRepository = vinnsluUserRepository;
        this.roleRepository=roleRepository;
        this.privilegeRepository=privilegeRepository;
        this.passwordEncoder=passwordEncoder;

    }



    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(alreadySetup) return;

        Privilege readPrivilege =createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege,writePrivilege);

        createRoleIfNotFound("ROLE_ADMIN",adminPrivileges);

        createRoleIfNotFound("ROLE_USER",Arrays.asList(readPrivilege));

        Role adminRole = roleRepository.findByName("ROLE_ADMIN");

        VinnsluUser admin = new VinnsluUser();
        admin.setEmail("admin@vinnslu.gr");
        admin.setEnabled(true);
        admin.setFirstName("Ilias");
        admin.setLastName("Koritsas");
        admin.setPassword(passwordEncoder.encode("ilkor@4664"));
        admin.setRoles(Arrays.asList(adminRole));

        vinnsluUserRepository.save(admin);

        alreadySetup=true;
    }

    @Transactional
    private Privilege createPrivilegeIfNotFound(String name){

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege==null){
            privilege=new Privilege(name);
            privilegeRepository.save(privilege);
        }

        return privilege;
    }

    @Transactional
    public Role createRoleIfNotFound(String name,List<Privilege> privileges){

        Role role = roleRepository.findByName(name);
        if (role==null){

            role=new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
