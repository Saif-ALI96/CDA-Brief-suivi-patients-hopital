package co.suivipatient.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import co.suivipatient.persistance.entity.Lit;

/**
 * Interface pour le repository de l'entité Lit.
 * Hérite de JpaRepository pour fournir des opérations CRUD sur les entités Lit.
 * Permet l'interaction avec la base de données pour les opérations concernant les lits.
 * 
 * Utilisez cette interface pour définir des méthodes spécifiques à la recherche, à la récupération,
 * ou à la manipulation des données des entités Lit non couvertes par les méthodes par défaut de JpaRepository.
 */
public interface LitRepo extends JpaRepository<Lit, Long> {

}
