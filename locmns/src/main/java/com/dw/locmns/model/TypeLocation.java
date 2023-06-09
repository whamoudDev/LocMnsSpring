package com.dw.locmns.model;

import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TypeLocation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonView({vueUtilisateur.class, vueLocation.class})
    private Integer idTypeLocation;


    @JsonView({vueUtilisateur.class, vueLocation.class})
    private String  libelleTypeLocation;


   /* @OneToMany
    private Location location;
*/




}
