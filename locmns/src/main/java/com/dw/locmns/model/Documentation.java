package com.dw.locmns.model;

import com.dw.locmns.view.vueDocumentation;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Documentation {
    @JsonView(vueDocumentation.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idDocumentation;

    @JsonView(vueDocumentation.class)
    private  String nomDocumentation;


    @JsonView(vueDocumentation.class)
    private  String descriptionDocumentation;

    @JsonView(vueDocumentation.class)
    private  String fichierDocumentation;


    @ManyToOne
    @JsonView({vueLocation.class, vueDocumentation.class})
    private Location location;



}
