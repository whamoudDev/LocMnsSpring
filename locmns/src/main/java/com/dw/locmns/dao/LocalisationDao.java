package com.dw.locmns.dao;

import com.dw.locmns.model.Localisation;
import com.dw.locmns.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalisationDao extends JpaRepository<Localisation, Integer> {



}
