package com.dw.locmns.model;

import javax.persistence.*;

import com.dw.locmns.view.vueLocalisation;
import com.dw.locmns.view.vueTypeUtilisateur;
import com.dw.locmns.view.vueUtilisateur;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Data
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TypeUtilisateur {
    @JsonView(vueUtilisateur.class)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTypeUtilisateur;
    @JsonView(vueUtilisateur.class)
    private String roleUtilisateur;







}
