package co.suivipatient.business.dto;

import java.util.Date;
/**
 * La classe PatientDTO (Data Transfer Object) sert à transférer les données
 * relatives à un patient entre les différentes couches de l'application,
 * notamment la couche de présentation et la couche de service.
 * 
 * Elle contient des informations sur l'identifiant unique du patient, son nom,
 * son prénom, son sexe, et sa date de naissance. Cette classe permet une manipulation
 * simplifiée et sécurisée des données du patient sans exposer l'entité de la base de données.
 */
public class PatientDTO {

  private long patientId;
  private String nom;
  private String prenom;
  private String sexe;
  private Date  dateNaissance;
	
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
   * @param id l'identifiant à attribuer au patient.
   */
public void setPatientId(long id) {
	this.patientId = id;
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
