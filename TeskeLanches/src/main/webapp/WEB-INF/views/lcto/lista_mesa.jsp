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
    <spring:url var="jsProjeto" value="/static/js/soma.js"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
    <link type="text/css" rel="stylesheet" href="${cssProjeto }"/>
    <link href="${jsProjeto }"/>
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
    	<h1>Mesa: ${mesa }</h1>
    	
    </div>
   
   <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <th>LANCHE</th>
                <th>VALOR</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="lanche" items="${lanches }">
                <tr>
                    <td>${lanche.nomeLanche }</td>
                    <td class="valor">${lanche.valor }</td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr>
                <th>BEBIDA</th>
                <th>VALOR</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="bebida" items="${bebidas }">
                <tr>
                    <td>${bebida.nomeBebida }</td>
                    <td class="valor">${bebida.valor }</td>
                </tr>
            </c:forEach>
            </tbody>
            <thead>
            <tr>
                <th>TOTAL</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td id="resultado"></td>
                </tr>
            </tbody>
        </table>
    		
    		<h1>${lancamento.id }</h1>
    		
		<spring:url value="/lancamento/update/${lancamento.id }" var="update"/>
        <a class="btn btn-info" href="${update }" >Editar</a>
        <spring:url value="/lanche/delete/${lancamento.id }" var="delete"/>
        <a class="btn btn-danger" href="${delete }" >Excluir</a>
    		
</div>
<script type="text/javascript">
window.onload = function() {
	soma();
	function soma() {
		let tdsValores = document.querySelectorAll('.valor')

		let total = 0 

		for (let i = 0; i < tdsValores.length; i++) {
		    let valor = parseFloat(tdsValores[i].textContent)
		    total = total + valor 
		}

		console.log(total)
		document.getElementById('resultado').innerHTML = total;
	};
}



</script>
</body>
</html>