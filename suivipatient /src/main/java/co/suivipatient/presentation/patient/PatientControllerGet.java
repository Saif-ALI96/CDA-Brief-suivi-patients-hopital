package co.suivipatient.presentation.patient;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.business.service.patient.PatientService;

/**
 * Contrôleur REST pour la gestion des patients.
 * Fournit des points de terminaison pour récupérer des informations sur les patients,
 * permettant les opérations de lecture comme lister tous les patients et obtenir un patient par son identifiant.
 */
@RestController
public class PatientControllerGet {

  private final PatientService patientService;

  /**
   * Construit le contrôleur avec le service des patients injecté.
   * 
   * @param patientService Le service des patients à injecter.
   */
  @Autowired
  public PatientControllerGet(PatientService patientService) {
    this.patientService = patientService;
  }
  
  /**
   * Récupère et retourne la liste de tous les patients.
   * 
   * @return Une liste de {@link PatientDTO} représentant tous les patients.
   */
  @CrossOrigin // Permet les requêtes cross-origin pour ce point de terminaison.
  @GetMapping("/patient")
  public List<PatientDTO> listPatientsDTO() {
    return patientService.lire();
  }

  /**
   * Récupère un patient spécifique par son identifiant.
   * 
   * @param id L'identifiant du patient à récupérer.
   * @return {@link PatientDTO} L'objet DTO du patient demandé.
   */
  @GetMapping("/patients/{id}")
  public PatientDTO getPatientById(@PathVariable("id") Long id) {
    return patientService.lirPatientDTO(id);
  }
}
