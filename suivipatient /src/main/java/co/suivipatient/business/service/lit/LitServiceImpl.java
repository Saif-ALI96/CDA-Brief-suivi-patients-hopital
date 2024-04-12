package co.suivipatient.business.service.lit;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import co.suivipatient.business.convert.LitConvert;
import co.suivipatient.business.dto.LitDTO;
import co.suivipatient.persistance.entity.Lit;
import co.suivipatient.persistance.repository.LitRepo;

/**
 * Implémentation du service LitService.
 * Cette classe gère les opérations liées aux lits.
 */
@Service
public class LitServiceImpl implements LitService {

  // Repository pour l'accès aux données des lits
  private final LitRepo litRepository;

  /**
   * Constructeur de la classe LitServiceImpl.
   * 
   * @param litRepository Le repository pour l'accès aux données des lits.
   */
  public LitServiceImpl(final LitRepo litRepository) {
    this.litRepository = litRepository;
  }

  /**
   * Met à jour le statut d'un lit avec l'identifiant spécifié.
   * 
   * @param idLit L'identifiant du lit à mettre à jour.
   * @param newStatus Le nouveau statut du lit.
   * @throws RuntimeException Si le lit avec l'identifiant spécifié n'existe pas.
   * @throws IllegalArgumentException Si le nouveau statut est null.
   */
  public void updateStatus(long idLit, Boolean newStatus) {
    Lit lit = litRepository.findById(idLit)
      .orElseThrow(() -> new RuntimeException("Ce lit n'existe pas"));

    if (newStatus != null) {
      lit.setStatus(newStatus);
    } else {
      throw new IllegalArgumentException("Le nouveau statut est requis pour la mise à jour");
    }
    
    // Mettre à jour le statut du lit dans la base de données
    litRepository.save(lit);
  }

  /**
   * Récupère la liste de tous les lits disponibles.
   * 
   * @return Une liste de LitDTO contenant les informations sur les lits.
   */
  @Override
  public List<LitDTO> afficherLits() {
    final List<Lit> lits = litRepository.findAll();
    return LitConvert.getInstance().converListEntityToListDto(lits);
  }

  /**
   * Récupère les informations d'un lit avec l'identifiant spécifié.
   * 
   * @param id L'identifiant du lit à récupérer.
   * @return Un LitDTO contenant les informations sur le lit.
   * @throws ResponseStatusException Si le lit avec l'identifiant spécifié est introuvable.
   */
  @Override
  public LitDTO afficherLitId(Long id) {
    Lit lit = litRepository.findById(id)
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Le lit est introuvable"));
    
    return LitConvert.getInstance().convertEntityToDto(lit);
  }
}