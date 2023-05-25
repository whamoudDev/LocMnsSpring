package com.dw.locmns.controller;

import com.dw.locmns.dao.LocalisationDao;
import com.dw.locmns.dao.LocationDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Localisation;
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
public class LocalisationController {


    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    public LocalisationController(LocalisationDao localisationDao) {
        this.localisationDao = localisationDao;
    }

    private LocalisationDao localisationDao;


    @GetMapping("/liste-localisations")
    @JsonView(vueUtilisateur.class)
    public List<Localisation> getListeLocalisation(){
        return localisationDao.findAll();
    }


    @GetMapping ("/gestionnaire/localisation/{id}")
    public Localisation localisation(@PathVariable Integer id){
        return this.localisationDao.findById(id).orElse(null);
    }




}
