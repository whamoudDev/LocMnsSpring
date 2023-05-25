package com.dw.locmns.model;

import com.dw.locmns.view.vueAlerte;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
public class TypeAlerte {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTypeAlerte;


    private String typeAlerte;

    public TypeAlerte() {
    }


    /* @JsonView(vueAlerte.class)
    @OneToMany(mappedBy = "typeAlerte")
    private Set<Alerte> listeAlerte= new HashSet<>();

*/

}
