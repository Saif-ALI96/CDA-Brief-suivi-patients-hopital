package co.suivipatient.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.persistance.entity.Chambre;

/**
 * Classe de conversion pour les objets Chambre et ChambreDTO.
 * Permet de convertir entre les entités de base de données Chambre et les Data Transfer Objects (DTO) ChambreDTO,
 * facilitant ainsi l'échange de données entre différentes couches de l'application.
 */
public class ChambreConvert {
  
  private static ChambreConvert instance;

  private ChambreConvert() {}

  /**
   * Récupère l'instance singleton de ChambreConvert.
   * 
   * @return L'instance unique de ChambreConvert.
   */
  public static ChambreConvert getInstance() {
    if (instance == null) {
      instance = new ChambreConvert();
    }
    return instance;
  }

  /**
   * Convertit une entité Chambre en ChambreDTO.
   * 
   * @param chambreEntity L'entité Chambre à convertir.
   * @return Le DTO correspondant à l'entité Chambre.
   */
  public ChambreDTO convertEntityToChambreDto(final Chambre chambreEntity) {
    ChambreDTO dto = new ChambreDTO();
    dto.setChambreID(chambreEntity.getChambreID());
    dto.setNumDeChambre(chambreEntity.getNumDeChambre());
    dto.setNombreLit(chambreEntity.getNombreLit());

    return dto;
  }

  /**
   * Convertit un ChambreDTO en entité Chambre.
   * 
   * @param chambreDto Le DTO à convertir en entité.
   * @return L'entité Chambre correspondante au DTO.
   */
  public Chambre convertChambreDtoToEntity(final ChambreDTO chambreDto) {
    Chambre entity = new Chambre();
    entity.setChambreID(chambreDto.getChambreID());
    entity.setNumDeChambre(chambreDto.getNumDeChambre());
    entity.setNombreLit(chambreDto.getNombreLit());

    return entity;
  }

  /**
   * Convertit une liste d'entités Chambre en une liste de ChambreDTO.
   * 
   * @param chambres La liste des entités à convertir.
   * @return Une liste de DTOs correspondant aux entités fournies.
   */
  public List<ChambreDTO> convertListEntitiesToListDTOs(List<Chambre> chambres) {
    List<ChambreDTO> listChambreDto = new ArrayList<>();
    for (final Chambre c : chambres) {
      listChambreDto.add(convertEntityToChambreDto(c));
    }
    return listChambreDto;
  }

  /**
   * Convertit une liste de ChambreDTO en une liste d'entités Chambre.
   * 
   * @param chambresDto La liste des DTOs à convertir en entités.
   * @return Une liste d'entités Chambre correspondant aux DTOs fournis.
   */
  public List<Chambre> convertListDtoToListEntity(List<ChambreDTO> chambresDto) {
    List<Chambre> listChambresEntity = new ArrayList<>();
    for (final ChambreDTO d : chambresDto) {
      listChambresEntity.add(convertChambreDtoToEntity(d));
    }
    return listChambresEntity;
  }
}
