package co.suivipatient.business.service.patient;

import java.util.List;
import co.suivipatient.business.dto.PatientDTO;

/**
 * Interface PatientService définit les méthodes de service pour l'entité Patient.
 * Elle spécifie les opérations que l'on peut effectuer sur un patient dans l'application,
 * y compris la création, la lecture, la modification et la suppression des patients.
 */
public interface PatientService {
  
  /**
   * Crée un nouveau patient dans le système.
   * 
   * @param patient L'objet PatientDTO contenant les informations du patient à créer.
   * @return Le PatientDTO du patient créé, y compris son identifiant unique généré.
   */
  PatientDTO creer(PatientDTO patient);

  /**
   * Récupère une liste de tous les patients dans le système.
   * 
   * @return Une liste de PatientDTO pour tous les patients.
   */
  List<PatientDTO> lire();

  /**
   * Récupère un patient spécifique par son identifiant.
   * 
   * @param id L'identifiant unique du patient à retrouver.
   * @return Le PatientDTO correspondant au patient demandé.
   */
  PatientDTO lirPatientDTO(long id);

  /**
   * Modifie les informations d'un patient existant.
   * 
   * @param id L'identifiant du patient à modifier.
   * @param patient Les nouvelles informations du patient sous forme de PatientDTO.
   * @return Le PatientDTO mis à jour du patient.
   */
  PatientDTO modifier(long id, PatientDTO patient);
  
  /**
   * Supprime un patient du système.
   * 
   * @param id L'identifiant du patient à supprimer.
   */
  void supprimer(long id);
}
