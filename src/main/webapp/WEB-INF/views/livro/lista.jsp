<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
   	<div class="text-right">
		<a href="<%=request.getContextPath()%>/livro/novo" class="btn btn-primary">Novo</a>
	</div>
	<table class="table">
	  	<tr>
	    	<th>#</th>
	    	<th>Titulo</th>
	    	<th>Autor</th>
	    	<th>Descrição</th>
	    	<th></th>
	  	</tr>
		<c:forEach items="${livros}" var="item">	
	  		<tr>
				<td>${item.id}</td>
				<td>${item.titulo}</td>
				<td>${item.autor}</td>
				<td>${item.descricao}</td>
				<td>				
					<a href="<%=request.getContextPath()%>/livro/altera?id=${item.id}">O</a>
					<a href="<%=request.getContextPath()%>/livro/remove?id=${item.id}">x</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page = "../footer.jsp" />