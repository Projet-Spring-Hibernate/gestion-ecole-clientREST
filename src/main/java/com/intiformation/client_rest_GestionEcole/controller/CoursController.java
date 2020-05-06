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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionCours;
import com.intiformation.client_rest_GestionEcole.modele.Cours;


@Controller
public class CoursController {

	@Autowired
	private ClientWsRestGestionCours coursService;

	public void setCoursService(ClientWsRestGestionCours coursService) {
		this.coursService = coursService;
	}

	// ===========================================================//
	// =========== Liste All Courss ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les courss.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/courss/list-all", method = RequestMethod.GET)
	public String recupListeAllCours(ModelMap modele) {
		// 1. recup de la liste de tous les courss de la bdd
		List<Cours> listeCourss = coursService.getAllCourss();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_courss", listeCourss);

		return "listeCourss";
	}// end recupListeAllCours

	// ===========================================================//
	// =========== Suppression Cours ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un cours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/courss/supprimer/{pIdCours}", method = RequestMethod.GET)
	public String supprimerCours(@PathVariable("pIdCours") Long pIdCours, ModelMap modele) {
		// 1.Suppression
		coursService.deleteCours(pIdCours);

		return "redirect:/courss/list-all";
	}// end recupListeAllCours

	// ===========================================================//
	// =========== Affichage formulaire ajout cours ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un cours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/courss/add-cours-form", method = RequestMethod.GET)
	public String formulaireAjoutCours(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Cours cours = new Cours();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("cours", cours);
		
		return "ajout_cours";
	}// end recupListeAllCours
	
	// ===========================================================//
	// =========== Ajout cours ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un cours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/courss/add", method = RequestMethod.POST)
	public String ajouterCours(@ModelAttribute("cours") Cours cours, ModelMap modele) {

		System.out.println("/////"+cours);
		
		//ajout de l'cours
		coursService.saveCours(cours);
		
		return "redirect:/courss/list-all";
	}// end recupListeAllCours
}// end class
