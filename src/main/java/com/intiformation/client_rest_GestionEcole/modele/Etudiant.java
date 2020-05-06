package com.intiformation.client_rest_GestionEcole.modele;

import java.util.ArrayList;
import java.util.List;



/**
 * Classe entity pour les administrateurs. Classe fille de la classe Personne.
 * Relation ManyToMany avec Cours
 * Relation ManyToMany avec Promotion ===> A VERIFIER 
 * @author Lise
 *
 */

public class Etudiant extends Personne{
	
	/*____________________props____________________*/

	private String photo;
	

	private String dateDeNaissance;


	private List<Promotion> listePromotion=new ArrayList<Promotion>();
	

	private List<EtudiantCours> listeEtudiantCours =new ArrayList<EtudiantCours>();
	
	/*____________________ctors____________________*/

	
	
	public Etudiant(String photo, String dateDeNaissance) {
		super();
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}


	public Etudiant(Long identifiant, String motdepasse, String nom, String prenom, String email,String photo, String dateDeNaissance) {
		super(identifiant, motdepasse, nom, prenom, email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
		// TODO Auto-generated constructor stub
	}


	public Etudiant(String motdepasse, String nom, String prenom, String email, String photo, String dateDeNaissance) {
		super(motdepasse, nom, prenom, email);
		this.photo = photo;
		this.dateDeNaissance = dateDeNaissance;
	}


	public Etudiant() {
		super();
	}


	
	
	/*________________getters/setter____________________*/
	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getDateDeNaissance() {
		return dateDeNaissance;
	}


	public void setDateDeNaissance(String dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	

//	public List<Cours> getListeCours() {
//		return listeCours;
//	}
//
//
//	public void setListeCours(List<Cours> listeCours) {
//		this.listeCours = listeCours;
//	}
//	


	public List<EtudiantCours> getListeEtudiantCours() {
		return listeEtudiantCours;
	}


	public void setListeEtudiantCours(List<EtudiantCours> listeEtudiantCours) {
		this.listeEtudiantCours = listeEtudiantCours;
	}


	public List<Promotion> getListePromotion() {
		return listePromotion;
	}


	public void setListePromotion(List<Promotion> listePromotion) {
		this.listePromotion = listePromotion;
	}

	// ================== Méthodes ==========================//

	/**
	 * Ajoute une promotion à la liste des promotions de l'étudiant + ajoute l'étudiant à la liste des étudiants de la promotion
	 * @param promotion
	 */
	public void addPromotion(Promotion promotion) {
		this.listePromotion.add(promotion);
		promotion.getListeEtudiant().add(this);
	}
	
//	/**
//	 * Ajoute un cours à la liste des cours de l'étudiant+ ajoute l'étudiant à la liste des etudiants du cours
//	 * @param cours
//	 */
//	public void addCours(Cours cours) {
//		this.listeCours.add(cours);
//		cours.getListeEtudiant().add(this);
//	}
	
	/**
	 * Ajoute un etudiantCours (table de jointure ) à la liste des etudiantCours de l'étudiant + attribut l'étudiant à la propriété etudiant de l'étudiantCours
	 * @param etudiantCours
	 */
	public void addEtudiantCours(EtudiantCours etudiantCours) {
		this.listeEtudiantCours.add(etudiantCours);
		etudiantCours.setEtudiant(this);
	}
	
	
	
	@Override
	public String toString() {
		return "Etudiant [identifiant=" + super.getIdentifiant() + ", motdepasse=" + super.getMotdepasse() + ", nom=" + super.getNom() + ", prenom="
				+ super.getPrenom() + ", email=" + super.getEmail() + ", photo=" + photo + ", dateDeNaissance=" + dateDeNaissance + ", adresse="+super.getAdresse()+"]";
	}

}
