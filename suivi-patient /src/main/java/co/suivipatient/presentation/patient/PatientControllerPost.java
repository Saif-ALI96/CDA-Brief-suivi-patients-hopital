package co.suivipatient.presentation.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.business.service.patient.PatientService;

/**
 * Contrôleur REST pour les opérations de création de patients dans le système.
 * Permet aux clients de l'API de soumettre de nouveaux patients pour enregistrement.
 */
@RestController
public class PatientControllerPost {

  private final PatientService patientService;

  /**
   * Construit le contrôleur en injectant le service nécessaire pour la gestion des patients.
   * 
   * @param patientService Le service de gestion des patients injecté via Spring.
   */
  @Autowired
  public PatientControllerPost(PatientService patientService) {
    this.patientService = patientService;
  }

  /**
   * Crée un nouveau patient dans le système.
   * Ce point de terminaison accepte un objet PatientDTO dans le corps de la requête
   * et retourne le PatientDTO du patient nouvellement créé, incluant son identifiant unique généré.
   * 
   * @param patientDTO L'objet PatientDTO représentant les données du patient à créer.
   * @return Le PatientDTO du patient nouvellement créé avec son identifiant.
   */
  @CrossOrigin // Permet les requêtes cross-origin pour ce point de terminaison.
  @PostMapping("/patient")
  public PatientDTO creeNouveauPatient(@RequestBody PatientDTO patientDTO) {
    return patientService.creer(patientDTO);
  }
  
}
