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
    <h1>Lista de Lanches</h1>
    <hr>
    <div>

		<spring:url value="/lanche/cadastro" var="cadastro"/>
        <a class="btn btn-default" href="${cadastro }">Novo Lanche</a>
    </div>
    <hr>

    <div class="${message == null ? 'panel-default' : 'panel-success'}">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>VALOR</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lanche" items="${lanches }">
                <tr>
                    <td>${lanche.id }</td>
                    <td>${lanche.nomeLanche }</td>
                    <td>${lanche.valor }</td>
                    <td>                        
                        <spring:url value="/lanche/update/${lanche.id }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/lanche/delete/${lanche.id }" var="delete"/>
                        <a class="btn btn-danger" href="${delete }" >Excluir</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>