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

import com.intiformation.client_rest_GestionEcole.client.ClientWsRestGestionPromotion;
import com.intiformation.client_rest_GestionEcole.modele.Promotion;


@Controller
public class PromotionController {

	@Autowired
	private ClientWsRestGestionPromotion promotionService;

	public void setPromotionService(ClientWsRestGestionPromotion promotionService) {
		this.promotionService = promotionService;
	}

	// ===========================================================//
	// =========== Liste All Promotions ===========================//
	// ===========================================================//
	/**
	 * Permet d'afficher la liste de tous les promotions.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/promotions/list-all", method = RequestMethod.GET)
	public String recupListeAllPromotion(ModelMap modele) {
		// 1. recup de la liste de tous les promotions de la bdd
		List<Promotion> listePromotions = promotionService.getAllPromotions();

		// 2. def des données à afficher dans la vue
		modele.addAttribute("attribut_liste_promotions", listePromotions);

		return "listePromotions";
	}// end recupListeAllPromotion

	// ===========================================================//
	// =========== Suppression Promotion ===========================//
	// ===========================================================//
	/**
	 * Permet de supprimer un promotion.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/promotions/supprimer/{pIdPromotion}", method = RequestMethod.GET)
	public String supprimerPromotion(@PathVariable("pIdPromotion") Long pIdPromotion, ModelMap modele) {
		// 1.Suppression
		promotionService.deletePromotion(pIdPromotion);

		return "redirect:/promotions/list-all";
	}// end recupListeAllPromotion

	// ===========================================================//
	// =========== Affichage formulaire ajout promotion ===========//
	// ===========================================================//
	/**
	 * Permet d'afficher le formulaire d'ajout d'un promotion.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/promotions/add-promotion-form", method = RequestMethod.GET)
	public String formulaireAjoutPromotion(ModelMap modele) {
		// 1. definition de l'objet à lier au formulaire

		Promotion promotion = new Promotion();

		// 2. envoi de l'objet de commande à la servlet de spring mvc
		// > données à envoyer vers la servlet

		modele.addAttribute("promotion", promotion);
		
		return "ajout_promotion";
	}// end recupListeAllPromotion
	
	// ===========================================================//
	// =========== Ajout promotion ================================//
	// ===========================================================//
	/**
	 * Permet d'ajouter un promotion.
	 * 
	 * @param modele
	 * @return
	 */
	@RequestMapping(value = "/promotions/add", method = RequestMethod.POST)
	public String ajouterPromotion(@ModelAttribute("promotion") Promotion promotion, ModelMap modele) {

		System.out.println("/////"+promotion);
		
		//ajout de l'promotion
		promotionService.savePromotion(promotion);
		
		return "redirect:/promotions/list-all";
	}// end recupListeAllPromotion
}// end class
