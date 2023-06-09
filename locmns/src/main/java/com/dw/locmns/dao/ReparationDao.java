package com.dw.locmns.dao;

import com.dw.locmns.model.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReparationDao extends JpaRepository<Reparation, Integer> {
    @Query("SELECT R FROM Reparation R WHERE R.dateRetourReel IS NULL")
    List<Reparation> findReparationEnCours();
}
