package com.dw.locmns.model;

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
    private Integer idAlerte;


    private LocalDateTime dateAlerte;

    private String descriptionAlerte;

    private String statutAlerte;

    private LocalDateTime dateTraitementAlerte;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private Reservation reservation;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private Reparation reparation;

    @ManyToOne
    @JsonView(vueUtilisateur.class)
    private TypeAlerte typeAlerte;




}
