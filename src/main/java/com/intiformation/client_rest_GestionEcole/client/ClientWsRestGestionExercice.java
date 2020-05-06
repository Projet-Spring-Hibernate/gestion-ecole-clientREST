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

import com.intiformation.client_rest_GestionEcole.modele.Exercice;

@Repository("clientWsRestGestionExercice")
public class ClientWsRestGestionExercice {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/exercice";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Exercices ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des exercices  à partir du web service rest 
	 * @return
	 */
	public List<Exercice> getAllExercices(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Exercice> listeExercice= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Exercice>>() {});
		
		return listeExercice;
	}//end getAllExercice
	
	
	// ===========================================================//
	// =========== get by id exercice ============================//
	// ===========================================================//
	
	/**
	 * Recupere un exercice par son id à partir du web service rest 
	 * @return
	 */
	public Exercice getExerciceById(Long idExercice){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idExercice.toString());
		
		Exercice exercice= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Exercice>() {});
		
		return exercice;
	}//end getExerciceById
	
	// ===========================================================//
	// =========== save exercice =================================//
	// ===========================================================//
	/**
	 * Ajouter un exercice à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveExercice(Exercice exercice){
		System.out.println("\n==== Je suis dans saveExercice coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(exercice, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getExerciceById
	
	
	// ===========================================================//
	// =========== update exercice ===============================//
	// ===========================================================//
	/**
	 * Modifier un exercice à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateExercice(Exercice exercice){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(exercice.getIdExercice().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(exercice, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getExerciceById
	
	
	// ===========================================================//
	// =========== delete exercice ===============================//
	// ===========================================================//
	/**
	 * Supprimer un exercice à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteExercice(Long idExercice){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idExercice.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getExerciceById
}//End class
