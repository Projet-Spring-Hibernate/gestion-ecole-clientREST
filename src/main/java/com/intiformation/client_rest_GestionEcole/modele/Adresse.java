package com.intiformation.client_rest_GestionEcole.modele;



/**
 * Classe entity pour les adresses. Reliée à la classe Personne par une relation OneToONe
 * 
 * @author Marie
 *
 */

public class Adresse {

	/* _________________Propriétés_______________ */

	private Long adresse_id;
	

	private String rue;

	private String codePostal;


	private String ville;
	
	// Association avec Personne
	private Personne personne;


	/* _______________Constructeurs_______________ */
	/**
	 * Ctor vide.
	 */
	public Adresse() {
		super();
	}
	
	public Adresse(Long adresse_id, String rue, String codePostal, String ville) {
		super();
		this.adresse_id = adresse_id;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	/* _______________getter Setter_______________ */

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}


	public Long getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(Long adresse_id) {
		this.adresse_id = adresse_id;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	
	//________________ Méthodes ____________________//
	
	/**
	 * Permet d'attribuer une personne à une adresse et cette à adresse à la personne.
	 * @param personne
	 */
	public void addPersonne(Personne personne) {
		this.personne=personne;
		personne.setAdresse(this);
	}
	
	
	@Override
	public String toString() {
		return "Adresse [personne_id=" + adresse_id + ", rue=" + rue + ", codePostal=" + codePostal + ", ville="
				+ ville + "]";
	}


	
	
	
}// end classe
