package co.suivipatient.presentation.patient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.business.service.patient.PatientService;


/**
 * Contrôleur REST pour la mise à jour des informations des patients.
 * Permet aux clients de l'API de mettre à jour les détails d'un patient spécifique en fournissant
 * son identifiant et les nouvelles données à appliquer.
 */
@RestController
public class PatientControllerPut {

  private final PatientService patientService;

  /**
   * Initialise le contrôleur avec le service des patients nécessaire pour effectuer la mise à jour.
   * 
   * @param patientService Le service de gestion des patients injecté via Spring.
   */
  @Autowired
  public PatientControllerPut(PatientService patientService) {
    this.patientService = patientService;
  }

  /**
   * Met à jour les informations d'un patient existant.
   * Utilise un identifiant de patient pour localiser le patient dans la base de données et applique
   * les mises à jour fournies via un objet PatientDTO.
   * 
   * @param id L'identifiant du patient à mettre à jour.
   * @param dto Les nouvelles informations du patient sous forme d'objet PatientDTO.
   * @return Le PatientDTO mis à jour, reflétant les changements appliqués.
   */
  @CrossOrigin // Permet les requêtes cross-origin pour ce point de terminaison.
  @PutMapping("/patients/{id}")
  public PatientDTO updatePatient(@PathVariable("id") Long id, @RequestBody PatientDTO dto) {
    return patientService.modifier(id, dto);
  } 
}
