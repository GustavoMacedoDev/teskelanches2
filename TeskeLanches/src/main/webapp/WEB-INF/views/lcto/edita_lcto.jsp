<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lancamento</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <spring:url var="cssProjeto" value="/static/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
    <link type="text/css" rel="stylesheet" href="${cssProjeto }"/>
</head>
<body>
<div class="container">
    <h1>Lançamento</h1>
    <hr>
    <div>

		<spring:url value="/mesa/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<h1>Mesa: ${mesa.numero }</h1>
    </div>
   
   <c:url var="save" value="/lancamento/save"/>
	<form:form modelAttribute="lancamento" action="${save}" method="post">
	  <input id="mesa.id" name="mesa.id" type="hidden" value="${mesa.id}"/>  
		<fieldset>
			<div class="campo">
				<div>
					<form:label path = "lanches"><h3>Lanches</h3></form:label>
				</div>
				<div>
					<form:checkboxes path="lanches" items="${lanches}" itemValue="id" itemLabel="nomeLanche" />
			  		<input type="hidden" name="lanches" value="0"/>
				</div>
				
				<form:label path="bebidas"><h3>Bebidas</h3></form:label>
				<div>
					<form:checkboxes path="bebidas" items="${bebidas}" itemValue="id" itemLabel="nomeBebida" />
			  		<input type="hidden" name="bebidas" value="0"/>
				</div>
			  <input type="hidden" name="bebidas" value="0"/>
			</div>
			<div>
				 <button type="submit" class="btn btn-primary">Confirmar</button>
			</div>
		</fieldset>	
	</form:form>
    
    
    		
</div>
</body>
</html>