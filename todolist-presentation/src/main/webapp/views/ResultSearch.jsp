<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="<c:url value="/resources/css/materialize.min.css"/>" type="text/css" rel="stylesheet" media="screen,projection">
	<link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" media="screen,projection">
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Résultat de la recherche</title>
  </head>
  <body>
	<nav>
      <div class="nav-wrapper">
        <a href="#!" class="brand-logo center">Résultat de la recherche</a>
        <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
        <ul class="right hide-on-med-and-down">
          <li><a href="<c:url value="/categories"/>">Catégories</a></li>
          <li><a href="<c:url value="/tasks"/>">Tâches</a></li>
        </ul>
        <ul class="side-nav" id="mobile-demo">
          <li><a href="<c:url value="/categories"/>">Catégories</a></li>
          <li><a href="<c:url value="/tasks"/>">Tâches</a></li>
        </ul>
      </div>
    </nav>

	<c:forEach items="${tasks}" var="task">
      <div class="row">
        <div class="col s12 m12">
          <div class="card blue-grey darken-1">
            <div class="card-content white-text">
              <span class="card-title">${task.label}</span>
              <p>Commence le <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${task.beginningDate}" /></p>
              <p>Termine le <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${task.previsionalEndingDate}" /></p>
            </div>
            <div class="card-action right-align">
              <a href="#" class="waves-effect waves-light btn orange">Terminer la tâche</a>
            </div>
          </div>
        </div>
      </div>
	</c:forEach>
	
    <div class="row">
      <div class="col s12 m12">
	    <button type="submit" class="waves-effect waves-light btn red">Terminer toutes les tâches</button>
	  </div>
	</div>
            	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
  </body>
</html>