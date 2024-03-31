package co.suivipatient.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.suivipatient.persistance.entity.Patient;

/**
 * Interface PatientRepo qui étend JpaRepository pour fournir des opérations de base de données
 * automatiques pour les entités Patient sans nécessiter d'implémentations spécifiques.
 * 
 * Spring Data JPA génère une implémentation concrète au moment de l'exécution, permettant ainsi
 * d'effectuer des opérations CRUD sur les objets Patient, ainsi que de pouvoir étendre cette interface
 * avec des méthodes personnalisées si nécessaire.
 */
public interface PatientRepo extends  JpaRepository<Patient, Long> {
  
}
