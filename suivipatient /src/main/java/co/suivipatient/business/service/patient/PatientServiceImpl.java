    package co.suivipatient.business.service.patient;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.suivipatient.business.convert.PatientConvert;
import co.suivipatient.business.dto.PatientDTO;
import co.suivipatient.persistance.entity.Patient;
import co.suivipatient.persistance.repository.PatientRepo;
import jakarta.persistence.EntityNotFoundException;

/**
 * Service implémentant les opérations liées à la gestion des patients.
 * Fournit des méthodes pour créer, lire, modifier et supprimer des patients,
 * en utilisant {@link PatientRepo} pour interagir avec la base de données.
 * 
 */
@Service
public class PatientServiceImpl implements PatientService {
    /**
   * Référence au repository pour les opérations CRUD sur les patients.
   */

  private PatientRepo  patientRepository;

  /**
   * Constructeur pour injection de dépendance du repository des patients.
   * 
   * @param patientRepository Le repository à injecter.
   */
  @Autowired
  public PatientServiceImpl(PatientRepo patientRepository) { this.patientRepository = patientRepository;}

    /**
   * Crée un nouveau patient dans la base de données.
   * 
   * @param patient Le DTO du patient à créer.
   * @return Le DTO du patient créé.
   */

  @Override
  public PatientDTO creer(PatientDTO patient) {

    Patient  entity = PatientConvert.getInstance().converToEntity(patient);

    Patient conserveEntity = patientRepository.save(entity);
    
    return PatientConvert.getInstance().convertToDto(conserveEntity);
  
  }

  /**
   * Récupère la liste de tous les patients.
   * 
   * @return La liste des DTOs des patients.
   */

  @Override
  public List<PatientDTO> lire() {
  final  List<Patient> entities = patientRepository.findAll();
  
  return PatientConvert.getInstance().converListEntityToListDTO(entities);
  }

    /**
   * Récupère un patient spécifique par son ID.
   * 
   * @param id L'ID du patient à récupérer.
   * @return Le DTO du patient récupéré.
   * @throws EntityNotFoundException si le patient n'est pas trouvé.
   */

  @Override
  public PatientDTO lirPatientDTO(long id) {
    Optional<Patient>  optionalPatient = patientRepository.findById(id);
    
    Patient patient = optionalPatient.get() ;
    
    return PatientConvert.getInstance().convertToDto(patient);
  
  }
    /**
   * Modifie les informations d'un patient existant.
   * 
   * @param id L'ID du patient à modifier.
   * @param patient Les nouvelles informations du patient sous forme de DTO.
   * @return Le DTO du patient modifié.
   * @throws EntityNotFoundException si le patient à modifier n'est pas trouvé.
   */

  @Override
  public PatientDTO modifier(long id, PatientDTO patient) {
    
    Optional<Patient>  optionalPatient = patientRepository.findById(id);
    if (optionalPatient.isPresent()){
      Patient dejaExiste = optionalPatient.get() ;
      dejaExiste.setNom(patient.getNom());
      dejaExiste.setPrenom(patient.getPrenom());
      dejaExiste.setSexe(patient.getSexe());
      dejaExiste.setDateNaissance(patient.getDateNaissance());

      Patient newPatient = patientRepository.save(dejaExiste);
      
      return PatientConvert.getInstance().convertToDto(newPatient);
    }else{
      throw new EntityNotFoundException("Le patient d'id " + id+ " n'existe pas");
    }
  }

    /**
   * Supprime un patient de la base de données.
   * 
   * @param id L'ID du patient à supprimer.
   * @throws EntityNotFoundException si le patient à supprimer n'est pas trouvé.
   */
  @Override
  public void supprimer(long id ){

    Optional<Patient>  optionalPatientDelete = patientRepository.findById(id);

    if (optionalPatientDelete.isPresent()) {
      patientRepository.deleteById(id);
  }else{
    throw new EntityNotFoundException("Le patient d'id "+id+" n'a pas été trouvé.");
  }
  
  }

}
