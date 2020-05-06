package com.intiformation.client_rest_GestionEcole.modele;

import java.util.ArrayList;
import java.util.List;



/**
 * Classe entity pour les administrateurs. Classe fille de la classe Personne.
 * Relation triple avec Matière et Promotion
 * Relation ManyToMany avec Matiere.
 * Relation ManyToMany avec Promotion.
 * 
 * @author Thanesh
 *
 */

public class Enseignant extends Personne {

	/*_______________prop_______________*/


	private List<EnseignantMatierePromotion> listeEnseignantMatierePromotion = new ArrayList<EnseignantMatierePromotion>();
	
	

	/*_______________ctor_______________*/

	public Enseignant() {
	}
	
	public Enseignant(Long identifiant,String motdepasse, String nom, String prenom, String email) {
		super(identifiant,motdepasse,nom,prenom,email);
	}
	
	public Enseignant(String motdepasse, String nom, String prenom, String email) {
		super(motdepasse,nom,prenom,email);
	}

	
	/*_______________get/set_______________*/

//	}
	
	public List<EnseignantMatierePromotion> getListeEnseignantMatierePromotion() {
		return listeEnseignantMatierePromotion;
	}

	public void setListeEnseignantMatierePromotion(List<EnseignantMatierePromotion> listeEnseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion = listeEnseignantMatierePromotion;
	}
	
	//_____________ Méthodes _________________________//
	

	public void addEnseignantMatierePromotion(EnseignantMatierePromotion enseignantMatierePromotion) {
		this.listeEnseignantMatierePromotion.add(enseignantMatierePromotion);
		enseignantMatierePromotion.setEnseignant(this);
	}
	
	
	@Override
	public String toString() {
		return "Enseignant [identifiant=" + super.getIdentifiant() + ", motdepasse=" + super.getMotdepasse() + ", nom=" + super.getNom() + ", prenom="
				+ super.getPrenom() + ", email=" + super.getEmail() + "]";
	}


	
	
}//end classe
