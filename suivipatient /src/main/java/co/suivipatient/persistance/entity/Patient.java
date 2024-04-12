package co.suivipatient.persistance.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
/**
 * La classe Patient représente un patient dans le système de suivi de patients.
 * Elle est mappée à la table 'Patient' de la base de données, où chaque instance
 * de cette classe correspond à un enregistrement de la table.
 * 
 * Les attributs de la classe incluent l'identifiant unique du patient, son nom,
 * prénom, sexe, et date de naissance.
 */
@Table(name = "Patient")
public class Patient {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name = "patient_id")
  private long patientId;

  @Column(name = "nom")
  private String nom;

  @Column(name = "prenom")
  private String prenom;

  @Column(name = "sexe")
  private String sexe;
  
  @Column(name = "date_de_naissance")
  private Date dateNaissance;

    /**
   * Retourne l'identifiant unique du patient.
   * 
   * @return l'identifiant du patient.
   */
  public long getPatientId() {
    return patientId;
  }
  /**
   * Définit l'identifiant unique du patient.
   * 
   * @param patientId l'identifiant à attribuer au patient.
   */
  public void setPatientId(long patientId) {
    this.patientId = patientId;
  }

  /**
   * Retourne le nom du patient.
   * 
   * @return le nom du patient.
   */
public String getNom() {
	return nom;
}
 /**
   * Définit le nom du patient.
   * 
   * @param nom le nom à attribuer au patient.
   */
public void setNom(String nom) {
	this.nom = nom;
}
  /**
   * Retourne le prénom du patient.
   * 
   * @return le prénom du patient.
   */
public String getPrenom() {
	return prenom;
}
  /**
   * Définit le prénom du patient.
   * 
   * @param prenom le prénom à attribuer au patient.
   */
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
  /**
   * Retourne le sexe du patient.
   * 
   * @return le sexe du patient.
   */

public String getSexe() {
	return sexe;
}
  /**
   * Définit le sexe du patient.
   * 
   * @param sexe le sexe à attribuer au patient.
   */
public void setSexe(String sexe) {
	this.sexe = sexe;
}
 /**
   * Retourne la date de naissance du patient.
   * 
   * @return la date de naissance du patient.
   */
public Date getDateNaissance() {
	return dateNaissance;
}
  /**
   * Définit la date de naissance du patient.
   * 
   * @param dateNaissance la date de naissance à attribuer au patient.
   */
public void setDateNaissance(Date dateNaissance) {
	this.dateNaissance = dateNaissance;
}
  

}
