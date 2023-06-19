package com.dw.locmns.dao;

import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository

public interface LocationDao extends JpaRepository<Location, Integer> {




    //Récupére l'idUtilisateur et numéro de série des locations en cours de l'utilisateur
/*
    @Query("SELECT l FROM Location l JOIN l.reservations r WHERE r.utilisateur.idUtilisateur = :idUtilisateur AND r.dateFinPrevu >= current_date")
    List<Location> listeLocationsUtilisateur(@Param("idUtilisateur") Integer idUtilisateur);
*/



    //Recherche d'une location qui n'est pas présente dans la table reservation (nouveau matériel)
   /* @Query(value="SELECT location.id_location FROM location INNER JOIN  reservation ON location.id_location = reservation.id_location WHERE reservation.id_reservation IS NULL LIMIT 1", nativeQuery = true)
    Integer RechercheNouvelleLocationDemandeReservat(@Param("idLocation") Integer idLocation);
*/

    List<Location> findAllByEtatLocation(String etatLocation);


    //Récupére l'id et numéro de série des locations en cours de réservation de l'utilisateur
//    @Query("SELECT l.idLocation, l.numSerieLocation FROM Location l JOIN l.utilisateur u JOIN l.reservations r WHERE u.idUtilisateur = :utilisateurId AND r.dateFinPrevu > current_date")
//    List<Location> listeLocationUtilisateur(@Param("utilisateurId") Integer id);

    @Query("SELECT L FROM Location L WHERE L.statutLocation='dispo' ")
    List<Location> listeLocationDisponible();


}
