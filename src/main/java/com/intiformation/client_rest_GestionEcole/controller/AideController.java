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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionAide;
import com.intiformation.client_rest_GestionEcole.modele.Aide;


@Controller
public class AideController {

	@Autowired
	private ClientWsRestGestionAide aideService;

	public void setAideService(ClientWsRestGestionAide aideService) {
		this.aideService = aideService;
	}

	// ===========================================================//
	// =========== Liste All Aides ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les aides.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/aides/list-all", method = RequestMethod.GET)
	public String recupListeAllAide(ModelMap modele) {
		// 1. recup de la liste de tous les aides de la bdd
		List<Aide> listeAides = aideService.getAllAides();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_aides", listeAides);

		return "listeAides";
	}// end recupListeAllAide

	// ===========================================================//
	// =========== Suppression Aide ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un aide.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/aides/supprimer/{pIdAide}", method = RequestMethod.GET)
	public String supprimerAide(@PathVariable("pIdAide") Long pIdAide, ModelMap modele) {
		// 1.Suppression
		aideService.deleteAide(pIdAide);

		return "redirect:/aides/list-all";
	}// end recupListeAllAide

	// ===========================================================//
	// =========== Affichage formulaire ajout aide ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un aide.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/aides/add-aide-form", method = RequestMethod.GET)
	public String formulaireAjoutAide(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Aide aide = new Aide();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("aide", aide);
		
		return "ajout_aide";
	}// end recupListeAllAide
	
	// ===========================================================//
	// =========== Ajout aide ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un aide.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/aides/add", method = RequestMethod.POST)
	public String ajouterAide(@ModelAttribute("aide") Aide aide, ModelMap modele) {

		System.out.println("/////"+aide);
		
		//ajout de l'aide
		aideService.saveAide(aide);
		
		return "redirect:/aides/list-all";
	}// end recupListeAllAide
}// end class
