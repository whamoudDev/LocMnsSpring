package com.dw.locmns.dao;

import com.dw.locmns.model.Documentation;
import com.dw.locmns.model.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentationDao  extends JpaRepository<Documentation, Integer> {

    @Query("SELECT D FROM Documentation D WHERE D.location.idLocation = :id")
    List<Documentation> findByLocationId(@Param("id")int id);


}
