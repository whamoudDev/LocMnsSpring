package com.dw.locmns.controller;

import com.dw.locmns.Services.FichierService;
import com.dw.locmns.dao.*;
import com.dw.locmns.model.*;
import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin
@RestController
public class LocationController {
    @Autowired
    private LocationDao locationDao;
    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private PhotoDao photoDao;
    @Autowired
    private DocumentationDao documentationDao;
    @Autowired
    private FichierService fichierService;

    @Autowired
    public LocationController(LocationDao locationDao, UtilisateurDao utilisateurDao, ReservationDao reservationDao) {
        this.locationDao = locationDao;
        this.utilisateurDao = utilisateurDao;
        this.reservationDao = reservationDao;
    }


    @JsonView(vueLocation.class)
    @GetMapping("/liste-locations")
    public List<Location> listeLocations() {
        return this.locationDao.findAll();
    }


    @JsonView({vueLocation.class})
    @GetMapping("/liste-locations/{idLocation}")
    public Location location(@PathVariable Integer idLocation) {
        return this.locationDao.findById(idLocation).orElse(null);
    }

    @GetMapping("/listePhotosLocation/{idLocation}")
    public Set<Photo> listePhotosLocation(@PathVariable int idLocation) {
        Optional<Location> optional = this.locationDao.findById(idLocation);

        Location location;

        if (optional.isPresent()) {
            location = optional.get();
            return location.getListePhotos();
        }
        return null;
    }

    //@GetMapping("/liste-locations-utilisateur/{idUtilisateur}")//Récupérer les utilisateurs qui ont loué un matériel
    //@JsonView(vueLocation.class)
    // @JsonView({vueUtilisateur.class, vueLocation.class})
   /* public List<Location> listeLocationUtilisateur(@PathVariable("idUtilisateur") Integer idUtilisateur) {
        return this.locationDao.listeLocationsUtilisateur(idUtilisateur);
    }*/


    @JsonView({vueLocation.class})
    @PostMapping("/gestionnaire/ajoutEditionLocation")//fonctionne
    public ResponseEntity<Location> ajoutEditionLocation(@RequestPart("location") Location location, @Nullable @RequestParam("image") MultipartFile image, @Nullable @RequestParam("fichier") MultipartFile fichier) throws Exception {
        Location locationTemp = new Location();

        if (location.getIdLocation() != null) {
            Optional<Location> optional = locationDao.findById(location.getIdLocation());
            if (optional.isPresent()) {
                locationTemp = optional.get();
            }
        }

        locationTemp.setNomLocation(location.getNomLocation());
        locationTemp.setNumSerieLocation(location.getNumSerieLocation());
        locationTemp.setEtatLocation(location.getEtatLocation());
        locationTemp.setDescriptionLocation(location.getDescriptionLocation());
        locationTemp.setStatutLocation(location.getStatutLocation());
        locationTemp.setTypeLocation(location.getTypeLocation());
        locationTemp.setLocalisation(location.getLocalisation());


        System.out.println("|||||||||||||||||||||||||||||||||||||||LOCATION SAVE AND FLUSH|||||||||||||||||||||||||||||||||||||");

        System.out.println("/////////////////ID : "+locationTemp.getIdLocation());
        locationTemp = this.locationDao.saveAndFlush(locationTemp);


        System.out.println("ID Location Temporaire : " + locationTemp.getIdLocation());

        if (image != null) {
            try {
                System.out.println("|||||||||||||||||||||||||||||||||||||||PHOTO A RAJOUTER |||||||||||||||||||||||||||||||||||||");
                Photo photo = new Photo();
                String nomPhoto = UUID.randomUUID() + "_" + image.getOriginalFilename();

                photo.setLocation(new Location());
                photo.getLocation().setIdLocation(locationTemp.getIdLocation());
                photo.setNomPhoto(nomPhoto);
                this.photoDao.save(photo);
                //nouvelleLocation.getListePhotos().add(photo);
                fichierService.transfertVersDossierImages(image, nomPhoto);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        if (fichier != null) {
            try {
                System.out.println("|||||||||||||||||||||||||||||||||||||||DOCUMENT A RAJOUTER |||||||||||||||||||||||||||||||||||||");
                Documentation documentation = new Documentation();
                String nomDocument = UUID.randomUUID() + "_" + fichier.getOriginalFilename();

                documentation.setLocation(new Location());
                documentation.getLocation().setIdLocation(locationTemp.getIdLocation());
                documentation.setNomDocumentation(nomDocument);
                this.documentationDao.save(documentation);
                //nouvelleLocation.getListeDocumentations().add(documentation);
                fichierService.transfertVersDossierDocumentations(fichier, nomDocument);
            } catch (IOException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }


        return new ResponseEntity<>(locationTemp, HttpStatus.OK);
    }


    @JsonView({vueLocation.class})
    @DeleteMapping("/gestionnaire/location/{id}")
    public String deleteLocation(@PathVariable int id) {

//        List<Reservation> listReservation= this.reservationDao.findByIdLocation(id);
//        for(Reservation reservation : listReservation){
//            reservationDao.deleteById(reservation.getIdReservation());
//        }
//
//        List<Photo> listPhoto= this.photoDao.findByLocationId(id);
//        for(Photo photo : listPhoto){
//            photoDao.deleteById(photo.getIdPhoto());
//        }
//
//        List<Documentation> listDocumentation= this.documentationDao.findByLocationId(id);
//        for(Documentation doc : listDocumentation){
//            documentationDao.deleteById(doc.getIdDocumentation());
//        }
        this.locationDao.deleteById(id);
        return "Location supprimé";
    }


    @JsonView({vueLocation.class})
    @GetMapping("/liste-location-numeroSerie")
    public List<Location> ListeLocationNumeroSerie() {
        return this.locationDao.findAll();
    }

    @JsonView({vueLocation.class})
    @GetMapping("/materiels-defectueux") //Récupérer la liste des matériels défectueux
    public List<Location> listeMaterielsEnPanne() {
        return this.locationDao.findAllByEtatLocation("hors d'usage");
    }


    @JsonView({vueTypeLocation.class})
    @GetMapping("/location-disponible")
    public List<Location> listeLocationDisponible() {
        return this.locationDao.listeLocationDisponible();

    }



    @GetMapping("/photoLocation/{idLocation}")
    public ResponseEntity<byte[]> getPhotoLocation(@PathVariable int idLocation) {
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





















