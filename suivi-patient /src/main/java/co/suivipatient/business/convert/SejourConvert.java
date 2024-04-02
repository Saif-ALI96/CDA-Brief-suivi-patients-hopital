package co.suivipatient.business.convert;
import java.util.ArrayList;
import java.util.List;
import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.business.dto.SejourDTO;
import co.suivipatient.persistance.entity.Lit;
import co.suivipatient.persistance.entity.Patient;
import co.suivipatient.persistance.entity.Sejour;

/**
 * Classe utilitaire pour la conversion entre les entités Sejour et leurs DTOs correspondants.
 * Implémente le pattern Singleton pour garantir une unique instance de la classe.
 */
public class SejourConvert {
  
  private static SejourConvert instance;
  
  private SejourConvert(){}

  /**
   * Retourne l'instance unique de SejourConvert.
   * Si aucune instance n'existe, en crée une nouvelle.
   * 
   * @return L'instance unique de SejourConvert.
   */
  public static SejourConvert getInstance(){
    if(instance == null){
      instance = new SejourConvert();
    }
    return instance;
  }

  /**
   * Convertit une entité Sejour en un DTO SejourDTO.
   * 
   * @param sejour L'entité Sejour à convertir.
   * @return Le DTO SejourDTO correspondant.
   */
  public SejourDTO convertSejourEntityToDto(Sejour sejour) {
    SejourDTO sejourDto = new SejourDTO();
    sejourDto.setSejourId(sejour.getSejourId());
    PatientDTO patientDTO = PatientConvert.getInstance().convertToDto(sejour.getPatientId());
    sejourDto.setPatientId(patientDTO);
    LitDTO litDTO = LitConvert.getInstance().convertEntityToDto(sejour.getLitId());
    sejourDto.setLitId(litDTO);
    sejourDto.setDateArrive(sejour.getDateArrivee());
    sejourDto.setDateSortie(sejour.getDateSortie());



    

    return sejourDto;
  }

  /**
   * Convertit un DTO SejourDTO en une entité Sejour.
   * 
   * @param sejourDTO Le DTO SejourDTO à convertir.
   * @return L'entité Sejour correspondante.
   */
  public Sejour convertDtoToEntity(SejourDTO sejourDTO){
    Sejour sejourEntity = new Sejour();
    sejourEntity.setSejourId(sejourDTO.getSejourId());

    Patient patient = PatientConvert.getInstance().converToEntity(sejourDTO.getPatientId());
    sejourEntity.setPatientId(patient);

    Lit lit = LitConvert.getInstance().convertDtoToEntity(sejourDTO.getLitId());
    sejourEntity.setLitId(lit);

    sejourEntity.setDateArrivee(sejourDTO.getDateArrive());
    sejourEntity.setDateSortie(sejourDTO.getDateArrive());
    
  return sejourEntity;
  }
  

  /**
   * Convertit une liste d'entités Sejour en une liste de DTOs SejourDTO.
   * 
   * @param listSejourEntity La liste d'entités Sejour à convertir.
   * @return La liste de DTOs SejourDTO correspondants.
   */
  public List<SejourDTO> listSejourEntityToListDto(List<Sejour> listSejourEntity){
    List<SejourDTO> listSejourDto = new ArrayList<>();
    for (final Sejour s : listSejourEntity) {
      listSejourDto.add(convertSejourEntityToDto(s));
    }
    return listSejourDto;
  }

  /**
   * Convertit une liste de DTOs SejourDTO en une liste d'entités Sejour.
   * 
   * @param listSejourDto La liste de DTOs SejourDTO à convertir.
   * @return La liste d'entités Sejour correspondantes.
   */
  public List<Sejour> listSejourDtoToListEntity(List<SejourDTO> listSejourDto){
    List<Sejour> listSejourEntity = new ArrayList<>();
    for (final SejourDTO dto : listSejourDto){
      listSejourEntity.add(convertDtoToEntity(dto));
    }
    return listSejourEntity;
  }
}
