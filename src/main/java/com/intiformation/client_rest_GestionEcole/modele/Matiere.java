package com.intiformation.client_rest_GestionEcole.modele;


import java.util.ArrayList;
import java.util.List;


/**
 * Classe entity pour les matières.
 * Relation triple avec Enseignant et Promotion
 * Relation ManyToMany avec Enseignant.
 * Relation ManyToMany avec Promotion.
 * @author Thanesh
 *
 */

public class Matiere {


	/*_______________prop_______________*/

	private Long idMatiere;
	
	
	private String libelle;
	

	private List<EnseignantMatierePromotion> listeEnseignantMatierePromotion = new ArrayList<EnseignantMatierePromotion>();
	
	
	//relation entre matière et Cours

	private List<Cours> listeCours= new ArrayList<Cours>();
	
	
	/*_______________ctor_______________*/

	public Matiere() {
	}

	public Matiere(String libelle) {
		this.libelle = libelle;
	}

	
	/*_______________get/set_______________*/

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

//	public List<Enseignant> getListeEnseignant() {
//		return listeEnseignant;
//	}
//
//	public void setListeEnseignant(List<Enseignant> listeEnseignant) {
//		this.listeEnseignant = listeEnseignant;
//	}
//
//	public List<Promotion> getListePromotion() {
//		return listePromotion;
//	}
//
//	public void setListePromotion(List<Promotion> listePromotion) {
//		this.listePromotion = listePromotion;
//	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public List<EnseignantMatierePromotion> getListeEnseignantMatierePromotion() {
		return listeEnseignantMatierePromotion;
	}

	public void setListeEnseignantMatierePromotion(List<EnseignantMatierePromotion> listeEnseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion = listeEnseignantMatierePromotion;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	// ================== Méthodes ==========================//
	
//	/**
//	 * Ajoute un enseignant à la liste des enseignants de la matière + ajoute la matière à la liste des matières de l'enseignant
//	 * @param enseignant
//	 */
//	public void addEnseignant(Enseignant enseignant) {
//		this.listeEnseignant.add(enseignant);
//		enseignant.getListeMatiere().add(this);
//	}
//	
//	/**
//	 * Ajoute une promotion à la liste des promotions de la matière + ajoute la matière à la liste des matières de la promotion 
//	 * @param promotion
//	 */
//	public void addPromotion(Promotion promotion) {
//		this.listePromotion.add(promotion);
//		promotion.getListeMatiere().add(this);
//	}
	
	
	public void addEnseignantMatierePromotion(EnseignantMatierePromotion enseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion.add(enseignantMatierePromotion);
		enseignantMatierePromotion.setMatiere(this);
	}
	
	
	/**
	 * Ajoute un cours à la liste des cours de la matière + attribut la matière à la propriété matière du cours
	 * @param promotion
	 */
	public void addCours(Cours cours) {
		System.out.println("============"+ cours);
		System.out.println("========="+this);
		this.listeCours.add(cours);
		System.out.println("checkpoint");
		cours.setMatiere(this);
	}
	
	
	@Override
	public String toString() {
		return "Matiere [idMatiere=" + idMatiere + ", libelle=" + libelle + "]";
	}
	
}//end class
