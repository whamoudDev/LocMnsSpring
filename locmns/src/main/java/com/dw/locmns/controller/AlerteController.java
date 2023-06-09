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


    @JsonView(vueAlerte.class)
    @GetMapping("/alertesNonTraite")
    public List<Alerte> listeAlertesNonTraite(){
        return this.alerteDao.findAlertesNonTraite();
    }


    @JsonView(vueAlerte.class)
    @GetMapping("/alertesReservationNonTraite")
    public List<Alerte> listeAlertesReservationNonTraite(){
        return this.alerteDao.findAlertesReservationNonTraite();
    }


    @JsonView(vueAlerte.class)
    @GetMapping("/alertesReparationNonTraite")
    public List<Alerte> listeAlertesReparationNonTraite(){
        return this.alerteDao.findAlertesReparationNonTraite();
    }

    @JsonView(vueAlerte.class)
    @GetMapping("/alertesSignalementNonTraite")
    public List<Alerte> listeAlertesSignalementNonTraite(){
        return this.alerteDao.findAlertesSignalementNonTraite();
    }
    @JsonView(vueAlerte.class)
    @GetMapping("/alertesDemandeRetourNonTraite")
    public List<Alerte> listeAlertesDemandeRetourNonTraite() {
        return this.alerteDao.findAlertesDemandeRetourNonTraite();
    }
    @JsonView(vueAlerte.class)
    @GetMapping("/alertesDemandeProlongationNonTraite")
    public List<Alerte> listeAlertesDemandeProlongationNonTraite(){
        return this.alerteDao.findAlertesDemandeProlongationNonTraite();
    }


}
