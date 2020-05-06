<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ============================================================================ -->
<!-- Taglib -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%--Ajout de la taglib de spring mvc 'form' --%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- ============================================================================ -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- ============================================================================ -->
<!-- Lien vers .css -->
<!-- construction du chemin vers ma feuille de style -->
<spring:url value="/assets/styles/bootstrap.css" var="bootstrapCss" />
<spring:url value="/assets/styles/style_perso.css" var="StylePerso" />

<link rel="stylesheet" href="${bootstrapCss}" />
<link rel="stylesheet" href="${StylePerso}" />

<!-- Lien vers .js -->
<!-- construction du chemin vers ma feuille de style -->
<spring:url value="/assets/scripts/bootstrap.js" var="bootstrapJS" />
<spring:url value="/assets/scripts/jquery-3.4.1.js" var="jquery" />
<script type="text/javascript" src="${jquery}"></script>
<script type="text/javascript" src="${bootstrapJS}"></script>

<!-- ============================================================================ -->
<title>Accueil</title>
</head>
<body>

	<div class="mainContent">
		<br />
		<br /> <a href="${pageContext.request.contextPath}/etudiants/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des etudiants</a>

		<a href="${pageContext.request.contextPath}/enseignants/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des enseignants</a>

		<a href="${pageContext.request.contextPath}/administrateurs/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des administrateurs</a>

		<a href="${pageContext.request.contextPath}/adresses/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des adresses</a>

		<a href="${pageContext.request.contextPath}/aides/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des aides</a>

		<a href="${pageContext.request.contextPath}/cours/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des cours</a>

		<a href="${pageContext.request.contextPath}/etudiantsCours/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des absences</a>

		<a href="${pageContext.request.contextPath}/exercices/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des exercices</a>

		<a href="${pageContext.request.contextPath}/matieres/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des matieres</a>

		<a href="${pageContext.request.contextPath}/promotions/list-all"
			class="btn btn-primary btn-sm" role="button">Liste des promotions</a>

	</div>

</body>
</html>