package com.dw.locmns.model;


import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idReservation;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    //@JsonFormat(pattern = "yyyy-MM-dd ")
    private LocalDateTime dateDebutReservation;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    // @JsonFormat(pattern = "yyyy-MM-dd ")
    private LocalDateTime dateFinPrevu;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private String cadreUtilisation;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateRetourReel;

    @ManyToOne
    @JsonView(vueReservation.class)
    private Utilisateur utilisateur;

    @ManyToOne
    @JsonView({vueReservation.class})
    private Location location;

    @JsonView(vueReservation.class)
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Alerte> listeAlerte = new HashSet<>();

}
