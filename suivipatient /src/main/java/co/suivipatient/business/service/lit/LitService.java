package co.suivipatient.business.service.lit;
import java.util.List;

import co.suivipatient.business.dto.LitDTO;

public interface LitService {

  //ajouter une methode pour modifier le status du lit 
  // afficher tous les lits
  List<LitDTO> afficherLits();

  LitDTO afficherLitId(Long id);
   void updateStatus(long idLit, Boolean newStatus);

}
