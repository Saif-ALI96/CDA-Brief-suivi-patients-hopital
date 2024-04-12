package co.suivipatient.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entité représentant un lit dans le système de gestion des patients.
 * Cette classe est mappée sur une table 'Lit' dans la base de données.
 * Elle contient des informations sur le lit, y compris son statut (disponible, occupé, etc.) et la chambre à laquelle il appartient.
 */
@Entity
@Table(name = "Lit")
public class Lit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "lit_id")
  private int litId;

  @Column(name = "status")
  private Boolean status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name= "chambre_id")
  private Chambre chambre;

  /**
   * Retourne l'identifiant unique du lit.
   * 
   * @return l'identifiant du lit.
   */
  public int getLitId() {
    return litId;
  }

  /**
   * Définit l'identifiant unique du lit.
   * 
   * @param litId l'identifiant à définir.
   */
  public void setLitId(int litId) {
    this.litId = litId;
  }

  /**
   * Retourne le statut actuel du lit (par exemple, si le lit est occupé ou disponible).
   * 
   * @return le statut du lit.
   */
  public Boolean getStatus() {
    return status;
  }

  /**
   * Définit le statut du lit.
   * 
   * @param status le statut à définir pour le lit.
   */
  public void setStatus(Boolean status) {
    this.status = status;
  }

  /**
   * Retourne la chambre à laquelle ce lit est associé.
   * La relation est de type 'ManyToOne', car plusieurs lits peuvent être associés à une seule chambre.
   * 
   * @return la chambre associée au lit.
   */
  public Chambre getChambre() {
    return chambre;
  }

  /**
   * Définit la chambre à laquelle ce lit est associé.
   * 
   * @param chambre la chambre à associer au lit.
   */
  public void setChambre(Chambre chambre) {
    this.chambre = chambre;
  }
  
}
