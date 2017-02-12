<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
	var filtro = function(elemento) {
		window.location="<%=request.getContextPath()%>/filtro?categoria=" + elemento.value;
	};
</script>
<div class="container">
	<h1 class="principal-titulo">Livros:</h1> 
	<h3 class="principal-categoria dados-livro">Categoria:</h3>
	<select id="filtroLivros" class="form-control" onChange="filtro(this)">
		<option value="">Todos</option>
		<c:forEach items="${categorias}" var="item">
			<option value="${item}" <c:if test="${item==categoriaSelecionada}">selected</c:if>>${item}</option>
		</c:forEach>
	</select>
	<h1></h1>
	<div class="row">
		<c:forEach items="${livros}" var="item">
	        <div class="col-sm-6 col-md-4">
	            <div class="thumbnail">
	                <h3 class="dados-livro">${item.titulo}</h3>                
	                <h4 class="dados-livro">${item.categoria}</h4>  	                                              
	                <h4 class="dados-livro">Preços:</h4>                              
	                <h5 class="dados-livro">Ebook - R$ ${item.ebookPreco}</h5>                               
	                <h5 class="dados-livro">Impresso - R$ ${item.impressoPreco}</h5>                               
	                <h5 class="dados-livro">Combo - R$ ${item.comboPreco}</h5>
	                <img src="${item.capa}" alt="Capa do livro">
	                <a href="<%=request.getContextPath()%>/livro/visualiza?id=${item.id}" class="btn btn-book col-xs-12" role="button">Ver detalhes...</a>
	                <div class="clearfix"></div>
	            </div>
	        </div>
	    </c:forEach>
	</div>
</div>

<jsp:include page = "../footer.jsp" />