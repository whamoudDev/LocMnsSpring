package com.dw.locmns.dao;

import com.dw.locmns.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurDao extends JpaRepository <Utilisateur, Integer>  {

    Optional<Utilisateur> findBymailUtilisateur(String mailUtilisateur);
}
