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
public class Documentation {
    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vueDocumentation.class})
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idDocumentation;

    @JsonView({vueUtilisateur.class, vueReservation.class, vueLocation.class, vueDocumentation.class})
    // Il s'agit du nom du fichier avec son extension
    private String nomDocumentation;

    @JsonView({vueDocumentation.class})
    @ManyToOne
    private Location location;

}
