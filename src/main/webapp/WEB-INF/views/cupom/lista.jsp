<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
   	<div class="text-right">
		<a href="<%=request.getContextPath()%>/cupom/novo" class="btn btn-primary">Novo</a>
	</div>
	<table class="table">
	  	<tr>
	    	<th>#</th>
	    	<th>Desconto (%)</th>
	    	<th>Validade</th>
	    	<th></th>
	  	</tr>
		<c:forEach items="${cupons}" var="item">	
	  		<tr>
				<td>${item.id}</td>
				<td>${item.porcentagemDeDesconto}</td>
				<td>${item.validade}</td>
				<td>				
					<a href="<%=request.getContextPath()%>/cupom/altera?id=${item.id}" class="btn-warning btn-xs"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
					<a href="<%=request.getContextPath()%>/cupom/remove?id=${item.id}" class="btn-danger btn-xs"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<jsp:include page = "../footer.jsp" />