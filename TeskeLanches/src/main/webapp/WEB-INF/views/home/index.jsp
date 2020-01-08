<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Lanches</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <div>
    <br >
	<h2>Tela Inicial</h2>
	<hr >
		<spring:url value="/produto/todos" var="produtos"/>
        <a class="btn btn-info" href="${produtos }">Produtos</a>
        <spring:url value="/unidademedida/todos" var="unimedida"/>
        <a class="btn btn-info" href="${unimedida }">Unidade de Medida</a>
        <spring:url value="/bebida/todos" var="bebida"/>
        <a class="btn btn-info" href="${bebida }">Bebida</a>
        <spring:url value="/mesa/todos" var="mesa"/>
        <a class="btn btn-info" href="${mesa }">Mesas</a>
    </div>
</div>
</body>
</html>