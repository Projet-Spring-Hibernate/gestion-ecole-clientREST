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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionEtudiantCours;
import com.intiformation.client_rest_GestionEcole.modele.EtudiantCours;


@Controller
public class EtudiantCoursController {

	@Autowired
	private ClientWsRestGestionEtudiantCours etudiantCoursService;

	public void setEtudiantCoursService(ClientWsRestGestionEtudiantCours etudiantCoursService) {
		this.etudiantCoursService = etudiantCoursService;
	}

	// ===========================================================//
	// =========== Liste All EtudiantCours ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les etudiantCours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiantsCours/list-all", method = RequestMethod.GET)
	public String recupListeAllEtudiantCours(ModelMap modele) {
		// 1. recup de la liste de tous les etudiantCours de la bdd
		List<EtudiantCours> listeEtudiantCours = etudiantCoursService.getAllEtudiantCours();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_etudiantCours", listeEtudiantCours);

		return "listeEtudiantCours";
	}// end recupListeAllEtudiantCours

	// ===========================================================//
	// =========== Suppression EtudiantCours ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un etudiantCours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiantCours/supprimer/{pIdEtudiantCours}", method = RequestMethod.GET)
	public String supprimerEtudiantCours(@PathVariable("pIdEtudiantCours") Long pIdEtudiantCours, ModelMap modele) {
		// 1.Suppression
		etudiantCoursService.deleteEtudiantCours(pIdEtudiantCours);

		return "redirect:/etudiantsCours/list-all";
	}// end recupListeAllEtudiantCours

	// ===========================================================//
	// =========== Affichage formulaire ajout etudiantCours ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un etudiantCours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiantCours/add-etudiantCours-form", method = RequestMethod.GET)
	public String formulaireAjoutEtudiantCours(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		EtudiantCours etudiantCours = new EtudiantCours();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("etudiantCours", etudiantCours);
		
		return "ajout_etudiantCours";
	}// end recupListeAllEtudiantCours
	
	// ===========================================================//
	// =========== Ajout etudiantCours ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un etudiantCours.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/etudiantCours/add", method = RequestMethod.POST)
	public String ajouterEtudiantCours(@ModelAttribute("etudiantCours") EtudiantCours etudiantCours, ModelMap modele) {

		System.out.println("/////"+etudiantCours);
		
		//ajout de l'etudiantCours
		etudiantCoursService.saveEtudiantCours(etudiantCours);
		
		return "redirect:/etudiantsCours/list-all";
	}// end recupListeAllEtudiantCours
}// end class
