package co.suivipatient.business.dto;

/**
 * Classe DTO (Data Transfer Object) pour l'entité Lit.
 * Utilisée pour transférer des données entre les couches logiques de l'application,
 * sans exposer directement les entités de la base de données.
 * Contient des informations sur un lit, y compris son état et la chambre associée.
 */
public class LitDTO {
  private int litId;
  private Boolean status;
  private ChambreDTO chambreDTO;

  /**
   * Obtient l'identifiant du lit.
   * 
   * @return L'identifiant du lit.
   */
  public int getLitId() {
    return litId;
  }

  /**
   * Définit l'identifiant du lit.
   * 
   * @param litIdd L'identifiant du lit.
   */
  public void setLitId(int litIdd) {
    litId = litIdd;
  }

  /**
   * Obtient le statut du lit.
   * Le statut peut indiquer si le lit est occupé, libre, etc.
   * 
   * @return Le statut du lit sous forme de valeur Boolean.
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * Définit le statut du lit.
   * 
   * @param status Le statut du lit à définir.
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * Obtient la chambre associée à ce lit.
   * 
   * @return Un objet ChambreDTO représentant la chambre associée.
   */
  public ChambreDTO getChambre() {
    return chambreDTO;
  }

  /**
   * Définit la chambre associée à ce lit.
   * 
   * @param chambre Un objet ChambreDTO représentant la chambre à associer.
   */
  public void setChambre(ChambreDTO chambre) {
    this.chambreDTO = chambre;
  }

}
