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

<title>Ajouter absence</title>
<body>

	<div class="mainContent">

		<br /> <br />
		<h1>Ajout d'une abscence</h1>

		<form:form modelAttribute="etudiantCours" method="POST"
			action="${pageContext.request.contextPath}/etudiantCours/add">


			<table class="table">

				<tr>
					<td><form:label path="absence">Absence :</form:label></td>
					<td><form:input path="absence" /></td>

				</tr>
				<tr>
					<td><form:label path="motif">Motif :</form:label></td>
					<td><form:input path="motif" /></td>

				</tr>




				<td colspan="3"><input class="btn btn-primary" type="submit"
					value="Ajouter" /></td>

			</table>
		</form:form>
	</div>

</body>
</html>