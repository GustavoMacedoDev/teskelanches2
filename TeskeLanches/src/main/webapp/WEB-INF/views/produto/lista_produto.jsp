<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Produtos</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Lista de Produtos</h1>
    <hr>
    <div>

		<spring:url value="/produto/cadastro" var="cadastro"/>
        <a class="btn btn-default" href="${cadastro }">Novo Produto</a>
    </div>
    <hr>

    <div class="${message == null ? 'panel-default' : 'panel-success'}">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>

        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>NOME</th>
                <th>VALOR</th>
                <th>CATEGORIA</th>
                <th>Ações</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="produto" items="${produtos }">
                <tr>
                    <td>${produto.descProduto }</td>
                    <td>${produto.valorProduto }</td>
                    <td>${produto.categoria}</td>
                    <td>                        
                        <spring:url value="/produto/update/${produto.id }" var="update"/>
                        <a class="btn btn-info" href="${update }" >Editar</a>
                        <spring:url value="/produto/delete/${produto.id }" var="delete"/>
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