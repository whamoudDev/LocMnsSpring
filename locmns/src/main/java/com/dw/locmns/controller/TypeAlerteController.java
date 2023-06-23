package com.dw.locmns.controller;

import com.dw.locmns.dao.TypeAlerteDao;
import com.dw.locmns.dao.TypeUtilisateurDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.TypeAlerte;
import com.dw.locmns.model.TypeUtilisateur;
import com.dw.locmns.view.vueAlerte;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueTypeAlerte;
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
public class TypeAlerteController {


    @Autowired
    private TypeAlerteDao typeAlerteDao;

    @Autowired
    private UtilisateurDao utilisateurDao;


    @Autowired
    public TypeAlerteController(TypeAlerteDao typeAlerteDao) {
        this.typeAlerteDao = typeAlerteDao;
    }


    @GetMapping("/users/type-alerte")
    @JsonView(vueTypeAlerte.class)
    //@JsonView(vueUtilisateur.class)
    public List<TypeAlerte> getTypeAlerte() {
        return this.typeAlerteDao.findAll();
    }


    @GetMapping("/users/type-alerte/{id}")
    @JsonView(vueTypeAlerte.class)
    public TypeAlerte typeAlerte(@PathVariable Integer id) {
        return this.typeAlerteDao.findById(id).orElse(null);
    }

}
