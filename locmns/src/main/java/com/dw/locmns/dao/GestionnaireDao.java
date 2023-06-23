package com.dw.locmns.dao;

import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Gestionnaire;
import com.dw.locmns.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GestionnaireDao extends JpaRepository<Gestionnaire, Integer> {

    Optional<Utilisateur> findBymailUtilisateur(String mailUtilisateur);


}
