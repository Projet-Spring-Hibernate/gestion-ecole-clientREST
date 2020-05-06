package com.intiformation.client_rest_GestionEcole.modele;



/**
 * Table de jointure triple entre Enseignant, promotion et matière
 * @author IN-MP-018
 *
 */

public class EnseignantMatierePromotion {

	/*_______________prop_______________*/

	private Long id;
	

	private Matiere matiere;

	private Enseignant enseignant;
	

	private Promotion promotion;
	
	/*_______________Constructeurs_______________*/
	
	public EnseignantMatierePromotion() {

	}
	

	/*_______________getter Setter_______________*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	//_______________________Méthodes ___________________//
	
	
	public void addPromotion(Promotion promotion) {
		this.promotion=promotion;
		promotion.getListeEnseignantMatierePromotion().add(this);
	}
	
	
	public void addMatiere(Matiere matiere) {
		this.matiere=matiere;
		matiere.getListeEnseignantMatierePromotion().add(this);
	}
	
	public void addEnseignant(Enseignant enseignant) {
		this.enseignant=enseignant;
		enseignant.getListeEnseignantMatierePromotion().add(this);
	}
	
	@Override
	public String toString() {
		return "EnseignantMatierePromotion [id=" + id + ", matiere=" + matiere.getIdMatiere() + ", enseignant=" + enseignant.getIdentifiant()
				+ ", promotion=" + promotion.getIdPromotion() + "]";
	}


	
	
	
}//end class
