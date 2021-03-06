<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Lanche</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Cadastro de Lanches</h1>
    <hr>
    <div>

		<spring:url value="/lanche/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<spring:url value="${lanche.id == null ? '/lanche/save' : '/lanche/update'}" var="save"/>
        <form:form modelAttribute="lanche" action="${save }" method="post">
        	<form:hidden path="id"/>
            <div class="form-group">
                <label for="nomeLanche">Nome: </label>
                <form:input path="nomeLanche" class="form-control"/>   
                <form:errors path="nomeLanche" cssClass="label label-danger"/>             
            </div>
            <div class="form-group">
                <label for="valor">Valor: </label>
                <form:input path="valor"  class="form-control"/>    
                <form:errors path="valor" cssClass="label label-danger"/>          
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Confirmar</button>
            </div>
        </form:form>
    </div>
    
</div>
</body>
</html>