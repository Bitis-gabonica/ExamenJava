﻿# Script pour remplir la base de donnee
-- Création des niveaux
INSERT INTO niveau (nom) VALUES ('L1');
INSERT INTO niveau (nom) VALUES ('L2');
INSERT INTO niveau (nom) VALUES ('L3');

-- Ajouter une colonne 'nom' à la table 'classe'
ALTER TABLE classe ADD COLUMN nom VARCHAR(255) NOT NULL;

-- Insérer des classes avec des noms
INSERT INTO classe (niveau_id, nom) VALUES (1, 'Classe A'); -- Lien avec le niveau L1
INSERT INTO classe (niveau_id, nom) VALUES (2, 'Classe B'); -- Lien avec le niveau L2
INSERT INTO classe (niveau_id, nom) VALUES (3, 'Classe C'); -- Lien avec le niveau L3

-- Insérer des professeurs
INSERT INTO professeur (nom) VALUES ('Dr. Dupont');
INSERT INTO professeur (nom) VALUES ('Mme. Lefevre');
INSERT INTO professeur (nom) VALUES ('Mr. Martin');

-- Insérer des cours
INSERT INTO cours (module, professeur_id, niveau_id) VALUES ('Java', 1, 1); -- Cours de Java par Dr. Dupont pour L1
INSERT INTO cours (module, professeur_id, niveau_id) VALUES ('Java', 2, 2); -- Cours de Java par Mme. Lefevre pour L2
INSERT INTO cours (module, professeur_id, niveau_id) VALUES ('Java', 3, 3); -- Cours de Java par Mr. Martin pour L3

-- Insérer des étudiants
INSERT INTO etudiant (nom_complet, classe_id, niveau_id) VALUES ('Alice Durand', 1, 1); -- Étudiant en Classe A, L1
INSERT INTO etudiant (nom_complet, classe_id, niveau_id) VALUES ('Bob Charpentier', 2, 2); -- Étudiant en Classe B, L2
INSERT INTO etudiant (nom_complet, classe_id, niveau_id) VALUES ('Charlie Bernard', 3, 3); -- Étudiant en Classe C, L3

-- Insérer des sessions pour les cours
INSERT INTO session (date, start_time, end_time, location, cours_id) VALUES ('2024-01-10', '08:00:00', '10:00:00', 'Salle 101', 1);
INSERT INTO session (date, start_time, end_time, location, cours_id) VALUES ('2024-01-11', '10:00:00', '12:00:00', 'Salle 202', 2);
INSERT INTO session (date, start_time, end_time, location, cours_id) VALUES ('2024-01-12', '14:00:00', '16:00:00', 'En ligne', 3);

 
