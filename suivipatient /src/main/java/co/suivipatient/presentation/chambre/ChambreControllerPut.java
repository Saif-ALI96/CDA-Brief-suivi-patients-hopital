package co.suivipatient.presentation.chambre;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.business.service.chambre.ChambreService;

@RestController
public class ChambreControllerPut {
 
  // Service pour gérer les opérations sur les chambres
  private final ChambreService chambreService;
  
  /**
   * Constructeur de la classe ChambreControllerPut.
   * 
   * @param chambreService Le service pour gérer les opérations sur les chambres.
   */
  public ChambreControllerPut(ChambreService chambreService) {
    this.chambreService = chambreService;
  }

  /**
   * Met à jour les informations d'une chambre avec l'identifiant spécifié.
   * 
   * @param id L'identifiant de la chambre à mettre à jour.
   * @param chambreDto Les nouvelles informations de la chambre.
   * @return Une réponse HTTP indiquant le succès de la mise à jour.
   */
  @CrossOrigin
  @PutMapping("/chambre/{id}")
  public ResponseEntity<Void> updateChambre(@PathVariable("id") Long id, @RequestBody ChambreDTO chambreDto) {
    chambreService.modifiChambreDTO(chambreDto, id);
    return ResponseEntity.noContent().build();
  }
}
