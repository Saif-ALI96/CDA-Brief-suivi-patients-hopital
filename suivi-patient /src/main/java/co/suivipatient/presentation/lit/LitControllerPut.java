package co.suivipatient.presentation.lit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.business.service.lit.LitService;

/**
 * Contrôleur REST pour la mise à jour des informations sur un lit.
 */
@RestController
public class LitControllerPut {

  // Service pour gérer les opérations sur les lits
  private final LitService litService;

  /**
   * Constructeur de la classe LitControllerPut.
   * 
   * @param litService Le service pour gérer les opérations sur les lits.
   */
  @Autowired
  public LitControllerPut(final LitService litService) {
    this.litService = litService;
  }

  /**
   * Met à jour les informations sur un lit avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du lit à mettre à jour.
   * @param litDTO Le DTO contenant les nouvelles informations sur le lit.
   */
  @CrossOrigin
  @PutMapping("/lit/{id}")
  public void updateLit(@PathVariable("id") Long id, @RequestBody LitDTO litDTO) {
    litService.updateStatus(litDTO.getLitId(), litDTO.getStatus());
  }
}
  
  



// cyril.marcq@gmail.com