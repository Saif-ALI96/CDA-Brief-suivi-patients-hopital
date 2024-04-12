package co.suivipatient.presentation.lit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.business.service.lit.LitService;
/**
 * Contrôleur REST pour la mise à jour du statut d'un lit.
 */
@RestController
public class LitControllerPatch {
  
  // Service pour gérer les opérations sur les lits
  private final LitService litService;

  /**
   * Constructeur de la classe LitControllerPatch.
   * 
   * @param litService Le service pour gérer les opérations sur les lits.
   */
  public LitControllerPatch(LitService litService) {
    this.litService = litService;
  }

  /**
   * Met à jour le statut d'un lit avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du lit à mettre à jour.
   * @param litDTO Le DTO contenant le nouveau statut du lit.
   * @return Une réponse HTTP indiquant le succès de la mise à jour.
   */
  @CrossOrigin
  @PatchMapping("/lit/{id}")
  public ResponseEntity<?> updateLitStatus(@PathVariable("id") Long id, @RequestBody LitDTO litDTO) {
    try {
      litService.updateStatus(id, litDTO.getStatus());
      return ResponseEntity.ok().build();
    } catch (IllegalArgumentException e) {
      // Ce bloc catch est spécifique et doit venir en premier.
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (RuntimeException e) {
      // RuntimeException est plus générique et peut capturer tout autre RuntimeException non capturé ci-dessus.
      return ResponseEntity.notFound().build();
    }
  }
}

