package com.intiformation.client_rest_GestionEcole.modele;


/**
 * classe consacrée à la constitution de la page d'aide

 * @author Valentin
>>>>>>> f141fb8cf0d593d1a32b889cf419aafc29bb93cb
 *
 */

public class Aide {
	
	/*-----propriétés-----*/

	private Long id_aide;
	
	private String page;
	
	private String contenu;
	
	
	/*-----constructeurs-----*/
	public Aide() {
		super();
	}
	
	
	public Aide(String page, String contenu) {
		super();
		this.page = page;
		this.contenu = contenu;
	}


	public Aide(String page, String contenu, Long id_page) {
		super();
		this.page = page;
		this.contenu = contenu;
		this.id_aide = id_page;
	}


	/*-----getters/setters + méthodes-----*/
	
	
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	



	public Long getId_aide() {
		return id_aide;
	}


	public void setId_aide(Long id_aide) {
		this.id_aide = id_aide;
	}


	@Override
	public String toString() {
		return "Aide [page=" + page + ", contenu=" + contenu + ", id_aide=" + id_aide + "]";
	}
	

}//fin classe
