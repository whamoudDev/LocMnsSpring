package com.dw.locmns.model;


import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueReservation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Location {

    @JsonView({vueUtilisateur.class, vueLocation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idLocation;
    @JsonView({vueUtilisateur.class, vueLocation.class})
    private String nomLocation;
    @JsonView({vueUtilisateur.class, vueLocation.class})
    private String etatLocation;
    @JsonView({vueUtilisateur.class, vueLocation.class})
    private String descriptionLocation;
    @JsonView({vueUtilisateur.class, vueLocation.class})
    private String numSerieLocation;
    @ManyToOne
    @JsonView(vueUtilisateur.class)
    //@JoinColumn(name="id_localisation")
    private Localisation localisation;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private TypeLocation typeLocation;

    @ManyToOne
    //@JsonView({vueUtilisateur.class, vueLocation.class})
    private Utilisateur utilisateur;






}
