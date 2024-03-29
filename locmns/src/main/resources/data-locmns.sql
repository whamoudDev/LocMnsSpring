--Insertion des types dabord

INSERT INTO `localisation` (`libelle_localisation`)
VALUES
    (  "MNS"),
    ( "IFA");



INSERT INTO `type_utilisateur` (`role_utilisateur`) VALUES
('ROLE_SUPERADMIN'),
('ROLE_GESTIONNAIRE'),
('ROLE_UTILISATEUR');


INSERT INTO `type_location` (`id_type_location`, `libelle_type_location`)
VALUES
(1, "Ordinateur portable"),
(2, "Video Projecteur"),
(3, "Casque VR"),
(4, "Salle");

--Insertion des tables principales dans l'ordre de dépendances
INSERT INTO `utilisateur` (`nom_utilisateur`,`prenom_utilisateur`,`adresse_utilisateur`,`mot_de_passe_utilisateur`,`mail_utilisateur`,`telephone_utilisateur`,`localisation_id_localisation`, `type_utilisateur_id_type_utilisateur`)
VALUES
    ("zmander","donia","route du creve coeur","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q", "donia@donia.com", "0000000000",1,2),
    ("hamoud","walid","rue de verdun","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q", "walid@walid.com", "0000000000",2,2),
    ("sarah","sisi","rue de mns","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q", "sarah@sarah.com", "0000000000",1,3),
    ("Lili","Lolo","rue de france","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q", "lili@lili.com", "0000000000",2,1),
    ("hamoud","Farid","rue de verdun","$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q", "farid@farid.com", "0000000000",2,3);

    -- INSERT INTO reservation (`cadre_utilisation`, `date_debut_reservation`,`date_fin_prevu`,`date_retour_reel`, `location_id_location`, `utilisateur_id_utilisateur`)
    -- VALUES
    -- ("Cours","2023-01-15", "2023-06-30",NULL,1, 2),
    -- ("Journée portes ouvertes", "2023-02-02","2023-02-05", NULL, 1 , 2 ),
    -- ("Réunion", "2023-01-01", "2023-01-03",NULL, 1 , 2 ),
    -- ("Location longue", "2023-09-01","2025-09-01",NULL, 1 , 2),
    -- ("Réunion", "2023-01-01", "2023-07-03",NULL, 1 , 2 ),
    -- ("Réunion", "2023-01-01", "2023-06-05","2023-06-05", 1 , 2 );




INSERT INTO `location` (`description_location`,`etat_location`,`nom_location`, `num_serie_location`,`statut_location`, `localisation_id_localisation`, `type_location_id_type_location`)
VALUES
("DEll intel core i5", "operationnel", "ordinateur portable", "VX550","reserve",1, 1),
("MSI projecteur", "hors d'usage", "Video projecteur", "VX110","dispo",2, 2),
("Asus intel core i5", "neuf", "Ordinateur portable", "VX110","reparation",2, 1),
("DEll intel core i5", "operationnel", "ordinateur portable", "VX550","reserve",1, 1),
("MSI projecteur", "hors d'usage", "Video projecteur", "VX110","dispo",2, 2),
("Salle 104", "bon", "Salle", "104","dispo",1, 4),
("MSI projecteur", "neuf", "Video projecteur", "VX245","reserve",2, 2);

INSERT INTO `reservation` (`cadre_utilisation`, `date_debut_reservation`,`date_fin_prevu`,`date_retour_reel`,`utilisateur_id_utilisateur`,`location_id_location`)
 VALUES
 ("Cours","2023-01-15", "2023-06-30",NULL,1,1 ),
 ("Journée portes ouvertes", "2023-02-02","2023-02-05", NULL, 1, 3 ),
 ("Réunion", "2023-01-01", "2023-01-03",NULL, 2 ,4 ),
 ("Location longue", "2023-09-01","2025-09-01",NULL,2,6 ),
 ("Journée portes ouvertes", "2023-02-02","2023-02-05", NULL, 5, 7 );


INSERT INTO `documentation` (`nom_documentation`,location_id_location)
VALUES
("fichestechniquesOrdinateurportable.pdf",1),
("fichestechniquesVideo projecteur.pdf",2),
("fichestechniquescasqueVR.pdf",3);


INSERT INTO `photo` (`nom_photo`,location_id_location)
VALUES
("lenovo.jpg",1),
("lenovo.jpg",2),
("lenovo.jpg",3),
("lenovo.jpg",4),
("lenovo.jpg",5),
("lenovo.jpg",6);




INSERT INTO `reparation` (`nom_reparation`, `description_panne`, `date_reception`, `date_reparation`, `date_retour_previsionnel`, `date_retour_reel`)
VALUES
  ('Réparation 46sg4zg', 'Ecran HS', '2023-06-08 10:00:00', '2023-06-10 14:30:00', '2023-06-15 12:00:00', '2023-06-17 16:45:00'),
  ('Réparation sd85754', 'Connecteur Hs', '2023-06-09 11:30:00', '2023-06-11 16:45:00', '2023-06-16 10:15:00', '2023-06-18 14:30:00'),
  ('Réparation 44dg54g', 'Ventilation bruyante', '2023-06-10 13:15:00', '2023-06-12 11:00:00', '2023-06-17 09:30:00', NULL),
  ('Réparation 887444dg', 'Ne charge plus', '2023-06-11 15:45:00', '2023-06-13 09:30:00', '2023-06-18 15:00:00', NULL),
  ('Réparation 8974616', 'Connecteur Usb hs', '2023-06-12 09:30:00', '2023-06-14 12:45:00', '2023-06-19 14:30:00', NULL);


INSERT INTO `Type_alerte` (`id_type_alerte`, `type_alerte`)
VALUES
(1, "reservation"),
(2, "reparation"),
(3, "signalement"),
(4, "demandeRetour"),
(5, "demandeProlongation");

INSERT INTO `alerte` (`date_alerte`,`description_alerte` ,`statut_alerte`, `date_traitement_alerte`,`reparation_id_reparation`, `reservation_id_reservation`, `type_alerte_id_type_alerte`, `utilisateur_id_utilisateur`)
VALUES
("2023-01-10", "demande de reservation", "NonTraite",NULL,NULL,1,1,1),
("2023-01-25", "demande de reservation", "Traite", "2023-01-27",NULL,2,1,2),
("2023-01-10", "demande de reservation", "NonTraite",NULL,NULL,1,1,1),
("2023-01-14", "demande de reservation", "Traite","2023-01-27",NULL,1,1,1),
("2023-01-16", "demande de reservation", "NonTraite", NULL,NULL,1,1,1),
("2023-01-10", "demande de reservation", "Traite", "2023-01-27",NULL,1,1,1),
("2023-01-10", "demande de reparation", "NonTraite", NULL,NULL,1,2,1),
("2023-01-10", "demande de reparation", "Traite", "2023-01-27",NULL,1,2,1),
("2023-01-10", "demande de reparation", "NonTraite", NULL,NULL,1,2,1),
("2023-01-10", "demande de reparation", "NonTraite",NULL,NULL,1,2,1),
("2023-01-25", "signalement", "Traite", "2023-01-27",NULL,2,3,2),
("2023-01-10", "signalement", "NonTraite",NULL,NULL,1,3,1),
("2023-01-14", "signalement", "Traite","2023-01-27",NULL,1,3,1),
("2023-01-16", "signalement", "NonTraite", NULL,NULL,1,3,1),
("2023-01-10", "signalement", "Traite", "2023-01-27",NULL,1,3,1),
("2023-01-10", "signalement", "NonTraite", NULL,NULL,1,3,1),
("2023-01-10", "signalement", "Traite", "2023-01-27",NULL,1,3,1),
("2023-01-10", "demande de retour", "NonTraite", NULL,NULL,1,4,1),
("2023-01-25", "demande de retour", "Traite", "2023-01-27",NULL,2,4,2),
("2023-01-10", "demande de retour", "NonTraite",NULL,NULL,1,4,1),
("2023-01-14", "demande de retour", "Traite","2023-01-27",NULL,1,4,1),
("2023-01-16", "demande de retour", "NonTraite", NULL,NULL,1,4,1),
("2023-01-10", "demande de prolongation", "Traite", "2023-01-27",NULL,1,5,1),
("2023-01-10", "demande de prolongation", "NonTraite", NULL,NULL,1,5,1),
("2023-01-10", "demande de prolongation", "Traite", "2023-01-27",NULL,1,5,1),
("2023-01-10", "demande de prolongation", "NonTraite", NULL,NULL,1,5,1);














