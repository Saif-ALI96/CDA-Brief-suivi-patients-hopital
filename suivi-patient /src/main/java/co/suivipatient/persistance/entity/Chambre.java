package co.suivipatient.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entité représentant une chambre dans la base de données.
 * Cette entité comprend des informations sur l'identifiant de la chambre, son numéro, et le nombre de lits qu'elle contient.
 */
@Entity
@Table(name = "Chambre")
public class Chambre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "chambre_id")
  private int chambreID;

  @Column(name = "numero_de_chambre")
  private String numDeChambre;

  @Column(name = "nombre_de_lits")
  private int nombreLit;

  /**
   * Obtient l'identifiant de la chambre.
   * 
   * @return L'identifiant de la chambre.
   */
  public int getChambreID() {
    return chambreID;
  }

  /**
   * Définit l'identifiant de la chambre.
   * 
   * @param chambreID L'identifiant de la chambre.
   */
  public void setChambreID(int chambreID) {
    this.chambreID = chambreID;
  }

  /**
   * Obtient le numéro de la chambre.
   * 
   * @return Le numéro de la chambre.
   */
  public String getNumDeChambre() {
    return numDeChambre;
  }

  /**
   * Définit le numéro de la chambre.
   * 
   * @param numDeChambre Le numéro de la chambre à définir.
   */
  public void setNumDeChambre(String numDeChambre) {
    this.numDeChambre = numDeChambre;
  }

  /**
   * Obtient le nombre de lits dans la chambre.
   * 
   * @return Le nombre de lits.
   */
  public int getNombreLit() {
    return nombreLit;
  }

  /**
   * Définit le nombre de lits dans la chambre.
   * 
   * @param nombreLit Le nombre de lits à définir.
   */
  public void setNombreLit(int nombreLit) {
    this.nombreLit = nombreLit;
  }
}
