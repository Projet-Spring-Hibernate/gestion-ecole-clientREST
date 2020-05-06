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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionAdresse;
import com.intiformation.client_rest_GestionEcole.modele.Adresse;


@Controller
public class AdresseController {

	@Autowired
	private ClientWsRestGestionAdresse adresseService;

	public void setAdresseService(ClientWsRestGestionAdresse adresseService) {
		this.adresseService = adresseService;
	}

	// ===========================================================//
	// =========== Liste All Adresses ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les adresses.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/adresses/list-all", method = RequestMethod.GET)
	public String recupListeAllAdresse(ModelMap modele) {
		// 1. recup de la liste de tous les adresses de la bdd
		List<Adresse> listeAdresses = adresseService.getAllAdresses();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_adresses", listeAdresses);

		return "listeAdresses";
	}// end recupListeAllAdresse

	// ===========================================================//
	// =========== Suppression Adresse ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un adresse.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/adresses/supprimer/{pIdAdresse}", method = RequestMethod.GET)
	public String supprimerAdresse(@PathVariable("pIdAdresse") Long pIdAdresse, ModelMap modele) {
		// 1.Suppression
		adresseService.deleteAdresse(pIdAdresse);

		return "redirect:/adresses/list-all";
	}// end recupListeAllAdresse

	// ===========================================================//
	// =========== Affichage formulaire ajout adresse ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un adresse.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/adresses/add-adresse-form", method = RequestMethod.GET)
	public String formulaireAjoutAdresse(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Adresse adresse = new Adresse();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("adresse", adresse);
		
		return "ajout_adresse";
	}// end recupListeAllAdresse
	
	// ===========================================================//
	// =========== Ajout adresse ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un adresse.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/adresses/add", method = RequestMethod.POST)
	public String ajouterAdresse(@ModelAttribute("adresse") Adresse adresse, ModelMap modele) {

		System.out.println("/////"+adresse);
		
		//ajout de l'adresse
		adresseService.saveAdresse(adresse);
		
		return "redirect:/adresses/list-all";
	}// end recupListeAllAdresse
}// end class
