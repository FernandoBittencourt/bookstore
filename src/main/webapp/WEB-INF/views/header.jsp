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

</head>
<body>
	<div class="jumbotron header-titulo">
		<div class="container">
		<div class="col-lg-6">
			<h1><span class="glyphicon glyphicon-book"></span> Book Store</h1>
		</div>
		<div class="col-lg-6">
			<div class="dropdown pull-right dropdown-menu-titulo">
				  <button class="btn btn-secondary dropdown-toggle btn-menu-titulo" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				    <span class="glyphicon glyphicon-list-alt glyphicon-font-menu"></span>
				  </button>
				  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				  	<div>
				    	<a class="dropdown-item" href="<%=request.getContextPath()%>/livro/lista">Livros</a>
				    </div>
				    <div>
				    	<a class="dropdown-item" href="<%=request.getContextPath()%>/usuario/lista">Usuários</a>
				    </div>
				    <div>
				    	<a class="dropdown-item" href="<%=request.getContextPath()%>/cupom/lista">Cupons</a>
				    </div>
				  </div>
			  </div>
			</div>
		</div>
	</div>