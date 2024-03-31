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
public class ChambreServiceImpl  implements ChambreService {

  private ChambreRepo  chambreRepository;
  
  public ChambreServiceImpl(ChambreRepo chambreRepository) {
    this.chambreRepository = chambreRepository;
  }

  @Override
  public ChambreDTO creer(ChambreDTO chambre) {
    Chambre  chambreEntity = ChambreConvert.getInstance().convertChambreDtoToEntity(chambre);

    Chambre conserveEntity = chambreRepository.save(chambreEntity);

    return  ChambreConvert.getInstance().convertEntityToChambreDto(conserveEntity);
  }

  @Override
  public List<ChambreDTO> lister() {
    List<Chambre> listeEntitees = chambreRepository.findAll();
    
    return ChambreConvert.getInstance().convertListEntitiesToListDTOs(listeEntitees);
  }
  

  @Override
  public ChambreDTO liChambreDTO(long id) {
    Optional<Chambre> optionalChambre  = chambreRepository.findById(id);

    Chambre chambre = optionalChambre.get();

    return ChambreConvert.getInstance().convertEntityToChambreDto(chambre);
  }

  @Override
  public ChambreDTO modifiChambreDTO(ChambreDTO chambre, long id) {
    Optional<Chambre> chambreOptionel = chambreRepository.findById(id);

    if(chambreOptionel.isPresent()){
      Chambre  chambreEnBaseDeDonnes= chambreOptionel.get();
      chambreEnBaseDeDonnes.setNumDeChambre(chambre.getNumDeChambre());
      chambreEnBaseDeDonnes.setNombreLit(chambre.getNombreLit());

      Chambre  chambreModifiee = chambreRepository.save(chambreEnBaseDeDonnes);
      return ChambreConvert.getInstance().convertEntityToChambreDto(chambreModifiee);
    }else{
      throw new ServiceException("La chambre que vous voulez modifier n'existe pas");
    }

  }

  @Override
  public void supprimer(long id) {

    Optional<Chambre> chambreOptional = chambreRepository.findById(id);

    if(chambreOptional.isPresent()){
      chambreRepository.deleteById(id);
    } else{
      throw new ServiceException("La chambre que vous voulez supprimer n'existe pas");
    
    }
  }
  
}
