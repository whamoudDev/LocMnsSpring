package com.dw.locmns.model;


import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur  {

    @JsonView({vueUtilisateur.class, vueLocation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    protected Integer idUtilisateur;

    @JsonView(vueUtilisateur.class)
    protected String nomUtilisateur;


    @JsonView(vueUtilisateur.class)
    protected String prenomUtilisateur;
    @JsonView(vueUtilisateur.class)
    protected String adresseUtilisateur;
    @JsonView(vueUtilisateur.class)
    protected String motDePasseUtilisateur;
    @JsonView(vueUtilisateur.class)
    protected String mailUtilisateur;
    @JsonView(vueUtilisateur.class)
    protected String telephoneUtilisateur;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private Localisation localisation;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private TypeUtilisateur typeUtilisateur;


    @JsonView(vueReservation.class)
    @OneToMany(mappedBy = "utilisateur")
    private Set<Reservation> listeReservation = new HashSet<>();



    public Utilisateur() {
    }
}
