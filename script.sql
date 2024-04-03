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
	date_sortie DATE,
	patient_id INT,
	lit_id INT,
	servicee VARCHAR(100),
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
('Dupont', 'Jean', 'M', '1985-05-15'),
('Tremblay', 'Marie', 'F', '1990-12-20'),
('Smith', 'John', 'M', '1978-08-10'),
('Dubois', 'Sophie', 'F', '1982-03-25'),
('Nguyen', 'Minh', 'M', '1995-06-03'),
('Garcia', 'Maria', 'F', '1970-11-12'),
('Patel', 'Rajesh', 'M', '1988-09-28'),
('Leroy', 'Anne', 'F', '1975-04-17'),
('Kim', 'Minji', 'F', '1993-02-08'),
('Santos', 'João', 'M', '1980-07-19');



-- Table Chambre
INSERT INTO Chambre (numero_de_chambre, nombre_de_lits) VALUES
(101, 2),
(102, 1),
(103, 3),
(104, 2),
(105, 1),
(106, 2),
(107, 3),
(108, 1),
(109, 2),
(110, 3);



-- Table Lit 
-- Supposons que TRUE représente un lit disponible et FALSE un lit occupé
INSERT INTO Lit (status, chambre_id) VALUES
(true, 1),
(false, 1),
(true, 2),
(true, 3),
(true, 3),
(false, 3),
(false, 4),
(true, 5),
(true, 6),
(false, 6);

-- Table Sejour 
-- Les dates d'arrivée et de sortie sont formatées en 'AAAA-MM-JJ'

INSERT INTO Sejour (date_arrive, patient_id, lit_id, servicee) VALUES
('2024-03-10', 1, 1, 'urgence'),
('2024-03-15', 3, 3, 'pédiatrie'),
('2024-03-20', 5, 4, 'chirurgie'),
('2024-03-25', 2, 8, 'urgence'),
('2024-03-28', 7, 9, 'pédiatrie'),
('2024-04-02', 4, 2, 'chirurgie'),
('2024-04-05', 10, 7, 'urgence'),
('2024-04-08', 8, 10, 'pédiatrie'),
('2024-04-12', 6, 5, 'chirurgie'),
('2024-04-16',  9, 6, 'urgence');



