package com.dw.locmns.model;

import com.dw.locmns.view.vueAlerte;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Alerte {

    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    @JsonView(vueAlerte.class)
    private Integer idAlerte;


    @JsonView(vueAlerte.class)
    private LocalDateTime dateAlerte;

    @JsonView(vueAlerte.class)
    private String descriptionAlerte;

    @JsonView(vueAlerte.class)
    private String statutAlerte;

    @JsonView(vueAlerte.class)
    private LocalDateTime dateTraitementAlerte;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueAlerte.class})
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueAlerte.class})
    private Reservation reservation;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueAlerte.class})
    private Reparation reparation;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueAlerte.class})
    private TypeAlerte typeAlerte;




}
