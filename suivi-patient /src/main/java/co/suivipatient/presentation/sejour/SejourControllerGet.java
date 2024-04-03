package co.suivipatient.presentation.sejour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.SejourDTO;
import co.suivipatient.business.service.sejour.SejourService;

/**
 * Contrôleur REST pour la récupération des informations sur les séjours.
 */
@RestController
public class SejourControllerGet {

  // Service pour gérer les opérations sur les séjours
  private final SejourService sejourService;
  
  /**
   * Constructeur de la classe SejourControllerGet.
   * 
   * @param sejourService Le service pour gérer les opérations sur les séjours.
   */
  @Autowired
  public SejourControllerGet(SejourService sejourService) {
    this.sejourService = sejourService;
  }

  /**
   * Récupère toutes les informations sur les séjours.
   * 
   * @return Une ResponseEntity contenant une liste de SejourDTO contenant les informations sur les séjours.
   */
  @CrossOrigin
  @GetMapping("/sejour")
  public ResponseEntity<List<SejourDTO>> afficherSejour() {
    List<SejourDTO> sejourDTOs = sejourService.afficherSejour();
    return ResponseEntity.ok(sejourDTOs);
  }

  /**
   * Récupère les informations sur le séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour à récupérer.
   * @return Une ResponseEntity contenant un SejourDTO contenant les informations sur le séjour.
   */
  @CrossOrigin
  @GetMapping("/sejour/{id}")
  public ResponseEntity<SejourDTO> afficherSejourId(@PathVariable long id) {
    SejourDTO sejourDTO = sejourService.afficherSejourId(id);
    return ResponseEntity.ok(sejourDTO);
  }
}
