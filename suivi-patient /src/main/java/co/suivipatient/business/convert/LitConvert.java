package co.suivipatient.business.convert;

import java.util.ArrayList;
import java.util.List;
import co.suivipatient.business.dto.ChambreDTO;
import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.persistance.entity.Chambre;
import co.suivipatient.persistance.entity.Lit;

/**
 * Classe utilitaire pour convertir les entités Lit en leurs DTOs correspondants et vice versa.
 * Cette classe implémente le pattern Singleton pour garantir qu'une seule instance soit utilisée durant toute l'exécution.
 */
public class LitConvert {

  private static LitConvert instance;

  private LitConvert() {}

  /**
   * Retourne l'instance unique de la classe LitConvert.
   * Si l'instance n'existe pas, elle sera créée.
   * 
   * @return L'instance unique de LitConvert.
   */
  public static LitConvert getInstance(){
    if (instance == null) {
      instance = new LitConvert();
    }
    return instance;
  }

   /**
    * Convertit une entité Lit en un objet LitDTO.
    * Cette méthode mappe les attributs de l'entité vers le DTO, y compris la conversion de l'entité Chambre associée.
    * 
    * @param lit L'entité Lit à convertir.
    * @return Le DTO LitDTO correspondant à l'entité.
    */
    public LitDTO convertEntityToDto(Lit lit){
      LitDTO dto = new LitDTO();
      dto.setLitId(lit.getLitId());
      dto.setStatus(lit.getStatus());
    
      // Convertit l'entité Chambre en ChambreDTO
      ChambreDTO chambreDTO = ChambreConvert.getInstance().convertEntityToChambreDto(lit.getChambre());
      dto.setChambre(chambreDTO);

      return dto;
    }

    /**
     * Convertit un objet LitDTO en une entité Lit.
     * Cette méthode mappe les attributs du DTO vers l'entité, y compris la conversion du DTO Chambre associé.
     * 
     * @param litDTO Le DTO LitDTO à convertir.
     * @return L'entité Lit correspondante au DTO.
     */
    public Lit convertDtoToEntity(LitDTO litDTO){
      Lit litEntity = new Lit();
      litEntity.setLitId(litDTO.getLitId());
      litEntity.setStatus(litDTO.getStatus());

      // Convertit le DTO Chambre en Entité Chambre
      Chambre chambreEntity = ChambreConvert.getInstance().convertChambreDtoToEntity(litDTO.getChambre());
      litEntity.setChambre(chambreEntity);

      return litEntity;
    }

    /**
     * Convertit une liste d'entités Lit en une liste de DTOs LitDTO.
     * Utilise `convertEntityToDto` pour convertir chaque élément de la liste.
     * 
     * @param listEntities La liste des entités Lit à convertir.
     * @return La liste des DTOs LitDTO correspondants.
     */
    public List<LitDTO> converListEntityToListDto(List<Lit> listEntities) {
      List<LitDTO> listLitDTO = new ArrayList<>();
      for (Lit l : listEntities) {
        listLitDTO.add(convertEntityToDto(l));
      }
      return listLitDTO;
    }

    /**
     * Convertit une liste de DTOs LitDTO en une liste d'entités Lit.
     * Utilise `convertDtoToEntity` pour convertir chaque élément de la liste.
     * 
     * @param listDTOs La liste des DTOs LitDTO à convertir.
     * @return La liste des entités Lit correspondantes.
     */
    public List<Lit> convertListDtoToListEntity(List<LitDTO> listDTOs){
      List<Lit> listEntities = new ArrayList<>();
      for (LitDTO dto : listDTOs) {
        listEntities.add(convertDtoToEntity(dto));
      }
      return listEntities;
    }
}
