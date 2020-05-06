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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionMatiere;
import com.intiformation.client_rest_GestionEcole.modele.Matiere;


@Controller
public class MatiereController {

	@Autowired
	private ClientWsRestGestionMatiere matiereService;

	public void setMatiereService(ClientWsRestGestionMatiere matiereService) {
		this.matiereService = matiereService;
	}

	// ===========================================================//
	// =========== Liste All Matieres ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les matieres.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/matieres/list-all", method = RequestMethod.GET)
	public String recupListeAllMatiere(ModelMap modele) {
		// 1. recup de la liste de tous les matieres de la bdd
		List<Matiere> listeMatieres = matiereService.getAllMatieres();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_matieres", listeMatieres);

		return "listeMatieres";
	}// end recupListeAllMatiere

	// ===========================================================//
	// =========== Suppression Matiere ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un matiere.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/matieres/supprimer/{pIdMatiere}", method = RequestMethod.GET)
	public String supprimerMatiere(@PathVariable("pIdMatiere") Long pIdMatiere, ModelMap modele) {
		// 1.Suppression
		matiereService.deleteMatiere(pIdMatiere);

		return "redirect:/matieres/list-all";
	}// end recupListeAllMatiere

	// ===========================================================//
	// =========== Affichage formulaire ajout matiere ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un matiere.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/matieres/add-matiere-form", method = RequestMethod.GET)
	public String formulaireAjoutMatiere(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Matiere matiere = new Matiere();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("matiere", matiere);
		
		return "ajout_matiere";
	}// end recupListeAllMatiere
	
	// ===========================================================//
	// =========== Ajout matiere ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un matiere.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/matieres/add", method = RequestMethod.POST)
	public String ajouterMatiere(@ModelAttribute("matiere") Matiere matiere, ModelMap modele) {

		System.out.println("/////"+matiere);
		
		//ajout de l'matiere
		matiereService.saveMatiere(matiere);
		
		return "redirect:/matieres/list-all";
	}// end recupListeAllMatiere
}// end class

