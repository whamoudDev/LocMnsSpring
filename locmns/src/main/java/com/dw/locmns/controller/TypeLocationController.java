package com.dw.locmns.controller;

import com.dw.locmns.dao.TypeLocationDao;
import com.dw.locmns.dao.TypeUtilisateurDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.TypeLocation;
import com.dw.locmns.model.TypeUtilisateur;
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
public class TypeLocationController {

    @Autowired
    private TypeLocationDao typeLocationDao;

    @Autowired
    public TypeLocationController(TypeLocationDao typeLocationDao) {
        this.typeLocationDao = typeLocationDao;
    }

    @GetMapping("/liste-typeLocations")
    public List<TypeLocation> ListeTypeLocations(){
        return this.typeLocationDao.findAll();
    }

    @GetMapping("/typeLocation/{id}")
    public TypeLocation typeLocation(@PathVariable Integer id){
        return this.typeLocationDao.findById(id).orElse(null);
    }


}
