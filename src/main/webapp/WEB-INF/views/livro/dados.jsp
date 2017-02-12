<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h1>${livro.titulo}</h1>   	
   	<h3>Código: #${livro.id}</h3>
   	<h3>Categoria: ${livro.categoria}</h3>   	
   	<h3>Autor: ${livro.autor}</h3>
   	
   	<img class="img-capa img-responsive" src="${livro.capa}" alt="Capa do livro">	
   	<h4>${livro.descricao}</h4>                
   	
   	<h3>Preços:</h3>
   	<h4>Ebook: R$ ${livro.ebookPreco}</h4>   	
   	<h4>Impresso: R$ ${livro.impressoPreco}</h4>
   	<h4>Combo: R$ ${livro.comboPreco}</h4>
	
	<a href="#" class="btn btn-book" role="button"><span class="glyphicon glyphicon-shopping-cart"></span> Adicionar ao carrinho...</a>		
</div>
<jsp:include page = "../footer.jsp" />