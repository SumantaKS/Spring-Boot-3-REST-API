package com.sumanta.springboot.restcrud.security;



import com.sumanta.springboot.restcrud.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(UserService userService){

        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();

        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(bCryptPasswordEncoder());

        return auth;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configure ->
                configure
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        //for HTTP Basic authorisation
        http.httpBasic(Customizer.withDefaults());

        //CSRF is not required for stateless REST APIs that use POST, PUT, DELETE, PATCh
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
