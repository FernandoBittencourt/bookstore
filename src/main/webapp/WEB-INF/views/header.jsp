<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Book Store</title>
<link type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"	rel="stylesheet" />
<link type="text/css" href="<%=request.getContextPath()%>/assets/principal.css"	rel="stylesheet" />

<script	src="<%=request.getContextPath()%>/resources/jquery-3.1.0/jquery-3.1.0.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body>
	<div class="jumbotron header-titulo">
		<div class="container">
			<div class="col-lg-6 logo-principal">
				<h1><a href="<%=request.getContextPath()%>/"><span class="glyphicon glyphicon-book"></span> Book Store</a></h1>
			</div>			
			<div class="col-lg-2"></div>
			<div class="col-lg-1">
				<h2><a class="btn-menu-titulo" href="<%=request.getContextPath()%>/carrinho/lista"><span class="glyphicon glyphicon-shopping-cart"></span></a></h2>
			</div>
			<div class="col-lg-1">
				<h2><a class="btn-menu-titulo" href="<%=request.getContextPath()%>/painel-de-admin"><span class="glyphicon glyphicon-list-alt"></span></a></h2>
			</div>
			<div>
			<c:if test="${sessionScope.usuarioLogado == null}"><h3><a class="btn-menu-titulo" href="<%=request.getContextPath()%>/entra">Entrar <span class="glyphicon glyphicon-arrow-right"></span></a></h3></c:if>	
			<c:if test="${sessionScope.usuarioLogado != null}"><h3><a class="btn-menu-titulo" href="<%=request.getContextPath()%>/sair">Sair <span class="glyphicon glyphicon-arrow-right"></span></a></h3></c:if>
			</div>				
		</div>
	</div>