package com.dw.locmns.dao;

import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public interface LocationDao extends JpaRepository<Location, Integer> {


    List<Location> findAllByEtatLocation(String etatLocation);


    @Query("SELECT L FROM Location L WHERE L.statutLocation='dispo' ")
    List<Location> listeLocationDisponible();


}
