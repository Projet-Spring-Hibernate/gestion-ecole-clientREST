package com.intiformation.client_rest_GestionEcole.modele;


import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Classe entity pour les matières.
 * Relation triple avec Enseignant et Promotion
 * Relation ManyToMany avec Enseignant.
 * Relation ManyToMany avec Promotion.
 * @author Thanesh
 *
 */
@XmlRootElement
@XmlType(propOrder= {"idMatiere","libelle"})
public class Matiere {


	/*_______________prop_______________*/

	private Long idMatiere;
	
	
	private String libelle;
	

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

	
	
	@Override
	public String toString() {
		return "Matiere [idMatiere=" + idMatiere + ", libelle=" + libelle + "]";
	}
	
}//end class
