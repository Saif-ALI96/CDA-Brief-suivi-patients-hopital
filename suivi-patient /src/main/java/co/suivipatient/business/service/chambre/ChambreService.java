package co.suivipatient.business.service.chambre;

import java.util.List;
import co.suivipatient.business.dto.ChambreDTO;

/**
 * Interface pour le service de gestion des chambres.
 * Définit les opérations nécessaires pour la manipulation des informations de chambre
 * au sein de l'application, en utilisant des objets de transfert de données (DTO) pour représenter ces chambres.
 */
public interface ChambreService {
  
  /**
   * Crée une nouvelle chambre dans le système.
   * 
   * @param chambre L'objet ChambreDTO contenant les informations de la chambre à créer.
   * @return Le ChambreDTO de la chambre nouvellement créée, incluant son identifiant.
   */
  ChambreDTO creer(ChambreDTO chambre);

  /**
   * Liste toutes les chambres disponibles dans le système.
   * 
   * @return Une liste de ChambreDTO représentant toutes les chambres.
   */
  List<ChambreDTO> lister();

  /**
   * Récupère les informations d'une chambre spécifique par son identifiant.
   * 
   * @param id L'identifiant unique de la chambre à retrouver.
   * @return Le ChambreDTO correspondant à la chambre demandée.
   */
  ChambreDTO liChambreDTO(long id);

  /**
   * Modifie les informations d'une chambre existante.
   * 
   * @param chambre Le ChambreDTO contenant les nouvelles informations de la chambre.
   * @param id L'identifiant de la chambre à modifier.
   * @return Le ChambreDTO mis à jour de la chambre.
   */
  ChambreDTO modifiChambreDTO(ChambreDTO chambre, long id);

  /**
   * Supprime une chambre du système par son identifiant.
   * 
   * @param id L'identifiant de la chambre à supprimer.
   */
  void supprimer(long id);

}
