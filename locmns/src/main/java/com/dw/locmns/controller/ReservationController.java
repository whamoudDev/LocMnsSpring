package com.dw.locmns.controller;

import com.dw.locmns.dao.LocationDao;
import com.dw.locmns.dao.ReservationDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class ReservationController {

    @Autowired
    private ReservationDao reservationDao;
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private UtilisateurDao utilisateurDao;


    @Autowired
    public ReservationController(ReservationDao reservationDao, UtilisateurDao utilisateurDao, LocationDao locationDao) {
        this.reservationDao = reservationDao;
        this.utilisateurDao = utilisateurDao;
        this.locationDao = locationDao;
    }


    @PostMapping("/users/demandeReservation")
    @JsonView({vueReservation.class})
    public String demandeReservation(@RequestPart("reservation") Reservation reservation) {
        //Enregistre la date du jour pour la date de demande
        //reservation.setDateDebutReservation(LocalDateTime.now());
        reservationDao.save(reservation);
        return "demande ajouté";

    }


    @JsonView({vueReservation.class})
    @GetMapping("/users/reservations")
    public List<Reservation> getListeReservations() {
        return this.reservationDao.findAll();
    }

    @GetMapping("/users/reservation/{idReservation}")
    @JsonView({vueReservation.class})
    public Reservation getReservation(@PathVariable Integer idReservation) {
        return this.reservationDao.findById(idReservation).orElse(null);
    }

    @GetMapping("/users/reservationUtilisateur/{idUtilisateur}")
    @JsonView({vueReservation.class})
    public List<Reservation> getListeReservationUtilisateur(@PathVariable Integer idUtilisateur) {
        return this.reservationDao.findByIdUtilisateur(idUtilisateur);
    }

    @GetMapping("/users/reservationLocation/{idLocation}")
    @JsonView({vueReservation.class})
    public List<Reservation> getListeReservationLocation(@PathVariable Integer idLocation) {
        return this.reservationDao.findByIdLocation(idLocation);
    }


    @GetMapping("/users/liste-cadres-utilisation")
    @JsonView({vueReservation.class})
    public List<Reservation> listeCadresUtilisation() {
        return this.reservationDao.findAll();
    }


    @GetMapping("/gestionnaire/reservationNonRendu")
    @JsonView({vueReservation.class})
    public List<Reservation> listeReservationNonRendu() {
        return this.reservationDao.listeReservationNonRendu();
    }

    @GetMapping("/gestionnaire/reservationEnCours")
    @JsonView({vueReservation.class})
    public List<Reservation> listeReservationEnCours() {
        return this.reservationDao.listeReservationEnCours();
    }


}
