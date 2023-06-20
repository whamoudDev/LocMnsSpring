package com.dw.locmns.dao;

import com.dw.locmns.model.Location;
import com.dw.locmns.model.Photo;
import com.dw.locmns.model.Reservation;
import com.dw.locmns.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

   Optional<Reservation> findByUtilisateurIdUtilisateurAndIdReservationAndDateDebutReservation(
           Integer idUtilisateur,
           Integer idReservation,
           Date date
   );


  /* void deleteByUtilisateurIdAndReservationIdAndDateDebutReservation(
           Integer idUtilisateur,
           Integer idReservation,
           Date dateDebutReservation
   );*/
 /* Reservation findByUtilisateurIdAndLocationIdLocation(
          Integer idUtilisateur,
          Integer idLocation
  );*/

   // List<Reservation> findByIdReservation(int idReservation);
   List<Reservation> findByCadreUtilisation(String cadreUtilisation);

   /*@Query("SELECT count(r) FROM Reservation r WHERE r.dateDebutReservation is not null")
   Integer RechercherNombreDemandesReservation();*/

   @Query("SELECT R FROM Reservation R WHERE R.dateFinPrevu < CURRENT_TIMESTAMP AND R.dateRetourReel IS NULL")
   List<Reservation> listeReservationNonRendu();

   @Query("SELECT R FROM Reservation R WHERE R.dateRetourReel IS NULL")
   List<Reservation> listeReservationEnCours();

   @Query("SELECT R FROM Reservation R WHERE R.utilisateur.idUtilisateur= :idUtilisateur")
   List<Reservation> findByIdUtilisateur(@Param("idUtilisateur")int idUtilisateur);
   @Query("SELECT R FROM Reservation R WHERE R.location.idLocation= :idLocation")
   List<Reservation> findByIdLocation(@Param("idLocation")int idLocation);
}
