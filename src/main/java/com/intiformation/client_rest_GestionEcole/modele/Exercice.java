package com.intiformation.client_rest_GestionEcole.modele;


/**
 * Classe entity pour les exercices. 
 * Relation OneToMany avec cours
 * @author Thanesh
 *
 */

public class Exercice {

	/*____________________props____________________*/

	private Long idExercice;
	
	private String libelle;
	

	private Cours cours;

	
	/*____________________ctors____________________*/
	public Exercice() {
		super();
	}

	public Exercice(String libelle) {
		this.libelle = libelle;
	}

	public Exercice(Long idExercice, String libelle) {
		this.idExercice = idExercice;
		this.libelle = libelle;
	}

	/*____________________getter/setter____________________*/
	public Long getIdExercice() {
		return idExercice;
	}

	public void setIdExercice(Long idExercice) {
		this.idExercice = idExercice;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	// ================== Méthodes ==========================//
	
	/**
	 * Attribut un cours à la propriété cours de l'exercice + ajoute l'exercice à la liste des exercices du cours 
	 * @param cours
	 */
	public void addCours(Cours cours) {
		this.cours=cours;
		cours.getListeExercices().add(this);
	}
	
	@Override
	public String toString() {
		return "Exercice [idExercice=" + idExercice + ", libelle=" + libelle + ", cours=" + cours + "]";
	}
	
	
	
	
}//end classe
