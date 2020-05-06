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

import com.intiformation.client_rest_GestionEcole.modele.Adresse;

@Repository("clientWsRestGestionAdresse")
public class ClientWsRestGestionAdresse {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/adresse";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Adresses ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des adresses  à partir du web service rest 
	 * @return
	 */
	public List<Adresse> getAllAdresses(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Adresse> listeAdresse= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Adresse>>() {});
		
		return listeAdresse;
	}//end getAllAdresse
	
	
	// ===========================================================//
	// =========== get by id adresse ============================//
	// ===========================================================//
	
	/**
	 * Recupere un adresse par son id à partir du web service rest 
	 * @return
	 */
	public Adresse getAdresseById(Long idAdresse){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idAdresse.toString());
		
		Adresse adresse= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Adresse>() {});
		
		return adresse;
	}//end getAdresseById
	
	// ===========================================================//
	// =========== save adresse =================================//
	// ===========================================================//
	/**
	 * Ajouter un adresse à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveAdresse(Adresse adresse){
		System.out.println("\n==== Je suis dans saveAdresse coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(adresse, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getAdresseById
	
	
	// ===========================================================//
	// =========== update adresse ===============================//
	// ===========================================================//
	/**
	 * Modifier un adresse à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateAdresse(Adresse adresse){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(adresse.getAdresse_id().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(adresse, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getAdresseById
	
	
	// ===========================================================//
	// =========== delete adresse ===============================//
	// ===========================================================//
	/**
	 * Supprimer un adresse à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteAdresse(Long idAdresse){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idAdresse.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getAdresseById
}//End class
