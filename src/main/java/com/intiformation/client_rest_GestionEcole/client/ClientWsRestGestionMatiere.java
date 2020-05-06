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

import com.intiformation.client_rest_GestionEcole.modele.Matiere;

@Repository("clientWsRestGestionMatiere")
public class ClientWsRestGestionMatiere {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/matiere";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Matieres ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des matieres  à partir du web service rest 
	 * @return
	 */
	public List<Matiere> getAllMatieres(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Matiere> listeMatiere= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Matiere>>() {});
		
		return listeMatiere;
	}//end getAllMatiere
	
	
	// ===========================================================//
	// =========== get by id matiere ============================//
	// ===========================================================//
	
	/**
	 * Recupere un matiere par son id à partir du web service rest 
	 * @return
	 */
	public Matiere getMatiereById(Long idMatiere){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idMatiere.toString());
		
		Matiere matiere= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Matiere>() {});
		
		return matiere;
	}//end getMatiereById
	
	// ===========================================================//
	// =========== save matiere =================================//
	// ===========================================================//
	/**
	 * Ajouter un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveMatiere(Matiere matiere){
		System.out.println("\n==== Je suis dans saveMatiere coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(matiere, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getMatiereById
	
	
	// ===========================================================//
	// =========== update matiere ===============================//
	// ===========================================================//
	/**
	 * Modifier un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateMatiere(Matiere matiere){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(matiere.getIdMatiere().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(matiere, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getMatiereById
	
	
	// ===========================================================//
	// =========== delete matiere ===============================//
	// ===========================================================//
	/**
	 * Supprimer un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteMatiere(Long idMatiere){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idMatiere.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getMatiereById
}//End class
