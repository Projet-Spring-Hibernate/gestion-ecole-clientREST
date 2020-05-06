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

import com.intiformation.client_rest_GestionEcole.modele.Administrateur;

@Repository("clientWsRestGestionAdministrateur")
public class ClientWsRestGestionAdministrateur {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/administrateur";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Administrateurs ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des administrateurs  à partir du web service rest 
	 * @return
	 */
	public List<Administrateur> getAllAdministrateurs(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Administrateur> listeAdministrateur= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Administrateur>>() {});
		
		return listeAdministrateur;
	}//end getAllAdministrateur
	
	
	// ===========================================================//
	// =========== get by id administrateur ============================//
	// ===========================================================//
	
	/**
	 * Recupere un administrateur par son id à partir du web service rest 
	 * @return
	 */
	public Administrateur getAdministrateurById(Long idAdministrateur){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idAdministrateur.toString());
		
		Administrateur administrateur= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Administrateur>() {});
		
		return administrateur;
	}//end getAdministrateurById
	
	// ===========================================================//
	// =========== save administrateur =================================//
	// ===========================================================//
	/**
	 * Ajouter un administrateur à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveAdministrateur(Administrateur administrateur){
		System.out.println("\n==== Je suis dans saveAdministrateur coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(administrateur, MediaType.APPLICATION_JSON));
		
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getAdministrateurById
	
	
	// ===========================================================//
	// =========== update administrateur ===============================//
	// ===========================================================//
	/**
	 * Modifier un administrateur à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateAdministrateur(Administrateur administrateur){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(administrateur.getIdentifiant().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(administrateur, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getAdministrateurById
	
	
	// ===========================================================//
	// =========== delete administrateur ===============================//
	// ===========================================================//
	/**
	 * Supprimer un administrateur à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteAdministrateur(Long idAdministrateur){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idAdministrateur.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getAdministrateurById
}//End class
