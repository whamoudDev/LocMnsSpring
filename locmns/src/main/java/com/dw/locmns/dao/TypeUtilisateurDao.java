package com.dw.locmns.dao;

import com.dw.locmns.model.TypeLocation;
import com.dw.locmns.model.TypeUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeUtilisateurDao extends JpaRepository<TypeUtilisateur, Integer> {
}
