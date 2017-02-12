<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h1>Livros:</h1>
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
	                <a href="<%=request.getContextPath()%>/livro/visualiza?id=${item.id}" class="btn btn-primary col-xs-12" role="button">Ver detalhes...</a>
	                <div class="clearfix"></div>
	            </div>
	        </div>
	    </c:forEach>
	</div>
</div>

<jsp:include page = "../footer.jsp" />