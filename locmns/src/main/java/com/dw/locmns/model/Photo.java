package com.dw.locmns.model;

import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photo {


    @JsonView({vueUtilisateur.class, vueReservation.class,vueLocation.class,vuePhoto.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    private Integer idPhoto;

    @JsonView({vueUtilisateur.class, vueReservation.class,vueLocation.class,vuePhoto.class})
    // Il s'agit du nom du fichier avec son extension
    private String nomPhoto;




//    @JsonView({vuePhoto.class})
    @JsonIgnore
    @ManyToOne
    private Location location;


}
