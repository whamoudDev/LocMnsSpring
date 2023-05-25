package com.dw.locmns.dao;

import com.dw.locmns.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeAlerteDao extends JpaRepository <TypeAlerte, Integer> {



    //List<TypeAlerte> getTypeAlerte(String typeAlerte);

}
