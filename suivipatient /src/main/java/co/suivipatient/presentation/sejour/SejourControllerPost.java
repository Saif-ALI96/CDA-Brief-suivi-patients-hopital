package co.suivipatient.presentation.sejour;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.SejourDTO;
import co.suivipatient.business.service.sejour.SejourService;

/**
 * Contrôleur REST pour la création et la mise à jour des dates d'arrivée et de sortie d'un séjour.
 */
@RestController
public class SejourControllerPost {
  
  // Service pour gérer les opérations sur les séjours
  private final SejourService sejourService;

  /**
   * Constructeur de la classe SejourControllerPost.
   * 
   * @param sejourService Le service pour gérer les opérations sur les séjours.
   */
  @Autowired
  public SejourControllerPost(SejourService sejourService) { 
    this.sejourService = sejourService; 
  }

  /**
   * Enregistre la date d'arrivée pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param sejourDTO Le DTO contenant la date d'arrivée à enregistrer.
   * @return Une ResponseEntity contenant le DTO du séjour avec la date d'arrivée enregistrée.
   */
  @CrossOrigin
  @PostMapping("/sejour/DateArrive/{id}")
  public ResponseEntity<SejourDTO> enregistrerDateArrive(@PathVariable long id,  @RequestBody SejourDTO sejourDTO) {
    try {
      Date date = sejourDTO.getDateArrive();
      SejourDTO sejourEnregistre = sejourService.enregistrerDateArrive(id, date);
      return ResponseEntity.ok(sejourEnregistre);
    } catch (Exception e) {
      // Gérer l'erreur de format de date invalide
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    } 
  }

  /**
   * Enregistre la date de sortie pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param sejourDTO Le DTO contenant la date de sortie à enregistrer.
   * @return Une ResponseEntity contenant le DTO du séjour avec la date de sortie enregistrée.
   */
  @CrossOrigin
  @PostMapping("/sejour/updateDateSortie/{id}")
  public ResponseEntity<SejourDTO> enregistrerDateSortie(@PathVariable long id, @RequestBody SejourDTO sejourDTO) {
    try {
      // Convertir la date de sortie de SejourDTO en Date
      Date dateSortie = sejourDTO.getDateSortie();

      // Appeler le service pour enregistrer la date de sortie
      SejourDTO sejourSortieEnregistre = sejourService.enregistrerDateSortie(id, dateSortie);
      return ResponseEntity.ok(sejourSortieEnregistre);
    } catch (Exception e) {
      // Gérer les exceptions
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }
}