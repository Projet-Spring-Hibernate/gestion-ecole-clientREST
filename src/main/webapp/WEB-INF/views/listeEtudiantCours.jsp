<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- ============================================================================ -->
<!-- Taglib de spring security -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!-- ============================================================================ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ============================================================================ -->
<!-- Lien vers .css -->
<!-- construction du chemin vers ma feuille de style -->
<spring:url value="/assets/styles/bootstrap.css" var="bootstrapCss"/>
<spring:url value="/assets/styles/style_perso.css" var="StylePerso"/>

<link rel="stylesheet" href="${bootstrapCss}"/>
<link rel="stylesheet" href="${StylePerso}"/>

<!-- Lien vers .js -->
<!-- construction du chemin vers ma feuille de style -->
<spring:url value="/assets/scripts/bootstrap.js" var="bootstrapJS"/>
<spring:url value="/assets/scripts/jquery-3.4.1.js" var="jquery"/>
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrapJS}"></script>

<!-- ============================================================================ -->
<title>Liste absence</title>
</head>
<body>
<br/>
<br/>
	<div class="mainContent">
		<a href="${pageContext.request.contextPath}/index.jsp"
			class="btn btn-primary btn-sm" role="button">Retour accueil</a>
			
			
		<h1>Liste des absences</h1>
		<a
			href="${pageContext.request.contextPath}/etudiantCours/add-etudiantCours-form"
			class="btn btn-primary btn-sm" role="button">Ajouter une abscence</a>
		<br /> <br />
		<table class="table table-striped">
			<!-- Ajout d'un employe -->

			<tr>
				<th>ID</th>
				<th>Absence</th>
				<th>Motif</th>

			</tr>

			<c:forEach items="${attribut_liste_etudiantCours}" var="etudiantCours">
				<tr>
					<td>${etudiantCours.id}</td>
					<td>${etudiantCours.absence}</td>
					<td>${etudiantCours.motif}</td>


					<!-- colonne pour afficher l'�tudiant -->
<!-- 					<td><a -->
<%-- 						href="${pageContext.request.contextPath}/enseignants/afficher/${enseignant.identifiant}">Afficher</a></td> --%>

<!-- 					colonne pour la modif de l'enseignant -->
					<td><a 
						href="${pageContext.request.contextPath}/etudiantCours/update-etudiantCours-form/${etudiantCours.id}">Modifier</a></td> 

					<!-- colonne pour la suppression de l'enseignant -->
					<td><a
						href="${pageContext.request.contextPath}/etudiantCours/supprimer/${etudiantCours.id}">Supprimer</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>