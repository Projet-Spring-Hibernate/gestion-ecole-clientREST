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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionAdministrateur;
import com.intiformation.client_rest_GestionEcole.modele.Administrateur;


@Controller
public class AdministrateurController {

	@Autowired
	private ClientWsRestGestionAdministrateur administrateurService;

	public void setAdministrateurService(ClientWsRestGestionAdministrateur administrateurService) {
		this.administrateurService = administrateurService;
	}

	// ===========================================================//
	// =========== Liste All Administrateurs ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les administrateurs.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/administrateurs/list-all", method = RequestMethod.GET)
	public String recupListeAllAdministrateur(ModelMap modele) {
		// 1. recup de la liste de tous les administrateurs de la bdd
		List<Administrateur> listeAdministrateurs = administrateurService.getAllAdministrateurs();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_administrateurs", listeAdministrateurs);

		return "listeAdministrateurs";
	}// end recupListeAllAdministrateur

	// ===========================================================//
	// =========== Suppression Administrateur ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un administrateur.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/administrateurs/supprimer/{pIdAdministrateur}", method = RequestMethod.GET)
	public String supprimerAdministrateur(@PathVariable("pIdAdministrateur") Long pIdAdministrateur, ModelMap modele) {
		// 1.Suppression
		administrateurService.deleteAdministrateur(pIdAdministrateur);

		return "redirect:/administrateurs/list-all";
	}// end recupListeAllAdministrateur

	// ===========================================================//
	// =========== Affichage formulaire ajout administrateur ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un administrateur.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/administrateurs/add-administrateur-form", method = RequestMethod.GET)
	public String formulaireAjoutAdministrateur(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Administrateur administrateur = new Administrateur();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("administrateur", administrateur);
		
		return "ajout_administrateur";
	}// end recupListeAllAdministrateur
	
	// ===========================================================//
	// =========== Ajout administrateur ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un administrateur.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/administrateurs/add", method = RequestMethod.POST)
	public String ajouterAdministrateur(@ModelAttribute("administrateur") Administrateur administrateur, ModelMap modele) {

		System.out.println("/////"+administrateur);
		// objet pour le cryptage
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// cryptage du mdp avec la methode encode
		String hashedMotDePasse = passwordEncoder.encode(administrateur.getMotdepasse());
		administrateur.setMotdepasse(hashedMotDePasse);
		
		//ajout de l'administrateur
		administrateurService.saveAdministrateur(administrateur);
		
		return "redirect:/administrateurs/list-all";
	}// end recupListeAllAdministrateur
}// end class
