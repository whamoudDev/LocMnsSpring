package com.dw.locmns.controller;

import com.dw.locmns.dao.LocationDao;
import com.dw.locmns.dao.ReservationDao;
import com.dw.locmns.dao.UtilisateurDao;
import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.Utilisateur;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @PostMapping("/utilisateur/demandeReservation")
    public String demandeReservation(@RequestBody Reservation reservation) throws Exception{
         reservationDao.save(reservation);
         return "demande ajouté";

    }



    @GetMapping("/reservations/{id}")
    public Reservation getDemandeReservationById(@PathVariable Integer idReservation) {
        return reservationDao.findById(idReservation).orElse(null);
    }


    /*@PutMapping("/reservations/{id}")
    public Reservation updateReservation(@PathVariable Integer id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationDao.save(reservation);
    }
*/



    /*@JsonView(vueReservation.class)
    @GetMapping("gestionnaire/reservation/{idUtilisateur}/{idReservation}/{dateDebutReservation}")
    public Reservation reservation(@PathVariable Integer idUtilisateur,
                                   @PathVariable Integer idReservation,
                                   @PathVariable String dateDebutReservation)
            throws ParseException {
        Date nouvelleDateReservation= new SimpleDateFormat("yyyy-MM-dd").parse(dateDebutReservation);

        return this.reservationDao.findByUtilisateurIdUtilisateurAndIdReservationAndDateDebutReservation(idUtilisateur, idReservation, nouvelleDateReservation).orElse(null);
    }*/


    @GetMapping("/liste-cadres-utilisation")
    @JsonView(vueReservation.class)
    public List<Reservation> listeCadresUtilisation(){
        return this.reservationDao.findAll();
    }







}
