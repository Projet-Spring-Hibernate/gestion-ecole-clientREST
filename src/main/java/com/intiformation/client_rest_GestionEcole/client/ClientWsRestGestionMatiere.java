package com.intiformation.client_rest_GestionEcole.client;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.intiformation.client_rest_GestionEcole.modele.Adresse;
import com.intiformation.client_rest_GestionEcole.modele.Matiere;

@Repository("clientWsRestGestionMatiere")
public class ClientWsRestGestionMatiere {
	
	private static final String  WS_BASE_URL="http://localhost:8080/01_gestion_ecoles/spring-rest/matiere";
	private static Client clientWs = ClientBuilder.newClient();
	private static WebTarget webTarget;
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	
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
		
		Matiere matiere = restTemplate.getForObject(WS_BASE_URL+"/get-by-id/"+idMatiere, Matiere.class);
	
		
		return matiere;
	}//end getMatiereById
	
	// ===========================================================//
	// =========== save matiere =================================//
	// ===========================================================//
	/**
	 * Ajouter un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public Matiere saveMatiere(Matiere matiere){
		System.out.println("\n==== Je suis dans saveMatiere coté client" );
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Matiere> request = new HttpEntity<>(matiere,headers);
		
		Matiere matiere1 = restTemplate.postForObject(WS_BASE_URL+"/save", request, Matiere.class);
		
		return matiere1;
	}//end getMatiereById
	
	
	// ===========================================================//
	// =========== update matiere ===============================//
	// ===========================================================//
	/**
	 * Modifier un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public Matiere updateMatiere(Matiere matiere){
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Matiere> request = new HttpEntity<>(matiere,headers);

		
		Matiere matiere1 = restTemplate.postForObject(WS_BASE_URL+"/update/"+matiere.getIdMatiere(), request, Matiere.class);
		
		return matiere1;
	}//end getMatiereById
	
	
	// ===========================================================//
	// =========== delete matiere ===============================//
	// ===========================================================//
	/**
	 * Supprimer un matiere à la bdd à partir du web service rest 
	 * @return
	 */
	public void deleteMatiere(Long idMatiere){
		
	 restTemplate.delete(WS_BASE_URL+"/delete/"+idMatiere);
		
	}//end getMatiereById
}//End class
