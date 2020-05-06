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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionExercice;
import com.intiformation.client_rest_GestionEcole.modele.Exercice;


@Controller
public class ExerciceController {

	@Autowired
	private ClientWsRestGestionExercice exerciceService;

	public void setExerciceService(ClientWsRestGestionExercice exerciceService) {
		this.exerciceService = exerciceService;
	}

	// ===========================================================//
	// =========== Liste All Exercices ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les exercices.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/exercices/list-all", method = RequestMethod.GET)
	public String recupListeAllExercice(ModelMap modele) {
		// 1. recup de la liste de tous les exercices de la bdd
		List<Exercice> listeExercices = exerciceService.getAllExercices();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_exercices", listeExercices);

		return "listeExercices";
	}// end recupListeAllExercice

	// ===========================================================//
	// =========== Suppression Exercice ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un exercice.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/exercices/supprimer/{pIdExercice}", method = RequestMethod.GET)
	public String supprimerExercice(@PathVariable("pIdExercice") Long pIdExercice, ModelMap modele) {
		// 1.Suppression
		exerciceService.deleteExercice(pIdExercice);

		return "redirect:/exercices/list-all";
	}// end recupListeAllExercice

	// ===========================================================//
	// =========== Affichage formulaire ajout exercice ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un exercice.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/exercices/add-exercice-form", method = RequestMethod.GET)
	public String formulaireAjoutExercice(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Exercice exercice = new Exercice();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("exercice", exercice);
		
		return "ajout_exercice";
	}// end recupListeAllExercice
	
	// ===========================================================//
	// =========== Ajout exercice ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un exercice.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/exercices/add", method = RequestMethod.POST)
	public String ajouterExercice(@ModelAttribute("exercice") Exercice exercice, ModelMap modele) {

		System.out.println("/////"+exercice);
		
		//ajout de l'exercice
		exerciceService.saveExercice(exercice);
		
		return "redirect:/exercices/list-all";
	}// end recupListeAllExercice
}// end class
