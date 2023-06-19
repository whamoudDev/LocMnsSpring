package com.dw.locmns.controller;

import com.dw.locmns.dao.DocumentationDao;
import com.dw.locmns.dao.LocationDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Documentation;
import com.dw.locmns.model.Location;
import com.dw.locmns.view.vueDocumentation;
import com.dw.locmns.view.vueLocation;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class DocumentationController {
    @Autowired
    private DocumentationDao documentationDao;
    @Autowired
    private LocationDao locationDao;

    @JsonView(vueDocumentation.class)
    @GetMapping("/liste-documentation")
    public List<Documentation> listeDocumentation() {
        return this.documentationDao.findAll();
    }

}