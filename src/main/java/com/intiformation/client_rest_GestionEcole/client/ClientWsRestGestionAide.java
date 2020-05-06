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

import com.intiformation.client_rest_GestionEcole.modele.Aide;

@Repository("clientWsRestGestionAide")
public class ClientWsRestGestionAide {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/aide";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Aides ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des aides  à partir du web service rest 
	 * @return
	 */
	public List<Aide> getAllAides(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Aide> listeAide= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Aide>>() {});
		
		return listeAide;
	}//end getAllAide
	
	
	// ===========================================================//
	// =========== get by id aide ============================//
	// ===========================================================//
	
	/**
	 * Recupere un aide par son id à partir du web service rest 
	 * @return
	 */
	public Aide getAideById(Long idAide){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idAide.toString());
		
		Aide aide= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Aide>() {});
		
		return aide;
	}//end getAideById
	
	// ===========================================================//
	// =========== save aide =================================//
	// ===========================================================//
	/**
	 * Ajouter un aide à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveAide(Aide aide){
		System.out.println("\n==== Je suis dans saveAide coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(aide, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getAideById
	
	
	// ===========================================================//
	// =========== update aide ===============================//
	// ===========================================================//
	/**
	 * Modifier un aide à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateAide(Aide aide){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(aide.getId_aide().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(aide, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getAideById
	
	
	// ===========================================================//
	// =========== delete aide ===============================//
	// ===========================================================//
	/**
	 * Supprimer un aide à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteAide(Long idAide){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idAide.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getAideById
}//End class
