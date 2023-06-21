-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 21 juin 2023 à 07:50
-- Version du serveur : 8.0.31
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `loc_mns`
--

-- --------------------------------------------------------

--
-- Structure de la table `alerte`
--

DROP TABLE IF EXISTS `alerte`;
CREATE TABLE IF NOT EXISTS `alerte` (
  `id_alerte` int NOT NULL AUTO_INCREMENT,
  `date_alerte` datetime(6) DEFAULT NULL,
  `date_traitement_alerte` datetime(6) DEFAULT NULL,
  `description_alerte` varchar(255) DEFAULT NULL,
  `statut_alerte` varchar(255) DEFAULT NULL,
  `reparation_id_reparation` int DEFAULT NULL,
  `reservation_id_reservation` int DEFAULT NULL,
  `type_alerte_id_type_alerte` int DEFAULT NULL,
  `utilisateur_id_utilisateur` int DEFAULT NULL,
  PRIMARY KEY (`id_alerte`),
  KEY `FKcv3cish7jcgf1u10uacyugl9` (`reparation_id_reparation`),
  KEY `FKdjsk38p5eedcxp2fr0nebu7yq` (`reservation_id_reservation`),
  KEY `FKogx5i37wkixrlmtmpdhd50ebf` (`type_alerte_id_type_alerte`),
  KEY `FKeyiubkgj11sswp9ek39ocosjs` (`utilisateur_id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `alerte`
--

INSERT INTO `alerte` (`id_alerte`, `date_alerte`, `date_traitement_alerte`, `description_alerte`, `statut_alerte`, `reparation_id_reparation`, `reservation_id_reservation`, `type_alerte_id_type_alerte`, `utilisateur_id_utilisateur`) VALUES
(1, '2023-01-10 00:00:00.000000', NULL, 'demande de reservation', 'NonTraite', NULL, 1, 1, 1),
(2, '2023-01-25 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de reservation', 'Traite', NULL, 2, 1, 2),
(3, '2023-01-10 00:00:00.000000', NULL, 'demande de reservation', 'NonTraite', NULL, 1, 1, 1),
(4, '2023-01-14 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de reservation', 'Traite', NULL, 1, 1, 1),
(5, '2023-01-16 00:00:00.000000', NULL, 'demande de reservation', 'NonTraite', NULL, 1, 1, 1),
(6, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de reservation', 'Traite', NULL, 1, 1, 1),
(7, '2023-01-10 00:00:00.000000', NULL, 'demande de reparation', 'NonTraite', NULL, 1, 2, 1),
(8, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de reparation', 'Traite', NULL, 1, 2, 1),
(9, '2023-01-10 00:00:00.000000', NULL, 'demande de reparation', 'NonTraite', NULL, 1, 2, 1),
(10, '2023-01-10 00:00:00.000000', NULL, 'demande de reparation', 'NonTraite', NULL, 1, 2, 1),
(11, '2023-01-25 00:00:00.000000', '2023-01-27 00:00:00.000000', 'signalement', 'Traite', NULL, 2, 3, 2),
(12, '2023-01-10 00:00:00.000000', NULL, 'signalement', 'NonTraite', NULL, 1, 3, 1),
(13, '2023-01-14 00:00:00.000000', '2023-01-27 00:00:00.000000', 'signalement', 'Traite', NULL, 1, 3, 1),
(14, '2023-01-16 00:00:00.000000', NULL, 'signalement', 'NonTraite', NULL, 1, 3, 1),
(15, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'signalement', 'Traite', NULL, 1, 3, 1),
(16, '2023-01-10 00:00:00.000000', NULL, 'signalement', 'NonTraite', NULL, 1, 3, 1),
(17, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'signalement', 'Traite', NULL, 1, 3, 1),
(18, '2023-01-10 00:00:00.000000', NULL, 'demande de retour', 'NonTraite', NULL, 1, 4, 1),
(19, '2023-01-25 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de retour', 'Traite', NULL, 2, 4, 2),
(20, '2023-01-10 00:00:00.000000', NULL, 'demande de retour', 'NonTraite', NULL, 1, 4, 1),
(21, '2023-01-14 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de retour', 'Traite', NULL, 1, 4, 1),
(22, '2023-01-16 00:00:00.000000', NULL, 'demande de retour', 'NonTraite', NULL, 1, 4, 1),
(23, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de prolongation', 'Traite', NULL, 1, 5, 1),
(24, '2023-01-10 00:00:00.000000', NULL, 'demande de prolongation', 'NonTraite', NULL, 1, 5, 1),
(25, '2023-01-10 00:00:00.000000', '2023-01-27 00:00:00.000000', 'demande de prolongation', 'Traite', NULL, 1, 5, 1),
(26, '2023-01-10 00:00:00.000000', NULL, 'demande de prolongation', 'NonTraite', NULL, 1, 5, 1);

-- --------------------------------------------------------

--
-- Structure de la table `documentation`
--

DROP TABLE IF EXISTS `documentation`;
CREATE TABLE IF NOT EXISTS `documentation` (
  `id_documentation` int NOT NULL AUTO_INCREMENT,
  `nom_documentation` varchar(255) DEFAULT NULL,
  `location_id_location` int DEFAULT NULL,
  PRIMARY KEY (`id_documentation`),
  KEY `FKnev3cr2ukb08bk98aa0qpd7l7` (`location_id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `documentation`
--

INSERT INTO `documentation` (`id_documentation`, `nom_documentation`, `location_id_location`) VALUES
(1, 'fichestechniquesOrdinateurportable.pdf', 1),
(2, 'fichestechniquesVideo projecteur.pdf', 2),
(3, 'fichestechniquescasqueVR.pdf', 3);

-- --------------------------------------------------------

--
-- Structure de la table `gestionnaire`
--

DROP TABLE IF EXISTS `gestionnaire`;
CREATE TABLE IF NOT EXISTS `gestionnaire` (
  `id_utilisateur` int NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `localisation`
--

DROP TABLE IF EXISTS `localisation`;
CREATE TABLE IF NOT EXISTS `localisation` (
  `id_localisation` int NOT NULL AUTO_INCREMENT,
  `libelle_localisation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_localisation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `localisation`
--

INSERT INTO `localisation` (`id_localisation`, `libelle_localisation`) VALUES
(1, 'MNS'),
(2, 'IFA');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id_location` int NOT NULL AUTO_INCREMENT,
  `description_location` varchar(255) DEFAULT NULL,
  `etat_location` varchar(255) DEFAULT NULL,
  `nom_location` varchar(255) DEFAULT NULL,
  `num_serie_location` varchar(255) DEFAULT NULL,
  `statut_location` varchar(255) DEFAULT NULL,
  `localisation_id_localisation` int DEFAULT NULL,
  `type_location_id_type_location` int DEFAULT NULL,
  PRIMARY KEY (`id_location`),
  KEY `FK5ks141mg9som3bo1i0bmdkovt` (`localisation_id_localisation`),
  KEY `FK2kni8ibe2ynobsftllkspqwfe` (`type_location_id_type_location`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `location`
--

INSERT INTO `location` (`id_location`, `description_location`, `etat_location`, `nom_location`, `num_serie_location`, `statut_location`, `localisation_id_localisation`, `type_location_id_type_location`) VALUES
(1, 'DEll intel core i5', 'operationnel', 'ordinateur portable', 'VX550', 'reserve', 1, 1),
(2, 'MSI projecteur', 'hors d\'usage', 'Video projecteur', 'VX110', 'dispo', 2, 2),
(3, 'Asus intel core i5', 'neuf', 'Ordinateur portable', 'VX110', 'reparation', 2, 1),
(4, 'DEll intel core i5', 'operationnel', 'ordinateur portable', 'VX550', 'reserve', 1, 1),
(5, 'MSI projecteur', 'hors d\'usage', 'Video projecteur', 'VX110', 'dispo', 2, 2),
(6, 'Salle 104', 'bon', 'Salle', '104', 'dispo', 1, 4),
(7, 'MSI projecteur', 'neuf', 'Video projecteur', 'VX245', 'reserve', 2, 2);

-- --------------------------------------------------------

--
-- Structure de la table `photo`
--

DROP TABLE IF EXISTS `photo`;
CREATE TABLE IF NOT EXISTS `photo` (
  `id_photo` int NOT NULL AUTO_INCREMENT,
  `nom_photo` varchar(255) DEFAULT NULL,
  `location_id_location` int DEFAULT NULL,
  PRIMARY KEY (`id_photo`),
  KEY `FKhbfliysuq6fojnspdf8oum8o3` (`location_id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `photo`
--

INSERT INTO `photo` (`id_photo`, `nom_photo`, `location_id_location`) VALUES
(1, 'lenovo.jpg', 1),
(2, 'lenovo.jpg', 2),
(3, 'lenovo.jpg', 3),
(4, 'lenovo.jpg', 4),
(5, 'lenovo.jpg', 5),
(6, 'lenovo.jpg', 6);

-- --------------------------------------------------------

--
-- Structure de la table `reparation`
--

DROP TABLE IF EXISTS `reparation`;
CREATE TABLE IF NOT EXISTS `reparation` (
  `id_reparation` int NOT NULL AUTO_INCREMENT,
  `date_reception` datetime(6) DEFAULT NULL,
  `date_reparation` datetime(6) DEFAULT NULL,
  `date_retour_previsionnel` datetime(6) DEFAULT NULL,
  `date_retour_reel` datetime(6) DEFAULT NULL,
  `description_panne` varchar(255) DEFAULT NULL,
  `nom_reparation` varchar(255) DEFAULT NULL,
  `gestionnaire_id_utilisateur` int DEFAULT NULL,
  `location_id_location` int DEFAULT NULL,
  PRIMARY KEY (`id_reparation`),
  KEY `FKthgo0lije8tokgd4atm1sjuv5` (`gestionnaire_id_utilisateur`),
  KEY `FK5tf85r3hoecj7r31qd02ktbup` (`location_id_location`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reparation`
--

INSERT INTO `reparation` (`id_reparation`, `date_reception`, `date_reparation`, `date_retour_previsionnel`, `date_retour_reel`, `description_panne`, `nom_reparation`, `gestionnaire_id_utilisateur`, `location_id_location`) VALUES
(1, '2023-06-08 10:00:00.000000', '2023-06-10 14:30:00.000000', '2023-06-15 12:00:00.000000', '2023-06-17 16:45:00.000000', 'Ecran HS', 'Réparation 46sg4zg', NULL, NULL),
(2, '2023-06-09 11:30:00.000000', '2023-06-11 16:45:00.000000', '2023-06-16 10:15:00.000000', '2023-06-18 14:30:00.000000', 'Connecteur Hs', 'Réparation sd85754', NULL, NULL),
(3, '2023-06-10 13:15:00.000000', '2023-06-12 11:00:00.000000', '2023-06-17 09:30:00.000000', NULL, 'Ventilation bruyante', 'Réparation 44dg54g', NULL, NULL),
(4, '2023-06-11 15:45:00.000000', '2023-06-13 09:30:00.000000', '2023-06-18 15:00:00.000000', NULL, 'Ne charge plus', 'Réparation 887444dg', NULL, NULL),
(5, '2023-06-12 09:30:00.000000', '2023-06-14 12:45:00.000000', '2023-06-19 14:30:00.000000', NULL, 'Connecteur Usb hs', 'Réparation 8974616', NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE IF NOT EXISTS `reservation` (
  `id_reservation` int NOT NULL AUTO_INCREMENT,
  `cadre_utilisation` varchar(255) DEFAULT NULL,
  `date_debut_reservation` datetime(6) DEFAULT NULL,
  `date_fin_prevu` datetime(6) DEFAULT NULL,
  `date_retour_reel` datetime(6) DEFAULT NULL,
  `location_id_location` int DEFAULT NULL,
  `utilisateur_id_utilisateur` int DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `FKsme51vko5so8xtly7i99x5w1l` (`location_id_location`),
  KEY `FK763syf6fx07toe3t5kxl1mhqo` (`utilisateur_id_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `cadre_utilisation`, `date_debut_reservation`, `date_fin_prevu`, `date_retour_reel`, `location_id_location`, `utilisateur_id_utilisateur`) VALUES
(1, 'Cours', '2023-01-15 00:00:00.000000', '2023-06-30 00:00:00.000000', NULL, 1, 1),
(2, 'Journée portes ouvertes', '2023-02-02 00:00:00.000000', '2023-02-05 00:00:00.000000', NULL, 3, 1),
(3, 'Réunion', '2023-01-01 00:00:00.000000', '2023-01-03 00:00:00.000000', NULL, 4, 2),
(4, 'Location longue', '2023-09-01 00:00:00.000000', '2025-09-01 00:00:00.000000', NULL, 6, 2),
(5, 'Journée portes ouvertes', '2023-02-02 00:00:00.000000', '2023-02-05 00:00:00.000000', NULL, 7, 5);

-- --------------------------------------------------------

--
-- Structure de la table `type_alerte`
--

DROP TABLE IF EXISTS `type_alerte`;
CREATE TABLE IF NOT EXISTS `type_alerte` (
  `id_type_alerte` int NOT NULL AUTO_INCREMENT,
  `type_alerte` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_alerte`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type_alerte`
--

INSERT INTO `type_alerte` (`id_type_alerte`, `type_alerte`) VALUES
(1, 'reservation'),
(2, 'reparation'),
(3, 'signalement'),
(4, 'demandeRetour'),
(5, 'demandeProlongation');

-- --------------------------------------------------------

--
-- Structure de la table `type_location`
--

DROP TABLE IF EXISTS `type_location`;
CREATE TABLE IF NOT EXISTS `type_location` (
  `id_type_location` int NOT NULL AUTO_INCREMENT,
  `libelle_type_location` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_location`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type_location`
--

INSERT INTO `type_location` (`id_type_location`, `libelle_type_location`) VALUES
(1, 'Ordinateur portable'),
(2, 'Video Projecteur'),
(3, 'Casque VR'),
(4, 'Salle');

-- --------------------------------------------------------

--
-- Structure de la table `type_utilisateur`
--

DROP TABLE IF EXISTS `type_utilisateur`;
CREATE TABLE IF NOT EXISTS `type_utilisateur` (
  `id_type_utilisateur` int NOT NULL AUTO_INCREMENT,
  `role_utilisateur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_type_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `type_utilisateur`
--

INSERT INTO `type_utilisateur` (`id_type_utilisateur`, `role_utilisateur`) VALUES
(1, 'ROLE_SUPERADMIN'),
(2, 'ROLE_GESTIONNAIRE'),
(3, 'ROLE_UTILISATEUR');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int NOT NULL AUTO_INCREMENT,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `mail_utilisateur` varchar(255) DEFAULT NULL,
  `mot_de_passe_utilisateur` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  `prenom_utilisateur` varchar(255) DEFAULT NULL,
  `telephone_utilisateur` varchar(255) DEFAULT NULL,
  `localisation_id_localisation` int DEFAULT NULL,
  `type_utilisateur_id_type_utilisateur` int DEFAULT NULL,
  PRIMARY KEY (`id_utilisateur`),
  KEY `FKthf8nj1f9clcuvqk1665guwn9` (`localisation_id_localisation`),
  KEY `FK5lds2hl7kcp7l5u3nxv06wdw9` (`type_utilisateur_id_type_utilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `adresse_utilisateur`, `mail_utilisateur`, `mot_de_passe_utilisateur`, `nom_utilisateur`, `prenom_utilisateur`, `telephone_utilisateur`, `localisation_id_localisation`, `type_utilisateur_id_type_utilisateur`) VALUES
(1, 'route du creve coeur', 'donia@donia.com', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'zmander', 'donia', '0000000000', 1, 2),
(2, 'rue de verdun', 'walid@walid.com', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'hamoud', 'walid', '0000000000', 2, 2),
(3, 'rue de mns', 'sarah@sarah.com', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'sarah', 'sisi', '0000000000', 1, 3),
(4, 'rue de france', 'lili@lili.com', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'Lili', 'Lolo', '0000000000', 2, 1),
(5, 'rue de verdun', 'farid@farid.com', '$2a$10$wXW2wHA2bu1TdQ26p.2UoehWv8m92w88kabSeL.348VqkpWvSt51q', 'hamoud', 'Farid', '0000000000', 2, 3);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `alerte`
--
ALTER TABLE `alerte`
  ADD CONSTRAINT `FKcv3cish7jcgf1u10uacyugl9` FOREIGN KEY (`reparation_id_reparation`) REFERENCES `reparation` (`id_reparation`),
  ADD CONSTRAINT `FKdjsk38p5eedcxp2fr0nebu7yq` FOREIGN KEY (`reservation_id_reservation`) REFERENCES `reservation` (`id_reservation`),
  ADD CONSTRAINT `FKeyiubkgj11sswp9ek39ocosjs` FOREIGN KEY (`utilisateur_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `FKogx5i37wkixrlmtmpdhd50ebf` FOREIGN KEY (`type_alerte_id_type_alerte`) REFERENCES `type_alerte` (`id_type_alerte`);

--
-- Contraintes pour la table `documentation`
--
ALTER TABLE `documentation`
  ADD CONSTRAINT `FKnev3cr2ukb08bk98aa0qpd7l7` FOREIGN KEY (`location_id_location`) REFERENCES `location` (`id_location`);

--
-- Contraintes pour la table `gestionnaire`
--
ALTER TABLE `gestionnaire`
  ADD CONSTRAINT `FKj5stn9pg39rk0p6jdi7pox1pr` FOREIGN KEY (`id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`);

--
-- Contraintes pour la table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `FK2kni8ibe2ynobsftllkspqwfe` FOREIGN KEY (`type_location_id_type_location`) REFERENCES `type_location` (`id_type_location`),
  ADD CONSTRAINT `FK5ks141mg9som3bo1i0bmdkovt` FOREIGN KEY (`localisation_id_localisation`) REFERENCES `localisation` (`id_localisation`);

--
-- Contraintes pour la table `photo`
--
ALTER TABLE `photo`
  ADD CONSTRAINT `FKhbfliysuq6fojnspdf8oum8o3` FOREIGN KEY (`location_id_location`) REFERENCES `location` (`id_location`);

--
-- Contraintes pour la table `reparation`
--
ALTER TABLE `reparation`
  ADD CONSTRAINT `FK5tf85r3hoecj7r31qd02ktbup` FOREIGN KEY (`location_id_location`) REFERENCES `location` (`id_location`),
  ADD CONSTRAINT `FKthgo0lije8tokgd4atm1sjuv5` FOREIGN KEY (`gestionnaire_id_utilisateur`) REFERENCES `gestionnaire` (`id_utilisateur`);

--
-- Contraintes pour la table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `FK763syf6fx07toe3t5kxl1mhqo` FOREIGN KEY (`utilisateur_id_utilisateur`) REFERENCES `utilisateur` (`id_utilisateur`),
  ADD CONSTRAINT `FKsme51vko5so8xtly7i99x5w1l` FOREIGN KEY (`location_id_location`) REFERENCES `location` (`id_location`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `FK5lds2hl7kcp7l5u3nxv06wdw9` FOREIGN KEY (`type_utilisateur_id_type_utilisateur`) REFERENCES `type_utilisateur` (`id_type_utilisateur`),
  ADD CONSTRAINT `FKthf8nj1f9clcuvqk1665guwn9` FOREIGN KEY (`localisation_id_localisation`) REFERENCES `localisation` (`id_localisation`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
