package org.koritsas.vinnslu.main.configuration;


import org.koritsas.vinnslu.security.services.VinnsluUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private VinnsluUserDetailService service;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(this.service);


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
   /*     http
                .csrf().disable().userDetailsService(service)
                .exceptionHandling()
                .and()

                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/vinnslu/workflow/process/**").authenticated()
                .antMatchers("/vinnslu/workflow/process/**").hasAnyRole("ADMIN", "TOPO_ADMIN")
                .antMatchers("/vinnslu/data/**").authenticated()
                .antMatchers("/vinnslu/data/**").hasAnyRole("ADMIN", "TOPO_ADMIN")
                .antMatchers("/vinnslu/assets/**").authenticated()
                .antMatchers("/vinnslu/assets/**").hasRole("ASSETS_ADMIN")
                .and()
                .formLogin()
                .and()


                .logout();
*/
        http
                .csrf().disable().userDetailsService(service)
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/workflow/process/**").authenticated()
                .antMatchers("/workflow/process/**").hasAnyRole("ADMIN", "TOPO_ADMIN")
                .antMatchers("/data/**").hasAnyRole("ADMIN", "TOPO_ADMIN")
                .antMatchers("/assets/**").authenticated()
                .antMatchers("/assets/**").hasRole("ASSETS_ADMIN")
                .and()
                .formLogin().defaultSuccessUrl("/data/topo")
                .and()

                .logout();

    }
}
