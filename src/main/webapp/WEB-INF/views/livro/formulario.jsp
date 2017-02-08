<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<form action="adiciona" method="post">		
    	<input type="hidden" name="id" value="${livro.id}" />
		<div class="row">
			<div class="form-group">
    			 <label class="control-label" for="titulo">Titulo</label>
				<input class="form-control" name="titulo" value="${livro.titulo}"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			 <label class="control-label" for="capa">Capa</label>
				<input class="form-control" name="capa" value="${livro.capa}"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			 <label class="control-label" for="autor">Autor</label>
				<input class="form-control" name="autor" value="${livro.autor}"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			 <label class="control-label" for="descricao">Descrição</label>
				<textarea class="form-control" name="descricao" rows="5" cols="100">${livro.descricao}</textarea>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			<label class="control-label" for="ebookPreco">Preço do Ebook</label>
				<input class="form-control" type="number" name="ebookPreco" value="${livro.ebookPreco}"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			<label class="control-label" for="impressoPreco">Preço do Impresso</label>
				<input class="form-control" type="number" name="impressoPreco" value="${livro.impressoPreco}"/>
			</div>
		</div>
		<div class="row">
			<div class="form-group">
    			 <label class="control-label" for="comboPreco">Preço do Combo</label>
				<input class="form-control" type="number" name="comboPreco" value="${livro.comboPreco}"/>
			</div>
		</div>		
		<button type="submit" class="btn btn-default">Salvar</button>
	</form>
</div>
<jsp:include page = "../footer.jsp" />