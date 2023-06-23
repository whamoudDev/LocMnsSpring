package com.dw.locmns.model;


import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeId;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    protected Integer idUtilisateur;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String nomUtilisateur;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String prenomUtilisateur;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String adresseUtilisateur;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String motDePasseUtilisateur;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String mailUtilisateur;
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    protected String telephoneUtilisateur;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private Localisation localisation;

    @ManyToOne
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vuePhoto.class, vueDocumentation.class})
    private TypeUtilisateur typeUtilisateur;

    @JsonView({vueUtilisateur.class})
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Reservation> listeReservation = new HashSet<>();

}
