package com.intiformation.client_rest_GestionEcole.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Repository;

import com.intiformation.client_rest_GestionEcole.modele.Promotion;

@Repository("clientWsRestGestionPromotion")
public class ClientWsRestGestionPromotion {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/promotion";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Promotions ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des promotions  à partir du web service rest 
	 * @return
	 */
	public List<Promotion> getAllPromotions(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Promotion> listePromotion= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Promotion>>() {});
		
		return listePromotion;
	}//end getAllPromotion
	
	
	// ===========================================================//
	// =========== get by id promotion ============================//
	// ===========================================================//
	
	/**
	 * Recupere un promotion par son id à partir du web service rest 
	 * @return
	 */
	public Promotion getPromotionById(Long idPromotion){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idPromotion.toString());
		
		Promotion promotion= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Promotion>() {});
		
		return promotion;
	}//end getPromotionById
	
	// ===========================================================//
	// =========== save promotion =================================//
	// ===========================================================//
	/**
	 * Ajouter un promotion à la bdd à partir du web service rest 
	 * @return
	 */
	public Response savePromotion(Promotion promotion){
		System.out.println("\n==== Je suis dans savePromotion coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(promotion, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getPromotionById
	
	
	// ===========================================================//
	// =========== update promotion ===============================//
	// ===========================================================//
	/**
	 * Modifier un promotion à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updatePromotion(Promotion promotion){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(promotion.getIdPromotion().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(promotion, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getPromotionById
	
	
	// ===========================================================//
	// =========== delete promotion ===============================//
	// ===========================================================//
	/**
	 * Supprimer un promotion à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deletePromotion(Long idPromotion){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idPromotion.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getPromotionById
}//End class
