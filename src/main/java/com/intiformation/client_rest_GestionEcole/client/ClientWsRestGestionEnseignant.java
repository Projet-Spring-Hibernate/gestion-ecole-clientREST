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

import com.intiformation.client_rest_GestionEcole.modele.Enseignant;

@Repository("clientWsRestGestionEnseignant")
public class ClientWsRestGestionEnseignant {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/enseignant";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//
	// =========== Liste ALL Enseignants ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des etudiants  à partir du web service rest 
	 * @return
	 */
	public List<Enseignant> getAllEnseignants(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<Enseignant> listeEnseignant= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<Enseignant>>() {});
		
		return listeEnseignant;
	}//end getAllEnseignant
	
	
	// ===========================================================//
	// =========== get by id etudiant ============================//
	// ===========================================================//
	
	/**
	 * Recupere un etudiant par son id à partir du web service rest 
	 * @return
	 */
	public Enseignant getEnseignantById(Long idEnseignant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idEnseignant.toString());
		
		Enseignant etudiant= webTarget.request().get(Response.class)
				.readEntity(new GenericType<Enseignant>() {});
		
		return etudiant;
	}//end getEnseignantById
	
	// ===========================================================//
	// =========== save etudiant =================================//
	// ===========================================================//
	/**
	 * Ajouter un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveEnseignant(Enseignant etudiant){
		System.out.println("\n==== Je suis dans saveEnseignant coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(etudiant, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getEnseignantById
	
	
	// ===========================================================//
	// =========== update etudiant ===============================//
	// ===========================================================//
	/**
	 * Modifier un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateEnseignant(Enseignant etudiant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(etudiant.getIdentifiant().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(etudiant, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getEnseignantById
	
	
	// ===========================================================//
	// =========== delete etudiant ===============================//
	// ===========================================================//
	/**
	 * Supprimer un etudiant à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteEnseignant(Long idEnseignant){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idEnseignant.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getEnseignantById
}//End class
