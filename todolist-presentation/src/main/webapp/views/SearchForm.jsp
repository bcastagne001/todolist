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
    <title>Recherche</title>
  </head>
  <body>
	<nav>
      <div class="nav-wrapper">
        <a href="#!" class="brand-logo center">Recherche</a>
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
    
    <div class="row">
	  <form class="col s6 offset-s3" name="searchForm" action="/todolist-presentation/tasks/results">
	    <div class="row">
          <select name="userId" required>
            <option value="" disabled selected>Sélectionnez un utilisateur</option>
            <option value="1">Moi</option>
          </select>
	    </div>
	    <div class="row">
	      <label>Date de début : </label><input type="date" class="datepicker" name="beginningIntervalDate" placeholder="Entrez une date" required>
	      <label>Date de fin prévisionnelle : </label><input type="date" class="datepicker" name="endingIntervalDate" placeholder="Entrez une date" required>
	    </div>
	    <div class="row">
	      <button type="submit" class="waves-effect waves-light btn"><i class="material-icons left">search</i>Rechercher</button>
	    </div>
	  </form>
    </div>
    
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/main.js"/>"></script>
  </body>
</html>