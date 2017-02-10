<jsp:include page="../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<form action="adiciona" method="post">
		<input type="hidden" name="id" value="${cupom.id}" />
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="porcentagemDeDesconto">Desconto (%)</label> 
				<input type="number" class="form-control" name="porcentagemDeDesconto" value="${cupom.porcentagemDeDesconto}" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="validade">Validade</label> 
				<input type="date" class="form-control" name="validade" value="${cupom.validade}" />
			</div>
		</div>
		<button type="submit" class="btn btn-default">Salvar</button>
	</form>
</div>
<jsp:include page="../footer.jsp" />