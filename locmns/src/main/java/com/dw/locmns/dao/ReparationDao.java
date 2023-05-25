package com.dw.locmns.dao;

import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reparation;
import com.dw.locmns.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ReparationDao extends JpaRepository<Reparation, Integer> {






}
