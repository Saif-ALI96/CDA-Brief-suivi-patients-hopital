package co.suivipatient.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.suivipatient.persistance.entity.Sejour;

/**
 * Interface JpaRepository pour l'accès aux données des séjours.
 * Cette interface permet d'interagir avec la base de données pour la gestion des séjours.
 */
public interface SejourRepo extends JpaRepository<Sejour, Long> {
  
}
