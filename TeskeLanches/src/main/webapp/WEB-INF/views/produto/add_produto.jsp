<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Cadastro de Produtos</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Cadastro de Produtos</h1>
    <hr>
    <div>

		<spring:url value="/produto/todos" var="home"/>
		<a class="btn btn-default" href="${home }">Home</a>
    </div>
    <hr>
    <div>
    	<spring:url value="${produto.id == null ? '/produto/save' : '/produto/update'}" var="save"/>
        <form:form modelAttribute="produto" action="${save }" method="post">
        	<form:hidden path="id"/>
            <div class="form-group">
                <label for="descProduto">Produto: </label>
                <form:input path="descProduto" class="form-control"/>   
                <form:errors path="descProduto" cssClass="label label-danger"/>             
            </div>
            <div class="form-group">
                <label for="valorProduto">Valor: </label>
                <form:input path="valorProduto" class="form-control"/>   
                <form:errors path="valorProduto" cssClass="label label-danger"/>             
            </div>
            
            <div class="form-group">
				<form:label path="categoria">Categoria</form:label><br>
				<form:select path="categoria" required="true" >
					<form:option value="BEBIDA" label="BEBIDA"/>
					<form:option value="LANCHE" label="LANCHE"/>
					<form:option value="PORCAO" label="PORÇÃO"/>
				</form:select>
			</div>
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Confirmar</button>
            </div>
        </form:form>
    </div>
    
   
    
</div>
</body>
</html>