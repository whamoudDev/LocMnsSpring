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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class LocationController {
    private LocationDao locationDao;
    private UtilisateurDao utilisateurDao;

    private ReservationDao reservationDao;

    @Autowired
    FichierService fichierService;

    @Autowired
    public LocationController(LocationDao locationDao, UtilisateurDao utilisateurDao, ReservationDao reservationDao) {
        this.locationDao = locationDao;
        this.utilisateurDao = utilisateurDao;
        this.reservationDao = reservationDao;
    }




    @JsonView(vueLocation.class)
    //@JsonView(vueUtilisateur.class)
    @GetMapping("/liste-locations")
    public List<Location> listeLocationsUtilisateur() {
        return this.locationDao.findAll();
    }


    @JsonView(vueLocation.class)
    @GetMapping("/liste-locations/{idLocation}")
    public Location location(@PathVariable Integer idLocation) {
        return this.locationDao.findById(idLocation).orElse(null);
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
    @GetMapping("/liste-location-numeroSerie")
    public List<Location> ListeLocationNumeroSerie() {
        return this.locationDao.findAll();
    }

    @JsonView(vueLocation.class)
    @GetMapping("/materiels-defectueux") //Récupérer la liste des matériels défectueux
    public List<Location> listeMaterielsDisponibles() {
        return this.locationDao.findAllByEtatLocation("hors d'usage");
    }
    @JsonView(vueLocation.class)
    @GetMapping("/locationDisponible")
    public List<Location> listeLocationDisponible(){
        return this.locationDao.listeLocationDisponible();

    }



    @GetMapping("/photoLocation/{idLocation}")
    public ResponseEntity<byte[]> getPhotoLocation(@PathVariable int idLocation){
        Optional<Location> optional = locationDao.findById(idLocation);
        if (optional.isPresent()) {
            String nomImage = optional.get().getNomLocation();
            try {
                byte[] image = fichierService.getImageByName(nomImage);
                HttpHeaders enTete = new HttpHeaders();
                String mimeType = Files.probeContentType(new File(nomImage).toPath());
                enTete.setContentType(MediaType.valueOf(mimeType));
                return new ResponseEntity<>(image, enTete, HttpStatus.OK);

            } catch (FileNotFoundException e) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } catch (IOException e) {
                System.out.println("Le test de mimetype a échoué");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}





















