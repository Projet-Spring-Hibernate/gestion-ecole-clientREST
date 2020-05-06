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

import com.intiformation.client_rest_GestionEcole.modele.Cours;

@Repository("clientWsRestGestionCours")
public class ClientWsRestGestionCours {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/cours";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Courss ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des courss  à partir du web service rest 
	 * @return
	 */
	public List<Cours> getAllCourss(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Cours> listeCours= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Cours>>() {});
		
		return listeCours;
	}//end getAllCours
	
	
	// ===========================================================//
	// =========== get by id cours ============================//
	// ===========================================================//
	
	/**
	 * Recupere un cours par son id à partir du web service rest 
	 * @return
	 */
	public Cours getCoursById(Long idCours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idCours.toString());
		
		Cours cours= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Cours>() {});
		
		return cours;
	}//end getCoursById
	
	// ===========================================================//
	// =========== save cours =================================//
	// ===========================================================//
	/**
	 * Ajouter un cours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveCours(Cours cours){
		System.out.println("\n==== Je suis dans saveCours coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(cours, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getCoursById
	
	
	// ===========================================================//
	// =========== update cours ===============================//
	// ===========================================================//
	/**
	 * Modifier un cours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateCours(Cours cours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(cours.getIdCours().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(cours, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getCoursById
	
	
	// ===========================================================//
	// =========== delete cours ===============================//
	// ===========================================================//
	/**
	 * Supprimer un cours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteCours(Long idCours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idCours.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getCoursById
}//End class
