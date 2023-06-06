package com.dw.locmns.model;


import com.dw.locmns.view.vueAlerte;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Reservation {

    @JsonView({vueUtilisateur.class, vueReservation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idReservation;

    @JsonView(vueReservation.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateDebutReservation;

    @JsonView(vueReservation.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateFinPrevu;

    //@JsonView({vueUtilisateur.class, vueReservation.class})
    //@JsonView(vueUtilisateur.class)
    @JsonView(vueReservation.class)
    private String cadreUtilisation;

    @JsonView(vueReservation.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateRetourReel;




    @JsonView(vueUtilisateur.class)
    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private Location location;

   /* @JsonView(vueAlerte.class)
    @OneToMany(mappedBy = "reservation")
    private Set<Alerte> listeAlerte= new HashSet<>();*/


    public Reservation() {
    }


    public Reservation(Integer idReservation, LocalDateTime dateDebutReservation, LocalDateTime dateFinPrevu, String cadreUtilisation, Utilisateur utilisateur, Location location) {
        this.idReservation = idReservation;
        this.dateDebutReservation = dateDebutReservation;
        this.dateFinPrevu = dateFinPrevu;
        this.cadreUtilisation = cadreUtilisation;
        this.utilisateur = utilisateur;
        this.location = location;
    }


}
