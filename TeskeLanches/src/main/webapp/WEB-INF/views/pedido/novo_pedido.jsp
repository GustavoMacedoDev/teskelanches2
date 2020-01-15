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
    <h1>Pedido</h1>
    <hr>
    <div>

		<spring:url value="/mesa/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<h1>Mesa: ${mesa.id }</h1>
    </div>
    
    <img alt="imagem" src="<c:url value="/static/img/x_salada.png"/>" width="100px" height="100px"/>
   
   <c:url var="save" value="/pedido/save"/>
	<form:form modelAttribute="pedido" action="${save}" method="post">
	  <input id="mesa.id" name="mesa.id" type="hidden" value="${mesa.id}"/>  
		<fieldset>
			<div class="form-group">
				
				<div>
					<form:label path = "produtos"><h3>Lanches</h3></form:label>
				</div>
				<div>
					<form:checkboxes path="produtos" items="${lanches}" itemValue="idProduto" itemLabel="produto" />
					<input type="hidden" name="produtos" value="0"/>
				</div>
				</div>
			
			<div class="form-group">
				
				<div>
					<form:label path = "produtos"><h3>Bebidas</h3></form:label>
				</div>
				<div>
					<form:checkboxes path="produtos" items="${bebidas}" itemValue="idProduto" itemLabel="produto" />
					<input type="hidden" name="produtos" value="0"/>
				</div>
				</div>
			
			<div class="form-group">
				
				<div>
					<form:label path = "produtos"><h3>Porçãos</h3></form:label>
				</div>
				<div>
					<form:checkboxes path="produtos" items="${porcaos}" itemValue="idProduto" itemLabel="produto" />
					<input type="hidden" name="produtos" value="0"/>
				</div>
				</div>
			<div>
				 <button type="submit" class="btn btn-primary">Confirmar</button>
			</div>
		</fieldset>	
	</form:form>
    
    		
</div>
</body>
</html>