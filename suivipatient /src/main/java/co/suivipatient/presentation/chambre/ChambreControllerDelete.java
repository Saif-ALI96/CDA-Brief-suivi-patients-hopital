package co.suivipatient.presentation.chambre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import co.suivipatient.business.service.chambre.ChambreService;

/**
 * Contrôleur REST pour la suppression de chambres dans l'application.
 * Permet de supprimer une chambre spécifiée par son identifiant via une requête HTTP DELETE.
 */
@RestController
public class ChambreControllerDelete {
  
  private final ChambreService chambreService;

  /**
   * Construit le contrôleur avec le service de gestion des chambres injecté.
   * 
   * @param chambreService Le service de gestion des chambres.
   */
  @Autowired
  public ChambreControllerDelete(ChambreService chambreService) {
    this.chambreService = chambreService;
  }

  /**
   * Supprime une chambre de l'application en utilisant son identifiant.
   * 
   * @param id L'identifiant de la chambre à supprimer.
   */
  @CrossOrigin
  @DeleteMapping("/chambre/{id}")
  public void deleteById(@PathVariable("id") long id) {
    chambreService.supprimer(id);
  }
}
