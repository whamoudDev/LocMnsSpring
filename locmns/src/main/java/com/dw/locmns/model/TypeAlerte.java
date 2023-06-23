package com.dw.locmns.model;

import com.dw.locmns.view.vueAlerte;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TypeAlerte {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTypeAlerte;

    private String typeAlerte;

}
