package com.dw.locmns.controller;


import com.dw.locmns.dao.LocalisationDao;
import com.dw.locmns.dao.ReparationDao;
import com.dw.locmns.dao.ReservationDao;
import com.dw.locmns.model.Reparation;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.view.vueReparation;
import com.dw.locmns.view.vueReservation;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ReparationController {

    @Autowired
    private ReparationDao reparationDao;

    @Autowired
    public ReparationController(ReparationDao reparationDao) {
        this.reparationDao = reparationDao;
    }


    @JsonView(vueReparation.class)
    @GetMapping("/gestionnaire/reparationEnCours")
    public List<Reparation> listeReparationEnCours() {
        return this.reparationDao.findReparationEnCours();
    }


}
