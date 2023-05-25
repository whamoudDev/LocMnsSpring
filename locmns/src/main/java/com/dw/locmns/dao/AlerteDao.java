package com.dw.locmns.dao;

import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlerteDao extends JpaRepository<Alerte, Integer> {

}
