package co.suivipatient.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.suivipatient.persistance.entity.Chambre;

/**
 * Repository pour les opérations CRUD sur les entités Chambre.
 * Étend JpaRepository pour fournir des méthodes de persistance standardisées pour l'entité Chambre.
 * 
 * Spring Data JPA implémente automatiquement les méthodes définies par JpaRepository,
 * simplifiant ainsi les interactions avec la base de données pour les opérations courantes.
 */
public interface ChambreRepo extends JpaRepository<Chambre, Long> {
  // Des méthodes personnalisées peuvent être ajoutées ici si nécessaire.
}