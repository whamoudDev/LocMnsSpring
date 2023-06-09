package com.dw.locmns.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@EnableWebSecurity
public class ConfigurationSecurite extends WebSecurityConfigurerAdapter {



    @Autowired
    private DataSource dataSource;

    @Autowired
    private MyUserDetailsServiceLocMns myUserDetailsServiceLocMns;


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private JwtFilter jwtFilter;


    @Override //Configuration de l'authentification
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsServiceLocMns).passwordEncoder(getPasswordEncoder());


    }
    @Override //Gestion de l'authorisation
    protected void configure(HttpSecurity http) throws Exception {


        http
                .cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/type-utilisateurs", "/connexion", "/liste-localisations", "/liste-locations","/liste-locations/{idLocation}", "/liste-typeLocations","/liste-cadres-utilisation","/liste-reservations","/liste-reservations/{idReservation}","/dashboardgestionnaire").permitAll()
                .antMatchers("/**").hasAnyRole("UTILISATEUR", "GESTIONNAIRE", "SUPERADMIN")

                .and().exceptionHandling()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);


    }

    @Bean
    public CorsConfigurationSource configurationCrossOrigin() {
        //Configurer les méthodes autorisés
        CorsConfiguration maConfiguration = new CorsConfiguration();

        maConfiguration.setAllowedOrigins(List.of("*"));
        maConfiguration.setAllowedMethods(List.of("GET", "POST", "DELETE", "PUT"));
        maConfiguration.setAllowedHeaders(List.of("X-Requested-With", "Origin", "Content-Type",
                "Accept", "Authorization","Access-Control-Allow-Origin"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", maConfiguration);
        return source;
    }



    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManager();
    }




}