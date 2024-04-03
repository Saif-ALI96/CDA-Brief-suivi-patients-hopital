package co.suivipatient.business.dto;

/**
 * DTO pour les données de chambre.
 * Ce DTO sert à transférer des informations sur les chambres entre les différentes couches de l'application,
 * notamment entre la couche de persistance et la couche de présentation ou la logique métier.
 * Il encapsule les détails d'une chambre, tels que son identifiant, son numéro et le nombre de lits disponibles.
 */
public class ChambreDTO {
  private int chambreID;
  private String numDeChambre;
  private int nombreLit;

  /**
   * Obtient l'identifiant unique de la chambre.
   * 
   * @return L'identifiant de la chambre.
   */
  public int getChambreID() {
    return chambreID;
  }

  /**
   * Définit l'identifiant unique de la chambre.
   * 
   * @param chambreID L'identifiant de la chambre.
   */
  public void setChambreID(int chambreID) {
    this.chambreID = chambreID;
  }

  /**
   * Obtient le numéro de la chambre.
   * 
   * @return Le numéro de la chambre sous forme de chaîne de caractères.
   */
  public String getNumDeChambre() {
    return numDeChambre;
  }

  /**
   * Définit le numéro de la chambre.
   * 
   * @param numDeChambre Le numéro de la chambre.
   */
  public void setNumDeChambre(String numDeChambre) {
    this.numDeChambre = numDeChambre;
  }

  /**
   * Obtient le nombre de lits dans la chambre.
   * 
   * @return Le nombre de lits disponibles.
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
