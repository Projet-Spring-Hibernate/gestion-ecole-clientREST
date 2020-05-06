package com.intiformation.client_rest_GestionEcole.modele;

/**
 * Classe  pour les administrateurs. Classe fille de la classe Personne.
 * @author Laure
 *
 */

public class Administrateur extends Personne {

	// _______________ Constructeurs _______________ //
	
	/**
	 * Ctor vide.
	 */
	public Administrateur() {
		super();
		
	}

	public Administrateur(Long identifiant, String motdepasse, String nom, String prenom, String email) {
		super(identifiant, motdepasse, nom, prenom, email);
		
	}

	public Administrateur(String motdepasse, String nom, String prenom, String email) {
		super(motdepasse, nom, prenom, email);
		
	}

	//_____________ Méthodes _____________//
	@Override
	public String toString() {
		return "Administrateur [identifiant=" + super.getIdentifiant() + ", motdepasse=" + super.getMotdepasse() + ", nom=" + super.getNom() + ", prenom="
				+ super.getPrenom() + ", email=" + super.getEmail() + "]";
	}
	
}//end class
