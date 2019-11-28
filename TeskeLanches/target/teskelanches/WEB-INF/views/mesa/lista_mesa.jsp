<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Mesas</title>
    <spring:url var="css" value="/static/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="${css }"/>
</head>
<body>
<div class="container">
    <h1>Lista de Mesas</h1>
    <hr>
    <div>

		<spring:url value="/mesa/cadastro" var="cadastro"/>
        <a class="btn btn-default" href="${cadastro }">Nova Mesa</a>
    </div>
    <hr>

    <div class="${message == null ? 'panel-default' : 'panel-success'}">

        <div class="panel-heading">
            <span>${message == null ? '&nbsp;' : message}</span>
        </div>
        <div>
        	<c:forEach var="mesas" items="${mesa }">
        		<spring:url value="/mesa/nova/${mesas.id }" var="update"/>
                <a class="btn btn-info btn-mesa" href="${update }" > ${mesas.numero }</a>
        	</c:forEach>
        </div>
                        
                    
    </div>
</div>
</body>
</html>