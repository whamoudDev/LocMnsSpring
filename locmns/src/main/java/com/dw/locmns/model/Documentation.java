package com.dw.locmns.model;

import com.dw.locmns.view.vueDocumentation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Documentation {
    @JsonView(vueUtilisateur.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idDocumentation;

    @JsonView(vueUtilisateur.class)
    private  String nomDocumentation;


    @JsonView(vueUtilisateur.class)
    private  String descriptionDocumentation;

    @JsonView(vueUtilisateur.class)
    private  String fichierDocumentation;

    /*@ManyToOne
    Location location;*/

   /* @ManyToOne
    @JoinColumn(name = "idLocation")
    private Location location;*/



}
