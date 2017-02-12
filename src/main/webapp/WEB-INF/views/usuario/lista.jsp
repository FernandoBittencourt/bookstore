<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h2>Usuários:</h2>
   	<div class="text-right">
		<a href="<%=request.getContextPath()%>/usuario/novo" class="btn btn-primary">Novo</a>
	</div>
	<table class="table">
	  	<tr>
	    	<th>#</th>
	    	<th>Nome</th>
	    	<th>E-mail</th>
	    	<th>Perfil</th>
	    	<th></th>
	  	</tr>
		<c:forEach items="${usuarios}" var="item">	
	  		<tr>
				<td>${item.id}</td>
				<td>${item.nome}</td>
				<td>${item.email}</td>
				<td>${item.perfil.titulo}</td>
				<td>				
					<a href="<%=request.getContextPath()%>/usuario/altera?id=${item.id}" class="btn-warning btn-xs"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
					<a href="<%=request.getContextPath()%>/usuario/remove?id=${item.id}"  class="btn-danger btn-xs"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page = "../footer.jsp" />