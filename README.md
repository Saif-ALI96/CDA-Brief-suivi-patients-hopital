# Gestion des Séjours des Patients

## Concept du Projet

Ce projet concerne le développement d'une application pour la gestion des séjours des patients dans un établissement de santé. Le système permet d'ajouter et de modifier des informations patient, de gérer l'arrivée et la sortie des services, et d'attribuer des lits aux patients.

Le projet est hébergé sur GitHub et peut être consulté à l'adresse suivante : [Projet Gestion des Séjours des Patients](https://github.com/Saif-ALI96/CDA-Brief-suivi-patients-hopital).

## Configuration de l'Environnement

### Prérequis

- Docker
- PostgreSQL
- Java avec Spring Boot
- Eclipse et Visual Studio Code
- Figma pour la conception MERISE
- draw.io pour la conception UML
- Trello pour la gestion des tâches

### Installation

1. Cloner le dépôt du projet.
2. Installer Docker et démarrer le service PostgreSQL.
3. Configurer les variables d'environnement pour la base de données.
4. Ouvrir le projet dans Eclipse ou Visual Studio Code.

## Règles de Gestion

### Patients

- Ajouter un nouveau patient en précisant son nom, prénom, sexe et date de naissance.
- Modifier les informations d'un patient existant.

### Séjours

- Enregistrer l'arrivée d'un patient en spécifiant la date d'arrivée et le service concerné.
- Enregistrer la sortie d'un patient avec la date de sortie.

### Chambres et Lits

- Un lit est attribué à un patient pendant un séjour et appartient à une chambre.
- Un lit ne peut être attribué qu'à un seul patient à la fois.
- Une chambre peut contenir plusieurs lits.

### Contraintes SQL

- Afficher les noms et prénoms de tous les patients affectés au service "Urgences".

```sql

select nom , prenom from patient p
inner join sejour s on p.patient_id = s.sejour_id
where servicee = 'urgence' ;
```

- Afficher tous les lits actuellement libres.

```sql
 select * from lit l
 where status = true;
```

## Architecture

Le projet adopte une architecture multi-couches comprenant :

- Une couche de présentation pour l'interaction avec l'utilisateur.
- Une couche métier pour la logique de gestion des séjours des patients.
- Une couche d'accès aux données pour la communication avec la base de données PostgreSQL.

## Tests

### Tests Unitaires

- Effectuer au moins un test unitaire pour valider la logique d'affaires.

### Tests d'Intégration

- Réaliser un test d'intégration pour assurer la communication entre les différentes couches de l'application.

---

### _Contributeur_

### Saif Ali

<a href="https://github.com/Saif-ALI96"><img src="https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white"></img></a>
<a href="https://www.linkedin.com/in/saif-ali-86243a279/"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"></img></a>
<a href="https://www.codewars.com/users/Saif-96"><img src="https://img.shields.io/badge/Codewars-B1361E?style=for-the-badge&logo=Codewars&logoColor=white"></img></a>

---
