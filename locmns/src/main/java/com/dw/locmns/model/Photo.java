package com.dw.locmns.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Photo {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idPhoto;


    private String photoLocation;

   /* @OneToMany(mappedBy = "Location")
    private Set<Photo> listeLocation= new HashSet<>();
*/

}
