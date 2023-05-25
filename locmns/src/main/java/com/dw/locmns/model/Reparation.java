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
    @JsonView(vueUtilisateur.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idReparation;

    @JsonView(vueUtilisateur.class)
    private  String nomReparation;

    @JsonView(vueUtilisateur.class)
    private  String descriptionPanne;

    @JsonView(vueUtilisateur.class)
    private LocalDateTime dateReception;
    @JsonView(vueUtilisateur.class)
    private LocalDateTime dateReparation;
    @JsonView(vueUtilisateur.class)
    private LocalDateTime dateRetourPrevisionnel;
    @JsonView(vueUtilisateur.class)
    private LocalDateTime dateRetour;


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
