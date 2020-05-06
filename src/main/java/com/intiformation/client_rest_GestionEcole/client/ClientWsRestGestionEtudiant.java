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

import com.intiformation.client_rest_GestionEcole.modele.Etudiant;

@Repository("clientWsRestGestionEtudiant")
public class ClientWsRestGestionEtudiant {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/etudiant";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Etudiants ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des etudiants  à partir du web service rest 
	 * @return
	 */
	public List<Etudiant> getAllEtudiants(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Etudiant> listeEtudiant= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Etudiant>>() {});
		
		return listeEtudiant;
	}//end getAllEtudiant
	
	
	// ===========================================================//
	// =========== get by id etudiant ============================//
	// ===========================================================//
	
	/**
	 * Recupere un etudiant par son id à partir du web service rest 
	 * @return
	 */
	public Etudiant getEtudiantById(Long idEtudiant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idEtudiant.toString());
		
		Etudiant etudiant= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Etudiant>() {});
		
		return etudiant;
	}//end getEtudiantById
	
	// ===========================================================//
	// =========== save etudiant =================================//
	// ===========================================================//
	/**
	 * Ajouter un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveEtudiant(Etudiant etudiant){
		System.out.println("\n==== Je suis dans saveEtudiant coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(etudiant, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getEtudiantById
	
	
	// ===========================================================//
	// =========== update etudiant ===============================//
	// ===========================================================//
	/**
	 * Modifier un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateEtudiant(Etudiant etudiant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(etudiant.getIdentifiant().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(etudiant, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getEtudiantById
	
	
	// ===========================================================//
	// =========== delete etudiant ===============================//
	// ===========================================================//
	/**
	 * Supprimer un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteEtudiant(Long idEtudiant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idEtudiant.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getEtudiantById
}//End class
