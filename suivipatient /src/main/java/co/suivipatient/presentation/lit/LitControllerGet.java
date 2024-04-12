package co.suivipatient.presentation.lit;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.business.service.lit.LitService;

/**
 * Contrôleur REST pour la récupération des informations sur les lits.
 */
@RestController
public class LitControllerGet {
  
  // Service pour gérer les opérations sur les lits
  private final LitService litService;

  /**
   * Constructeur de la classe LitControllerGet.
   * 
   * @param litService Le service pour gérer les opérations sur les lits.
   */
  public LitControllerGet(LitService litService) {
    this.litService = litService;
  } 
  
  /**
   * Récupère toutes les informations sur les lits.
   * 
   * @return Une liste de LitDTO contenant les informations sur les lits.
   */
  @CrossOrigin
  @GetMapping("/lit")
  public List<LitDTO> getAllLits() {
    try {
      return litService.afficherLits();
    } catch (Exception ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors de la récupération des lits.", ex);
    }
  }

  /**
   * Récupère les informations sur le lit avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du lit à récupérer.
   * @return Un LitDTO contenant les informations sur le lit.
   */
  @CrossOrigin
  @GetMapping("/lit/{id}")
  public LitDTO getLitById(@PathVariable Long id) {
    try {
      return litService.afficherLitId(id);
    } catch (ResponseStatusException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Une erreur s'est produite lors de la récupération du lit.", ex);
    }
  }
}