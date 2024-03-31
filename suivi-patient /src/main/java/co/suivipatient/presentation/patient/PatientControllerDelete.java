package co.suivipatient.presentation.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.service.patient.PatientService;


/**
 * Contrôleur REST pour la suppression de patients dans l'application.
 * Fournit un point de terminaison pour supprimer un patient existant par son identifiant.
 */
@RestController
public class PatientControllerDelete {
  
  private final PatientService patientService;

  /**
   * Injecte le service de gestion des patients nécessaire pour effectuer la suppression.
   * 
   * @param patientService Le service de gestion des patients.
   */
  @Autowired
  public PatientControllerDelete(PatientService patientService) {
    this.patientService = patientService;
  }

  /**
   * Supprime un patient spécifié par son identifiant.
   * Ce point de terminaison utilise l'annotation {@code @DeleteMapping} pour indiquer
   * qu'il s'agit d'une opération HTTP DELETE. L'identifiant du patient est passé dans l'URL.
   * 
   * @param id L'identifiant du patient à supprimer.
   */
  @CrossOrigin // Permet les requêtes cross-origin à ce point de terminaison.
  @DeleteMapping("/patient/{id}")
  public void deletePatient(@PathVariable("id") Long id) {
    patientService.supprimer(id);
  }
}