package com.intiformation.client_rest_GestionEcole.modele;

import java.io.Serializable;


/**
 * Classe Entité de Personne. Classe mère de Administrateur, Enseignant et Etudiant
 * Relation OneToOne avec Adresse
 * @author Marie
 *
 */

public class Personne implements Serializable {

	/*_______________Propriétés_______________*/

	private Long identifiant;
	

	private String motdepasse;
	

	private String nom;
	

	private String prenom;
	

	private String email;
	
	// Association avec Adresse

	private Adresse adresse;
	
	
	/*_______________Constructeurs_______________*/

	/**
	 * Ctor vide.
	 */
	public Personne() {
	}

	public Personne(Long identifiant, String motdepasse, String nom, String prenom, String email) {
		super();
		this.identifiant = identifiant;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	public Personne(String motdepasse, String nom, String prenom, String email) {
		super();
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	
	/*_______________getter Setter_______________*/

	public Long getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	//_______________________Méthodes ___________________//
	
	/**
	 * Attribut une adresse à la propriété adresse de la personne + attribut la personne à l'attribut personne de l'adresse
	 * @param adresse
	 */
	public void addAdresse(Adresse adresse) {
		this.adresse=adresse;
		adresse.setPersonne(this);
	}
	
	@Override
	public String toString() {
		return "Personne [identifiant=" + identifiant + ", motdepasse=" + motdepasse + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", adresse="+adresse+"]";
	}
}//end class
