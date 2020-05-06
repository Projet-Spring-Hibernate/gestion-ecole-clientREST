package com.intiformation.client_rest_GestionEcole.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionEtudiant;
import com.intiformation.client_rest_GestionEcole.modele.Etudiant;


@Controller
public class EtudiantController {

	@Autowired
	private ClientWsRestGestionEtudiant etudiantService;

	public void setEtudiantService(ClientWsRestGestionEtudiant etudiantService) {
		this.etudiantService = etudiantService;
	}

	// ===========================================================//
	// =========== Liste All Etudiants ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les etudiants.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiants/list-all", method = RequestMethod.GET)
	public String recupListeAllEtudiant(ModelMap modele) {
		// 1. recup de la liste de tous les etudiants de la bdd
		List<Etudiant> listeEtudiants = etudiantService.getAllEtudiants();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_etudiants", listeEtudiants);

		return "listeEtudiants";
	}// end recupListeAllEtudiant

	// ===========================================================//
	// =========== Suppression Etudiant ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un etudiant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiants/supprimer/{pIdEtudiant}", method = RequestMethod.GET)
	public String supprimerEtudiant(@PathVariable("pIdEtudiant") Long pIdEtudiant, ModelMap modele) {
		// 1.Suppression
		etudiantService.deleteEtudiant(pIdEtudiant);

		return "redirect:/etudiants/list-all";
	}// end recupListeAllEtudiant

	// ===========================================================//
	// =========== Affichage formulaire ajout etudiant ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un etudiant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiants/add-etudiant-form", method = RequestMethod.GET)
	public String formulaireAjoutEtudiant(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Etudiant etudiant = new Etudiant();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("etudiant", etudiant);
		
		return "ajout_etudiant";
	}// end recupListeAllEtudiant
	
	// ===========================================================//
	// =========== Ajout etudiant ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un etudiant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiants/add", method = RequestMethod.POST)
	public String ajouterEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, ModelMap modele) {

		System.out.println("/////"+etudiant);
		// objet pour le cryptage
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// cryptage du mdp avec la methode encode
		String hashedMotDePasse = passwordEncoder.encode(etudiant.getMotdepasse());
		etudiant.setMotdepasse(hashedMotDePasse);
		
		//ajout de l'etudiant
		etudiantService.saveEtudiant(etudiant);
		
		return "redirect:/etudiants/list-all";
	}// end recupListeAllEtudiant
}// end class
