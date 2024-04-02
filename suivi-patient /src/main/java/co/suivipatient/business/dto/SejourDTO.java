package co.suivipatient.business.dto;

import java.util.Date;

/**
 * Data Transfer Object (DTO) pour les séjours des patients.
 * Utilisé pour transférer des informations entre les couches de l'application sans exposer les entités de la base de données.
 * Contient des données sur un séjour, y compris les identifiants du séjour, du patient, du lit, et les dates d'arrivée et de sortie.
 */

 public class SejourDTO {

  // Identifiant du séjour
  private int sejourId;
  
  // Identifiant du patient associé au séjour
  private PatientDTO patientId;
  
  // Identifiant du lit associé au séjour
  private LitDTO litId;
  
  // Date d'arrivée du séjour
  private Date dateArrive;
  
  // Date de sortie du séjour
  private Date dateSortie;
  
  /**
   * Obtient l'identifiant du séjour.
   * 
   * @return L'identifiant du séjour.
   */
  public int getSejourId() {
    return sejourId;
  }
  
  /**
   * Définit l'identifiant du séjour.
   * 
   * @param sejourId L'identifiant du séjour.
   */
  public void setSejourId(int sejourId) {
    this.sejourId = sejourId;
  }
  
  /**
   * Obtient l'identifiant du patient associé au séjour.
   * 
   * @return L'identifiant du patient.
   */
  public PatientDTO getPatientId() {
    return patientId;
  }
  
  /**
   * Définit l'identifiant du patient associé au séjour.
   * 
   * @param patientId L'identifiant du patient.
   */
  public void setPatientId(PatientDTO patientId) {
    this.patientId = patientId;
  }
  
  /**
   * Obtient l'identifiant du lit associé au séjour.
   * 
   * @return L'identifiant du lit.
   */
  public LitDTO getLitId() {
    return litId;
  }
  
  /**
   * Définit l'identifiant du lit associé au séjour.
   * 
   * @param litId L'identifiant du lit.
   */
  public void setLitId(LitDTO litId) {
    this.litId = litId;
  }
  
  /**
   * Obtient la date d'arrivée du séjour.
   * 
   * @return La date d'arrivée du séjour.
   */
  public Date getDateArrive() {
    return dateArrive;
  }
  
  /**
   * Définit la date d'arrivée du séjour.
   * 
   * @param dateArrive La date d'arrivée du séjour.
   */
  public void setDateArrive(Date dateArrive) {
    this.dateArrive = dateArrive;
  }
  
  /**
   * Obtient la date de sortie du séjour.
   * 
   * @return La date de sortie du séjour.
   */
  public Date getDateSortie() {
    return dateSortie;
  }
  
  /**
   * Définit la date de sortie du séjour.
   * 
   * @param dateSortie La date de sortie du séjour.
   */
  public void setDateSortie(Date dateSortie) {
    this.dateSortie = dateSortie;
  }
}

