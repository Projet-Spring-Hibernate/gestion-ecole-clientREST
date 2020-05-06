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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionEnseignant;
import com.intiformation.client_rest_GestionEcole.modele.Enseignant;


@Controller
public class EnseignantController {

	@Autowired
	private ClientWsRestGestionEnseignant enseignantService;

	public void setEnseignantService(ClientWsRestGestionEnseignant enseignantService) {
		this.enseignantService = enseignantService;
	}

	// ===========================================================//
	// =========== Liste All Enseignants ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les enseignants.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/enseignants/list-all", method = RequestMethod.GET)
	public String recupListeAllEnseignant(ModelMap modele) {
		// 1. recup de la liste de tous les enseignants de la bdd
		List<Enseignant> listeEnseignants = enseignantService.getAllEnseignants();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_enseignants", listeEnseignants);

		return "listeEnseignants";
	}// end recupListeAllEnseignant

	// ===========================================================//
	// =========== Suppression Enseignant ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un enseignant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/enseignants/supprimer/{pIdEnseignant}", method = RequestMethod.GET)
	public String supprimerEnseignant(@PathVariable("pIdEnseignant") Long pIdEnseignant, ModelMap modele) {
		// 1.Suppression
		enseignantService.deleteEnseignant(pIdEnseignant);

		return "redirect:/enseignants/list-all";
	}// end recupListeAllEnseignant

	// ===========================================================//
	// =========== Affichage formulaire ajout enseignant ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un enseignant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/enseignants/add-enseignant-form", method = RequestMethod.GET)
	public String formulaireAjoutEnseignant(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Enseignant enseignant = new Enseignant();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("enseignant", enseignant);
		
		return "ajout_enseignant";
	}// end recupListeAllEnseignant
	
	// ===========================================================//
	// =========== Ajout enseignant ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un enseignant.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/enseignants/add", method = RequestMethod.POST)
	public String ajouterEnseignant(@ModelAttribute("enseignant") Enseignant enseignant, ModelMap modele) {

		System.out.println("/////"+enseignant);
		// objet pour le cryptage
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		// cryptage du mdp avec la methode encode
		String hashedMotDePasse = passwordEncoder.encode(enseignant.getMotdepasse());
		enseignant.setMotdepasse(hashedMotDePasse);
		
		//ajout de l'enseignant
		enseignantService.saveEnseignant(enseignant);
		
		return "redirect:/enseignants/list-all";
	}// end recupListeAllEnseignant
}// end class

