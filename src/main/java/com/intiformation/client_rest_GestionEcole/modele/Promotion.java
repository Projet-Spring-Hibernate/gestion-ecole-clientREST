package com.intiformation.client_rest_GestionEcole.modele;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



/**
 * Classe entity pour les promotions.
 * Relation triple avec Enseignant et Matière
 * Relation ManyToMany avec Enseignant.
 * Relation ManyToMany avec Matière.
 * 
 * @author Thanesh
 *
 */

public class Promotion implements Serializable {


	/*_______________prop_______________*/

	private Long idPromotion;
	
	private String libelle;


	private List<EnseignantMatierePromotion> listeEnseignantMatierePromotion = new ArrayList<EnseignantMatierePromotion>();
	
	
	
	// relation entre promotion et cours

	private List<Cours> listeCours =new ArrayList<Cours>();
	
	// relation entre promotion et étudiant

	private List<Etudiant> listeEtudiant =new ArrayList<Etudiant>();
	
	
	
	/*_______________ctor_______________*/

	public Promotion() {
		super();
	}

	public Promotion(String libelle) {
		this.libelle = libelle;
	}

	
	/*_______________get/set_______________*/

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Long getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}


	public List<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}



	public List<EnseignantMatierePromotion> getListeEnseignantMatierePromotion() {
		return listeEnseignantMatierePromotion;
	}

	public void setListeEnseignantMatierePromotion(List<EnseignantMatierePromotion> listeEnseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion = listeEnseignantMatierePromotion;
	}

	public void setListeEtudiant(List<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	
	// ================== Méthodes ==========================//
	

	
	public void addEnseignantMatierePromotion(EnseignantMatierePromotion enseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion.add(enseignantMatierePromotion);
		enseignantMatierePromotion.setPromotion(this);
	}
	
	/**
	 * Ajoute un etudiant à la liste des etudiants de la promotion + ajoute la promotion à la liste des promotions de l'etudiant
	 * @param matiere
	 */
	public void addEtudiant(Etudiant etudiant ) {
		this.listeEtudiant.add(etudiant);
		etudiant.getListePromotion().add(this);
	}
	
	/**
	 * Ajoute un cours à la liste des cours de la promotion + attribut la promotion à la propriété promotion du cours
	 * @param cours
	 */
	public void addCours(Cours cours) {
		this.listeCours.add(cours);
		cours.setPromotion(this);
	}
	
	
	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + "]";
	}
	
	
}//end class
