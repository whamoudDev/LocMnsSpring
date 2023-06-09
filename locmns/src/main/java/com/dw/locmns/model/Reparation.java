package com.dw.locmns.model;

import com.dw.locmns.view.vueAlerte;
import com.dw.locmns.view.vueReparation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Reparation {
    @JsonView(vueReparation.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idReparation;

    @JsonView(vueReparation.class)
    private  String nomReparation;

    @JsonView(vueReparation.class)
    private  String descriptionPanne;

    @JsonView(vueReparation.class)
    private LocalDateTime dateReception;
    @JsonView(vueReparation.class)
    private LocalDateTime dateReparation;
    @JsonView(vueReparation.class)
    private LocalDateTime dateRetourPrevisionnel;
    @JsonView(vueReparation.class)
    private LocalDateTime dateRetourReel;


    /*@JsonView(vueAlerte.class)
    @OneToMany(mappedBy = "reparation")
    private Set<Alerte> listeAlerte= new HashSet<>();
*/

    @ManyToOne
    @JsonView(vueReparation.class)
    private Location location;

    @ManyToOne
    @JsonView(vueReparation.class)
    private Gestionnaire gestionnaire;




}
