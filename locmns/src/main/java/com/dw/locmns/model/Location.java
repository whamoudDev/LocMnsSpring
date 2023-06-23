package com.dw.locmns.model;


import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idLocation;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String nomLocation;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String etatLocation;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String descriptionLocation;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String numSerieLocation;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String statutLocation;
    @ManyToOne
    @JsonView({vueLocation.class})
    //@JoinColumn(name="id_localisation")
    private Localisation localisation;

    @ManyToOne
    @JsonView({vueLocation.class})
    private TypeLocation typeLocation;


    @JsonView({vueLocation.class})
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Photo> listePhotos = new HashSet<>();
    @JsonView({vueLocation.class})
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Documentation> listeDocumentations = new HashSet<>();


    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonView(vueLocation.class)
    private Set<Reservation> reservation = new HashSet<>();

}
