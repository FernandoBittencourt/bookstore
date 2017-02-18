<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript">
	function alteraQuantidade(id){	    
		$.ajax({
		  url: "<%=request.getContextPath()%>/carrinho/alteraProdutoQuantidade",
		  data: "id=" + id + "&quantidade="+ $('#quantidade'+id).val(),
		  context: document.body,
		  success: function(){
				location.reload();
		  	}
		});
	 }
	
	function alteraTipo(id){		
		$.ajax({
			  url: "<%=request.getContextPath()%>/carrinho/alteraProdutoTipo",
			  data: "id=" + id + "&tipo="+ $('#tipo'+id).val(),
			  context: document.body,
			  success: function(){
					location.reload();
			  	}
			});
	 }
	
	function alteraCupom(){		
		$.ajax({
			  url: "<%=request.getContextPath()%>/carrinho/alteraCupom",
			  data: "id=" + $('#cupom').val(),
			  context: document.body,
			  success: function(){
					location.reload();
			  	}
			});
	 }
</script>

<div class="container">
	<h2><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho:</h2>
	<table class="table">
	  	<tr>
	    	<th>Código</th>
	    	<th>Livro</th>
	    	<th>Quantidade</th>
	    	<th>Tipo</th>
	    	<th>Preço</th>
	    	<th></th>
	  	</tr>
		<c:forEach items="${produtos}" var="item">	
	  		<tr>
				<td>#${item.id}</td>
				<td>${item.livro.titulo}</td>
				<td>
					<input id="quantidade${item.id}" type="number" class="form-control" onchange="alteraQuantidade(${item.id})" value="${item.quantidade}"/>
				</td>
				<td>
					<select id="tipo${item.id}" class="form-control" onchange="alteraTipo(${item.id})">
						<c:forEach items="${tiposDoProduto}" var="option">
							<option value="${option}"  <c:if test="${option == item.tipo}">selected</c:if>>
								<c:out value="${option.titulo}"></c:out>
							</option>
						</c:forEach>
					</select>
				</td>
				<td>R$ ${item.preco}</td>
				<td>				
					<h5><a href="<%=request.getContextPath()%>/carrinho/remove?id=${item.id}"  class="remove-x"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></h5>
				</td>
			</tr>
		</c:forEach>
	</table>
	<h4>Cupom de desconto:</h4>
	<div class="row">
		<select id="cupom" class="form-control" onchange="alteraCupom()">
			<option value="-1">Nenhum</option>
			<c:forEach items="${cupons}" var="option">
				<option value="${option.id}"  <c:if test="${not empty carrinho.cupom && option.id == carrinho.cupom.id}">selected</c:if>>
					<c:out value="#${option.id} (${option.porcentagemDeDesconto} %)"></c:out>
				</option>
			</c:forEach>
		</select>
	</div>
	<div class="row">
		<h3>Total: R$ ${carrinho.preco}</h3>
	</div>
	
	<div class="row">
		<h3>Total com desconto: R$ ${carrinho.precoComDesconto}</h3>
	</div>
	
	<a href="<%=request.getContextPath()%>/compra/dados"  class="btn btn-book" role="button">Finalizar carrinho</a>
</div>
<jsp:include page = "../footer.jsp" />