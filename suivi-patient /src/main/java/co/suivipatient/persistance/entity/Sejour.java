package co.suivipatient.persistance.entity;

import java.time.LocalDateTime;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entité représentant un séjour d'un patient dans l'hôpital.
 * Chaque séjour est associé à un patient et à un lit, ainsi qu'à des dates d'arrivée et de sortie.
 * Cette classe est mappée à la table 'Sejour' dans la base de données.
 */
@Entity
@Table(name = "Sejour")
public class Sejour {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sejour_id")
  private int sejourId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patientId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "lit_id")
  private Lit litId;

  @Column(name = "date_arrive")
  private Date dateArrivee;

  @Column(name = "date_sortie")
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
   * Obtient le patient associé au séjour.
   * 
   * @return Le patient associé au séjour.
   */
  public Patient getPatientId() {
    return patientId;
  }

  /**
   * Définit le patient associé au séjour.
   * 
   * @param patientId Le patient associé au séjour.
   */
  public void setPatientId(Patient patientId) {
    this.patientId = patientId;
  }

  /**
   * Obtient le lit associé au séjour.
   * 
   * @return Le lit associé au séjour.
   */
  public Lit getLitId() {
    return litId;
  }

  /**
   * Définit le lit associé au séjour.
   * 
   * @param litId Le lit associé au séjour.
   */
  public void setLitId(Lit litId) {
    this.litId = litId;
  }

  /**
   * Obtient la date d'arrivée du séjour.
   * 
   * @return La date d'arrivée du séjour.
   */
  public Date getDateArrivee() {
    return dateArrivee;
  }

  /**
   * Définit la date d'arrivée du séjour.
   * 
   * @param dateArrivee La date d'arrivée du séjour.
   */
  public void setDateArrivee(Date dateArrivee) {
    this.dateArrivee = dateArrivee;
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