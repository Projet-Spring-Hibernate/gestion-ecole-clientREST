package com.intiformation.client_rest_GestionEcole.modele;

/**
 * Table de jointure entre Etudiant et cours.
 * Relation ManyToOne avec Cours. 
 * Relation ManyToOne avec Etudiant. 
 * @author Lise
 *
 */

public class EtudiantCours{

	/*_____________________props___________________*/

	private Long id;
	

	private boolean absence;

	private String motif;
	

	private Cours cours;
	

	private Etudiant etudiant;

	
	
	/*____________________ctors____________________*/
	
	public EtudiantCours() {
		super();
	}



	public EtudiantCours(boolean absence, String motif) {
		super();
		this.absence = absence;
		this.motif = motif;
	}



	/*________________getters/setter____________________*/
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public boolean isAbsence() {
		return absence;
	}



	public void setAbsence(boolean absence) {
		this.absence = absence;
	}



	public String getMotif() {
		return motif;
	}



	public void setMotif(String motif) {
		this.motif = motif;
	}



	public Cours getCours() {
		return cours;
	}



	public void setCours(Cours cours) {
		this.cours = cours;
	}



	public Etudiant getEtudiant() {
		return etudiant;
	}



	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	// ================== Méthodes ==========================//

	/**
	 * Attribut un cours à la propriété cours de l'étudiantCours + ajoute l'étudiantCours à la liste des etudiantsCours du cours
	 * @param cours
	 */
	public void addCours(Cours cours) {
		this.cours=cours;
		cours.getListeEtudiantCours().add(this);
	}

	/**
	 * Attribut un etudiant à la propriété etudiant de l'étudiantCours + ajoute l'étudiantCours à la liste des etudiantsCours de l'étudiant
	 * @param cours
	 */
	public void addEtudiant(Etudiant etudiant) {
		this.etudiant=etudiant;
		etudiant.getListeEtudiantCours().add(this);
	}
	
	@Override
	public String toString() {
		return "EtudiantCours [id=" + id + ", absence=" + absence + ", motif=" + motif + ", cours=" + cours
				+ ", etudiant=" + etudiant + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
