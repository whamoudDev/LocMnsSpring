package com.dw.locmns.dao;

import com.dw.locmns.model.Alerte;
import com.dw.locmns.model.Location;
import com.dw.locmns.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlerteDao extends JpaRepository<Alerte, Integer> {

    @Query("FROM Alerte A  WHERE A.statutAlerte ='NonTraite'")
    List<Alerte> findAlertesNonTraite();

    @Query("SELECT A FROM Alerte A JOIN A.typeAlerte TA WHERE A.statutAlerte ='NonTraite' AND TA.idTypeAlerte = 1")
    List<Alerte> findAlertesReservationNonTraite();
    @Query("SELECT A FROM Alerte A JOIN A.typeAlerte TA WHERE A.statutAlerte ='NonTraite' AND TA.idTypeAlerte = 2")
    List<Alerte> findAlertesReparationNonTraite();
    @Query("SELECT A FROM Alerte A JOIN A.typeAlerte TA WHERE A.statutAlerte ='NonTraite' AND TA.idTypeAlerte = 3")
    List<Alerte> findAlertesSignalementNonTraite();

    @Query("SELECT A FROM Alerte A JOIN A.typeAlerte TA WHERE A.statutAlerte ='NonTraite' AND TA.idTypeAlerte = 4")
    List<Alerte> findAlertesDemandeRetourNonTraite();

    @Query("SELECT A FROM Alerte A JOIN A.typeAlerte TA WHERE A.statutAlerte ='NonTraite' AND TA.idTypeAlerte = 5")
    List<Alerte> findAlertesDemandeProlongationNonTraite();



}
