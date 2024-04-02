package co.suivipatient.business.service.sejour;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.suivipatient.business.convert.SejourConvert;
import co.suivipatient.business.dto.SejourDTO;
import co.suivipatient.persistance.entity.Sejour;
import co.suivipatient.persistance.repository.PatientRepo;
import co.suivipatient.persistance.repository.SejourRepo;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SejourServiceImpl implements SejourService {

  // Repository pour l'accès aux données des séjours
  private SejourRepo sejourRepository;
  
  // Repository pour l'accès aux données des patients
  private PatientRepo patientRepository;

  /**
   * Constructeur de la classe SejourServiceImpl.
   * 
   * @param sejourRepository Le repository pour l'accès aux données des séjours.
   * @param patientRepository Le repository pour l'accès aux données des patients.
   */
  public SejourServiceImpl(SejourRepo sejourRepository, PatientRepo patientRepository) { 
    this.sejourRepository = sejourRepository;
    this.patientRepository = patientRepository;
  }

  /**
   * Enregistre la date d'arrivée pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param dateArrivee La date d'arrivée à enregistrer.
   * @return Le DTO du séjour avec la date d'arrivée mise à jour.
   * @throws EntityNotFoundException Si le séjour avec l'identifiant spécifié n'existe pas.
   */
  @Override
  public SejourDTO enregistrerDateArrive(long id, Date dateArrivee) {
    Sejour sejour = sejourRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Le séjour n'existe pas"));

    sejour.setDateArrivee(dateArrivee);

    Sejour sejourEnregistre = sejourRepository.saveAndFlush(sejour);

    return SejourConvert.getInstance().convertSejourEntityToDto(sejourEnregistre);
  }

  /**
   * Enregistre la date de sortie pour un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour.
   * @param dateSortie La date de sortie à enregistrer.
   * @return Le DTO du séjour avec la date de sortie mise à jour.
   * @throws RuntimeException Si le séjour avec l'identifiant spécifié n'existe pas.
   */
  @Override
  public SejourDTO enregistrerDateSortie(long id, Date dateSortie) {
    Sejour sejour = sejourRepository.findById(id).orElseThrow(() -> new RuntimeException("Le séjour n'existe pas"));

    sejour.setDateSortie(dateSortie);

    Sejour savedSejour = sejourRepository.saveAndFlush(sejour);
    return SejourConvert.getInstance().convertSejourEntityToDto(savedSejour);
  }

  /**
   * Récupère la liste de tous les séjours enregistrés dans l'application.
   * 
   * @return Une liste de SejourDTO contenant les informations sur les séjours.
   */
  @Override
  public List<SejourDTO> afficherSejour() {
    List<Sejour> listSejour = sejourRepository.findAll();
    return SejourConvert.getInstance().listSejourEntityToListDto(listSejour);
  }

  /**
   * Récupère les informations d'un séjour avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du séjour à récupérer.
   * @return Un SejourDTO contenant les informations sur le séjour.
   * @throws EntityNotFoundException Si le séjour avec l'identifiant spécifié n'existe pas.
   */
  @Override
  public SejourDTO afficherSejourId(long id) {
    Optional<Sejour> optSejour = sejourRepository.findById(id);
    Sejour sejour = optSejour.orElseThrow(() -> new EntityNotFoundException("Séjour non trouvé"));
    return SejourConvert.getInstance().convertSejourEntityToDto(sejour);
  }
}