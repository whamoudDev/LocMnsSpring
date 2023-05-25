package com.dw.locmns.controller;

import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.security.SecureRandom;


import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UtilisateurController {

    @Autowired
    private UtilisateurDao utilisateurDao;
    @Autowired
    private PasswordEncoder encoder;


@Autowired
public UtilisateurController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }



    @GetMapping("/liste-utilisateurs")
    @JsonView(vueUtilisateur.class)
    public List<Utilisateur> listeUtilisateurs(){
        return this.utilisateurDao.findAll();
    }



    @GetMapping("/utilisateur/{id}")
    @JsonView(vueUtilisateur.class)
    public Utilisateur utilisateur(@PathVariable Integer id){
    return this.utilisateurDao.findById(id).orElse(null);

        }

    @PostMapping("/ajoutEditionUtilisateur")
    @JsonView(vueUtilisateur.class)
    public String ajoutEditionUtilisateur(@RequestPart("utilisateur") Utilisateur utilisateur) throws Exception {

        if(utilisateur.getTypeUtilisateur().getRoleUtilisateur().equals("ROLE_SUPERADMIN")){
            utilisateur.setMotDePasseUtilisateur(encoder.encode(utilisateur.getMotDePasseUtilisateur()));
        }

        utilisateurDao.save(utilisateur);
        return "mail a envoyé";
    }







    }
















