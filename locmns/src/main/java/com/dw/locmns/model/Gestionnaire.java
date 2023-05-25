package com.dw.locmns.model;

import com.dw.locmns.view.*;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data

public class Gestionnaire extends Utilisateur {


    @JsonView(vueGestionnaire.class)
    @ManyToMany
    @JoinTable(name = "documentation_gestionnaire",inverseJoinColumns = @JoinColumn(name= "id_documentation"))
    private Set<Documentation> listeDocumentation = new HashSet<>();





    @JsonView(vueReparation.class)
    @OneToMany(mappedBy = "gestionnaire")
    private Set<Reparation> listeReparation = new HashSet<>();



    /*@*//*JsonView(vueAlerte.class)
    @OneToMany(mappedBy = "gestionnaire")
    private Set<Alerte> listeAlerte = new HashSet<>();
*/
    /*@JsonView(vueLocation.class)
    @OneToMany(mappedBy = "gestionnaire")
    private Set<Location> listeLocation = new HashSet<>();*/



    public Gestionnaire() {
    }


    /*@ManyToOne
    @JoinColumn(name="id_utilisateur")
    private Utilisateur utilisateur;*/


}
