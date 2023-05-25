package com.dw.locmns.controller;

import com.dw.locmns.dao.TypeUtilisateurDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.TypeUtilisateur;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class TypeUtilisateurController {



    @Autowired
    private TypeUtilisateurDao typeUtilisateurDao;

    @Autowired
    private UtilisateurDao utilisateurDao;


    @Autowired
    public TypeUtilisateurController(TypeUtilisateurDao typeUtilisateurDao) {
        this.typeUtilisateurDao = typeUtilisateurDao;
    }



    @GetMapping("/type-utilisateurs")
    @JsonView(vueUtilisateur.class)
    public List<TypeUtilisateur> getTypeUtilisateurs(){return this.typeUtilisateurDao.findAll();
    }

    @GetMapping("/type-utilisateurs/{id}")
    public TypeUtilisateur typeUtilisateur(@PathVariable Integer id){
        return this.typeUtilisateurDao.findById(id).orElse(null);
    }



}
