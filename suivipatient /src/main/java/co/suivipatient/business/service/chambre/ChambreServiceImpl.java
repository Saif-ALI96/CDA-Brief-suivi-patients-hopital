package co.suivipatient.business.service.chambre;

import java.util.List;
import java.util.Optional;

import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import co.suivipatient.business.convert.ChambreConvert;
import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.persistance.entity.Chambre;
import co.suivipatient.persistance.repository.ChambreRepo;

/**
 * Service pour gérer les chambres dans l'application.
 * Offre des fonctionnalités pour créer, lister, récupérer, modifier et supprimer des chambres,
 * en s'appuyant sur le repository ChambreRepo pour interagir avec la base de données.
 */

@Service
public class ChambreServiceImpl implements ChambreService {

  // Repository pour l'accès aux données des chambres
  private ChambreRepo chambreRepository;
  
  /**
   * Constructeur de la classe ChambreServiceImpl.
   * 
   * @param chambreRepository Le repository pour l'accès aux données des chambres.
   */
  public ChambreServiceImpl(ChambreRepo chambreRepository) {
    this.chambreRepository = chambreRepository;
  }

  /**
   * Crée une nouvelle chambre avec les informations spécifiées.
   * 
   * @param chambre Les informations de la chambre à créer.
   * @return Le DTO de la chambre créée.
   */
  @Override
  public ChambreDTO creer(ChambreDTO chambre) {
    Chambre chambreEntity = ChambreConvert.getInstance().convertChambreDtoToEntity(chambre);

    Chambre conserveEntity = chambreRepository.save(chambreEntity);

    return ChambreConvert.getInstance().convertEntityToChambreDto(conserveEntity);
  }

  /**
   * Récupère la liste de toutes les chambres disponibles.
   * 
   * @return Une liste de ChambreDTO contenant les informations sur les chambres.
   */
  @Override
  public List<ChambreDTO> lister() {
    List<Chambre> listeEntitees = chambreRepository.findAll();
    
    return ChambreConvert.getInstance().convertListEntitiesToListDTOs(listeEntitees);
  }
  

  /**
   * Récupère les informations d'une chambre avec l'identifiant spécifié.
   * 
   * @param id L'identifiant de la chambre à récupérer.
   * @return Un ChambreDTO contenant les informations sur la chambre.
   */
  @Override
  public ChambreDTO liChambreDTO(long id) {
    Optional<Chambre> optionalChambre  = chambreRepository.findById(id);

    Chambre chambre = optionalChambre.get();

    return ChambreConvert.getInstance().convertEntityToChambreDto(chambre);
  }

  /**
   * Modifie les informations d'une chambre avec l'identifiant spécifié.
   * 
   * @param chambre Les nouvelles informations de la chambre.
   * @param id L'identifiant de la chambre à modifier.
   * @return Le DTO de la chambre modifiée.
   * @throws ServiceException Si la chambre avec l'identifiant spécifié n'existe pas.
   */
  @Override
  public ChambreDTO modifiChambreDTO(ChambreDTO chambre, long id) {
    Optional<Chambre> chambreOptionel = chambreRepository.findById(id);

    if(chambreOptionel.isPresent()){
      Chambre chambreEnBaseDeDonnes = chambreOptionel.get();
      chambreEnBaseDeDonnes.setNumDeChambre(chambre.getNumDeChambre());
      chambreEnBaseDeDonnes.setNombreLit(chambre.getNombreLit());

      Chambre chambreModifiee = chambreRepository.save(chambreEnBaseDeDonnes);
      return ChambreConvert.getInstance().convertEntityToChambreDto(chambreModifiee);
    } else {
      throw new ServiceException("La chambre que vous voulez modifier n'existe pas");
    }
  }

  /**
   * Supprime une chambre avec l'identifiant spécifié.
   * 
   * @param id L'identifiant de la chambre à supprimer.
   * @throws ServiceException Si la chambre avec l'identifiant spécifié n'existe pas.
   */
  @Override
  public void supprimer(long id) {
    Optional<Chambre> chambreOptional = chambreRepository.findById(id);

    if(chambreOptional.isPresent()) {
      chambreRepository.deleteById(id);
    } else {
      throw new ServiceException("La chambre que vous voulez supprimer n'existe pas");
    }
  }
}
