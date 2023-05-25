package com.dw.locmns.dao;

import com.dw.locmns.model.TypeLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeLocationDao extends JpaRepository<TypeLocation, Integer> {


}

