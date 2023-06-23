package com.dw.locmns.model;

import com.dw.locmns.view.vueLocation;
import com.dw.locmns.view.vueTypeLocation;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TypeLocation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @JsonView({vueLocation.class, vueTypeLocation.class})
    private Integer idTypeLocation;


    @JsonView({vueLocation.class, vueTypeLocation.class})
    private String libelleTypeLocation;


}
