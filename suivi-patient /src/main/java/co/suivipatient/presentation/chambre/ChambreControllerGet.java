package co.suivipatient.presentation.chambre;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.business.service.chambre.ChambreService;

/**
 * Contrôleur REST pour la gestion des chambres.
 * Fournit des points de terminaison pour accéder aux informations sur les chambres,
 * permettant de lister toutes les chambres ou de récupérer une chambre spécifique par son identifiant.
 */
@RestController
public class ChambreControllerGet {
  
  private final ChambreService chambreService;

  /**
   * Injecte le service de gestion des chambres.
   * 
   * @param chambreService Le service pour les opérations liées aux chambres.
   */
  @Autowired
  public ChambreControllerGet(ChambreService chambreService) {
    this.chambreService = chambreService;
  }

  /**
   * Récupère la liste de toutes les chambres disponibles.
   * 
   * @return Une liste de {@link ChambreDTO} représentant les chambres.
   */
  @CrossOrigin
  @GetMapping("/chambre")
  public List<ChambreDTO> getAll() {
    return chambreService.lister();
  }

  /**
   * Récupère une chambre spécifique par son identifiant.
   * 
   * @param id L'identifiant de la chambre à récupérer.
   * @return {@link ChambreDTO} La chambre correspondante à l'identifiant fourni.
   */
  @GetMapping("/chambre/{id}")
  public ChambreDTO getById(@PathVariable("id") long id) {
    return chambreService.liChambreDTO(id);
  }
}
