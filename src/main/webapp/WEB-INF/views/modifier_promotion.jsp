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

<title>Modifier une promotion</title>
<body>

	<div class="mainContent">

		<br /> <br />
		<h1>Formulaire de modification d'une promotion</h1>

		<form:form modelAttribute="promotion" method="POST"
			action="${pageContext.request.contextPath}/promotions/update">


			<table class="table">
				<form:hidden path="promotion.idPromotion" />
				<tr>
					<td><form:label path="libelle">Libelle :</form:label></td>
					<td><form:input path="libelle" /></td>

				</tr>

				<tr>
					<td colspan="3"><input class="btn btn-primary" type="submit"
						value="Modifier" /></td>
				</tr>
			</table>
		</form:form>
	</div>

</body>
</html>