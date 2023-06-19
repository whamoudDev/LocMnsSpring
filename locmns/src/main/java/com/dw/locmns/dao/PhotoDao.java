package com.dw.locmns.dao;

import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Photo;
import com.dw.locmns.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Integer> {

    @Query("SELECT P FROM Photo P WHERE P.location.idLocation = :id")
    List<Photo> findByLocationId(@Param("id")int id);


}
