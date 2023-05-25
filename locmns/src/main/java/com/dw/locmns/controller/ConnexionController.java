package com.dw.locmns.controller;

import com.dw.locmns.dao.UtilisateurDao;
//import com.dw.locmns.security.JwtUtils;

import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.security.JwtUtils;
import com.dw.locmns.security.MyUserDetails;
import com.dw.locmns.security.MyUserDetailsServiceLocMns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.management.remote.JMXAuthenticator;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class ConnexionController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UtilisateurDao utilisateurDao;
    @Autowired
    private MyUserDetailsServiceLocMns myUserDetailsServiceLocMns;

    @PostMapping("/connexion")// renvoyer un token si l'utilisateur existe dans la BDD
    public ResponseEntity<String> connexion(@RequestBody Utilisateur utilisateur) {

        MyUserDetails userDetails;

        try {

            userDetails=(MyUserDetails)   authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            utilisateur.getMailUtilisateur(),
                            utilisateur.getMotDePasseUtilisateur()

                    )).getPrincipal();
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);

        }
        return new ResponseEntity<>( jwtUtils.generateToken(userDetails), HttpStatus.OK);

    }


}










