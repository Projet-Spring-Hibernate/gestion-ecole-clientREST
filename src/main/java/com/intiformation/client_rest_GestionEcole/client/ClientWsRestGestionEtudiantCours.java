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

import com.intiformation.client_rest_GestionEcole.modele.EtudiantCours;

@Repository("clientWsRestGestionEtudiantCours")
public class ClientWsRestGestionEtudiantCours {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/etudiantCours";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	
	
	// ===========================================================//

	// =========== Liste ALL Etudiantcours ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des etudiantcours  à partir du web service rest 
=======
	// =========== Liste ALL EtudiantCours ===========================//
	// ===========================================================//
	
	/**
	 * Recupere la liste des etudiantCours  à partir du web service rest 
>>>>>>> 9c29f64e49e754fb9cb9dacca94914a13d7b714a
	 * @return
	 */
	public List<EtudiantCours> getAllEtudiantCours(){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-all");
		
		List<EtudiantCours> listeEtudiantCours= webTarget.request().get(Response.class)
				.readEntity(new GenericType<List<EtudiantCours>>() {});
		
		return listeEtudiantCours;
	}//end getAllEtudiantCours
	
	
	// ===========================================================//
	// =========== get by id etudiantCours ============================//
	// ===========================================================//
	
	/**
	 * Recupere un etudiantCours par son id à partir du web service rest 
	 * @return
	 */
	public EtudiantCours getEtudiantCoursById(Long idEtudiantCours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("get-by-id").path(idEtudiantCours.toString());
		
		EtudiantCours etudiantCours= webTarget.request().get(Response.class)
				.readEntity(new GenericType<EtudiantCours>() {});
		
		return etudiantCours;
	}//end getEtudiantCoursById
	
	// ===========================================================//
	// =========== save etudiantCours =================================//
	// ===========================================================//
	/**
	 * Ajouter un etudiantCours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response saveEtudiantCours(EtudiantCours etudiantCours){
		System.out.println("\n==== Je suis dans saveEtudiantCours coté client" );
		webTarget=clientWs.target(WS_BASE_URL).path("save");
		System.out.println(webTarget.getUri());
		Response reponseAjout= webTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(etudiantCours, MediaType.APPLICATION_JSON));
		System.out.println("Status : " +reponseAjout.getStatus());
		System.out.println("Message : " +reponseAjout.readEntity(String.class));
		return reponseAjout;
	}//end getEtudiantCoursById
	
	
	// ===========================================================//
	// =========== update etudiantCours ===============================//
	// ===========================================================//
	/**
	 * Modifier un etudiantCours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response updateEtudiantCours(EtudiantCours etudiantCours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("update").path(etudiantCours.getId().toString());
		
		Response reponseModif= webTarget.request(MediaType.APPLICATION_JSON).put(Entity.entity(etudiantCours, MediaType.APPLICATION_JSON));
		
		return reponseModif;
	}//end getEtudiantCoursById
	
	
	// ===========================================================//
	// =========== delete etudiantCours ===============================//
	// ===========================================================//
	/**
	 * Supprimer un etudiantCours à la bdd à partir du web service rest 
	 * @return
	 */
	public Response deleteEtudiantCours(Long idEtudiantCours){
		
		webTarget=clientWs.target(WS_BASE_URL).path("delete").path(idEtudiantCours.toString());
		
		Response reponseSupp= webTarget.request().delete();
		
		return reponseSupp;
	}//end getEtudiantCoursById
}//End class
