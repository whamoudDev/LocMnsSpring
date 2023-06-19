package com.dw.locmns.model;

import com.dw.locmns.view.vueLocalisation;
import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Localisation {

    @JsonView({vueUtilisateur.class,vueLocation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idLocalisation;


    @JsonView({vueUtilisateur.class,vueLocation.class})
    private  String libelleLocalisation;





}
