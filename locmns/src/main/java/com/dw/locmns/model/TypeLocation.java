package com.dw.locmns.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class TypeLocation {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idTypeLocation;


    private String  libelleTypeLocation;


   /* @OneToMany
    private Location location;
*/




}
