package co.suivipatient.presentation.chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.business.service.chambre.ChambreService;

/**
 * Contrôleur REST pour créer de nouvelles chambres dans l'application.
 * Fournit un point de terminaison pour soumettre des données de chambre via des requêtes POST.
 */
@RestController
public class ChambreControllerPost {
  
  private final ChambreService chambreService;

  /**
   * Constructeur pour l'injection de dépendance du service des chambres.
   * 
   * @param chambreService Le service de gestion des chambres.
   */
  @Autowired
  public ChambreControllerPost(ChambreService chambreService) {
    this.chambreService = chambreService;
  }
  
  /**
   * Crée une nouvelle chambre dans le système à partir des données fournies.
   * Accepte un objet ChambreDTO dans le corps de la requête représentant la chambre à créer.
   * 
   * @param chambreDTO Les données de la nouvelle chambre à créer.
   * @return ChambreDTO L'objet ChambreDTO de la chambre nouvellement créée, y compris son identifiant généré.
   */
  @CrossOrigin
  @PostMapping("/chambre")
  public ChambreDTO ajouterUneNouvelleChambre(@RequestBody ChambreDTO chambreDTO) {
    return chambreService.creer(chambreDTO);
  }
}
