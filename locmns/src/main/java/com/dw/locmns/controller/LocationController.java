package com.dw.locmns.controller;

import com.dw.locmns.dao.LocationDao;
import com.dw.locmns.dao.ReservationDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Location;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class LocationController {
    private LocationDao locationDao;
    private UtilisateurDao utilisateurDao;

    private ReservationDao reservationDao;


    @Autowired
    public LocationController(LocationDao locationDao, UtilisateurDao utilisateurDao, ReservationDao reservationDao) {
        this.locationDao = locationDao;
        this.utilisateurDao = utilisateurDao;
        this.reservationDao = reservationDao;
    }




    @JsonView(vueLocation.class)
    //@JsonView(vueUtilisateur.class)
    @GetMapping("/gestionnaire/liste-locations")
    public List<Location> listeLocationsUtilisateur(){
        return this.locationDao.findAll();
    }


    @JsonView(vueLocation.class)
    @GetMapping("/gestionnaire/location/{id}")
    public Location location(@PathVariable Integer id) {
        return this.locationDao.findById(id).orElse(null);
    }






    //@GetMapping("/liste-locations-utilisateur/{idUtilisateur}")//Récupérer les utilisateurs qui ont loué un matériel
    //@JsonView(vueLocation.class)
   // @JsonView({vueUtilisateur.class, vueLocation.class})
   /* public List<Location> listeLocationUtilisateur(@PathVariable("idUtilisateur") Integer idUtilisateur) {
        return this.locationDao.listeLocationsUtilisateur(idUtilisateur);
    }*/


    @JsonView(vueLocation.class)
    @PostMapping("/gestionnaire/ajoutEditionLocation")//fonctionne
    public String ajoutEditionLocation(@RequestBody Location location) throws Exception {
        this.locationDao.save(location);
        return "location crée";
    }





    @JsonView(vueUtilisateur.class)
    @DeleteMapping("/gestionnaire/location/{id}")
    public String deleteLocation(@PathVariable int id) {
        this.locationDao.deleteById(id);
        return "Location supprimé";
    }


    @JsonView(vueLocation.class)
    @GetMapping("/gestionnaire/liste-location-numeroSerie")
    public List<Location> ListeLocationNumeroSerie(){
        return this.locationDao.findAll();
    }

    @JsonView(vueLocation.class)
    @GetMapping("/gestionnaire/materiels-defectueux") //Récupérer la liste des matériels défectueux
    public List<Location> listeMaterielsDisponibles(){
        return this.locationDao.findAllByEtatLocation("hors d'usage");
    }
























}
