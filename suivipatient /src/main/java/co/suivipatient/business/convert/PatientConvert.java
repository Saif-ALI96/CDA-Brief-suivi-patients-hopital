package co.suivipatient.business.convert;

import java.util.ArrayList;
import java.util.List;

import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.persistance.entity.Patient;

/**
 * La classe PatientConvert implémente le modèle Singleton et fournit des méthodes
 * pour convertir entre les entités Patient et les objets PatientDTO.
 * 
 * Elle permet de séparer la logique de conversion de la logique métier de l'application,
 * facilitant ainsi la maintenance et l'évolution du code.
 */
public class PatientConvert {

  private static PatientConvert instance;
  private  PatientConvert(){
    // Aucun constructeur public pour une classe Singleton
  }
    /**
   * Retourne l'instance unique de la classe PatientConvert.
   * 
   * @return l'instance unique de PatientConvert.
   */
  public static PatientConvert getInstance() {
    if (instance == null) {
      instance = new PatientConvert();
    }
    return instance;
  }

  /**
   * Convertit une entité Patient en un objet PatientDTO.
   * 
   * @param patient L'entité Patient à convertir.
   * @return Un objet PatientDTO correspondant à l'entité Patient.
   */

  public PatientDTO convertToDto(final Patient patient){
    PatientDTO dto = new PatientDTO();
    dto.setPatientId(patient.getPatientId() );
    dto.setNom(patient.getNom());
    dto.setPrenom(patient.getPrenom());
    dto.setSexe(patient.getSexe());
    dto.setDateNaissance(patient.getDateNaissance());

    return dto;
  }

  /**
   * Convertit un objet PatientDTO en une entité Patient.
   * 
   * @param patientDto L'objet PatientDTO à convertir.
   * @return Une entité Patient correspondant à l'objet PatientDTO.
   */

   public Patient converToEntity(final PatientDTO patientDto){
    final Patient patientEntity = new Patient();
    patientEntity.setPatientId(patientDto.getPatientId());
    patientEntity.setNom(patientDto.getNom());
    patientEntity.setPrenom(patientDto.getPrenom());
    patientEntity.setSexe(patientDto.getSexe());
    patientEntity.setDateNaissance(patientDto.getDateNaissance());
    
    return patientEntity;

  }

  /**
   * Convertit une liste d'entités Patient en une liste d'objets PatientDTO.
   * 
   * @param listPatients La liste des entités Patient à convertir.
   * @return Une liste d'objets PatientDTO correspondant aux entités Patient.
   */
  public List<PatientDTO> converListEntityToListDTO(final List<Patient> listPatients){
    List<PatientDTO> listPatientsDTO=new ArrayList<>();
    for (final Patient p : listPatients) {
      listPatientsDTO.add(convertToDto(p));
    }
    return listPatientsDTO;
  }

  /**
   * Convertit une liste d'objets PatientDTO en une liste d'entités Patient.
   * 
   * @param listPatientsDTO La liste des objets PatientDTO à convertir.
   * @return Une liste d'entités Patient correspondant aux objets PatientDTO.
   */  
  public List<Patient>  converListDTOToListEntity(final List<PatientDTO> listPatientsDTO){
    List<Patient> listPatients=new ArrayList<>();
    for (final PatientDTO pd:listPatientsDTO) {
      listPatients.add(converToEntity(pd));
    }
    return listPatients;
  }
}

