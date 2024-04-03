package co.suivipatient.business.service.sejour;

import java.util.Date;
import java.util.List;

import co.suivipatient.business.dto.SejourDTO;

/**
 * Interface définissant les opérations de service pour gérer les séjours dans l'application.
 */
public interface SejourService {

  /**
   * Enregistre la date d'arrivée pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param dateArrivee La date d'arrivée à enregistrer.
   * @return Le DTO du séjour avec la date d'arrivée mise à jour.
   */
  SejourDTO enregistrerDateArrive(long id, Date dateArrivee);
  
  /**
   * Enregistre la date de sortie pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param dateSortie La date de sortie à enregistrer.
   * @return Le DTO du séjour avec la date de sortie mise à jour.
   */
  SejourDTO enregistrerDateSortie(long id, Date dateSortie);
  
  /**
   * Récupère la liste de tous les séjours enregistrés dans l'application.
   * 
   * @return Une liste de SejourDTO contenant les informations sur les séjours.
   */
  List<SejourDTO> afficherSejour();

  /**
   * Récupère les informations d'un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour à récupérer.
   * @return Un SejourDTO contenant les informations sur le séjour.
   */
  SejourDTO afficherSejourId(long id);
}
