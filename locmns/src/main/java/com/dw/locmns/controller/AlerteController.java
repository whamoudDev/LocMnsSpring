package com.dw.locmns.controller;


import com.dw.locmns.dao.AlerteDao;
import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueAlerte;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin
@RestController
public class AlerteController {
    @Autowired
    private  AlerteDao alerteDao;

    @Autowired
    public AlerteController(AlerteDao alerteDao) {
        this.alerteDao = alerteDao;
    }


    @JsonView(vueAlerte.class)
    @GetMapping("/alertes")
    public List<Alerte> listeAlertes(){
        return this.alerteDao.findAll();
    }















}
