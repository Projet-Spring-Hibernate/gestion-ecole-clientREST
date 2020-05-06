package com.intiformation.client_rest_GestionEcole.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe entity pour les cours.
 * Relation ManyToMany avec Etudiant.
 * Relation ManyToOne avec Promotion. 
 * Relation ManyToOne avec Matiere. 
 * @author Lise
 *
 */

public class Cours{
	
	/*____________________props____________________*/

	private Long idCours;
	

	private String libelle;

	private String date;

	private String duree;

	private String description;
	
	private Promotion promotion;

	private Matiere matiere;

	private List<EtudiantCours> listeEtudiantCours =new ArrayList<EtudiantCours>();

	private List<Exercice> listeExercices = new ArrayList<Exercice>();
	
	
	/*____________________ctors____________________*/
	public Cours() {
		super();
	}

	public Cours(String libelle, String date, String duree, String description) {
		super();
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
	}

	public Cours(Long idCours, String libelle, String date, String duree, String description) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
	}

	
	/*________________getters/setter____________________*/
	public Long getIdCours() {
		return idCours;
	}

	public void setIdCours(Long idCours) {
		this.idCours = idCours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Etudiant> getListeEtudiant() {
//		return listeEtudiant;
//	}
//
//	public void setListeEtudiant(List<Etudiant> listeEtudiant) {
//		this.listeEtudiant = listeEtudiant;
//	}
	
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}

	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}

	public List<Exercice> getListeExercices() {
		return listeExercices;
	}

	public void setListeExercices(List<Exercice> listeExercices) {
		this.listeExercices = listeExercices;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	// ================== Méthodes ==========================//
	
//	/**
//	 * Ajoute un étudiant à la liste des étudiants du cours + ajoute le cours à la liste des cours de l'étudiant
//	 * @param etudiant
//	 */
//	public void addEtudiant(Etudiant etudiant) {
//		this.listeEtudiant.add(etudiant);
//		etudiant.getListeCours().add(this);
//	}
	
	/**
	 * Attribut une matière à la propriété  matière du cours + ajoute le cours à la liste des cours de la matière
	 * @param matiere
	 */
	public void addMatiere(Matiere matiere) {
		this.matiere=matiere;
		matiere.getListeCours().add(this);
	}
	
	/**
	 *  Ajoute un étudiantCours (table de jointure) à la liste des étudiantCours du cours + ajoute le cours à la propriété  cours de l'étudiantCours.
	 * @param etudiantCours
	 */
	public void addEtudiantCours(EtudiantCours etudiantCours) {
		this.listeEtudiantCours.add(etudiantCours);
		etudiantCours.setCours(this);
	}
	
	/**
	 *  Ajoute un exercice  à la liste des exercices du cours + ajoute le cours à l'attribut cours de l'exercice.	 
	 * @param exercice
	 */
	public void addExercice(Exercice exercice) {
		this.listeExercices.add(exercice);
		exercice.setCours(this);
	}
	
	/**
	 * Attribut une promotion à la propriété promotion du cours + ajoute le cours à la liste des cours de la matière
	 * @param promotion
	 */
	public void addPromotion(Promotion promotion) {
		this.promotion=promotion;
		promotion.getListeCours().add(this);
	}
	
	
	@Override
	public String toString() {
		return "Cours [idCours=" + idCours + ", libelle=" + libelle + ", date=" + date + ", duree=" + duree
				+ ", description=" + description + "]";
	}


}//end class
