package com.dw.locmns.dao;

import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDao extends JpaRepository<Photo, Integer> {




}
