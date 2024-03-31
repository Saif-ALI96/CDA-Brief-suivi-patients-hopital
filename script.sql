create table if not exists Patient(
	patient_id SERIAL,
	nom VARCHAR(50) not null,
	prenom VARCHAR(50) not null,
	sexe VARCHAR(50) not null,
	date_de_naissance DATE not null,
	primary key(patient_id)

);

create table if not exists Chambre(
	chambre_id SERIAL,
  	numero_de_chambre INT,
  	nombre_de_lits INT,
  	primary key(chambre_id)
);

create table if not exists Lit(
	lit_id SERIAL,
  	status BOOLEAN,
  	chambre_id INT,
  	primary key(lit_id),
  	constraint fk_chambre_lit
  		foreign key(chambre_id)
  		references Chambre(chambre_id)
);

create table if not exists Sejour(
	sejour_id SERIAL,
	date_arrive DATE not null,
	date_sortie DATE not null,
	patient_id INT,
	lit_id INT,
	primary key  (sejour_id),
	constraint fk_patient_sejour 
		foreign key(patient_id) 
		references Patient(patient_id),
	constraint fk_lit_sejour 
		foreign key(lit_id) 
		references Lit(lit_id)
);



-- Table Patient 
INSERT INTO Patient (nom, prenom, sexe, date_de_naissance) VALUES
('Dupont', 'Jean', 'Masculin', '1985-04-12'),
('Leroy', 'Marie', 'Féminin', '1992-08-23'),
('Martin', 'Alexandre', 'Masculin', '1976-01-17'),
('Moreau', 'Chloé', 'Féminin', '2000-05-05'),
('Petit', 'Lucas', 'Masculin', '1988-12-30');


-- Table Chambre
INSERT INTO Chambre (numero_de_chambre, nombre_de_lits) VALUES
(101, 2),
(102, 1),
(201, 3),
(202, 2);


-- Table Lit 
-- Supposons que TRUE représente un lit disponible et FALSE un lit occupé
INSERT INTO Lit (status, chambre_id) VALUES
(TRUE, 1),
(FALSE, 1),
(TRUE, 2),
(FALSE, 2),
(TRUE, 3),
(FALSE, 3),
(TRUE, 4),
(FALSE, 4);

-- Table Sejour 
-- Les dates d'arrivée et de sortie sont formatées en 'AAAA-MM-JJ'
INSERT INTO Sejour (date_arrive, date_sortie, patient_id, lit_id) VALUES
('2024-03-01', '2024-03-15', 1, 1),
('2024-03-05', '2024-03-20', 2, 3),
('2024-03-10', '2024-03-25', 3, 5),
('2024-03-12', '2024-03-18', 4, 7);



