<jsp:include page="../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
        $(document).ready(function(){
            $("#startDatePicker").datepicker();
        });
    </script>
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
				<input type="text" class="form-control" placeholder="dd/mm/aaaa" name="validade" value="${cupom.validade}" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="usuario">Usuário</label> 
				<select class="form-control" name="usuario.id">
					<c:forEach items="${usuarios}" var="option">
						<option value="${option.id}">
							<c:out value="${option.nome}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Salvar</button>
	</form>
</div>
<jsp:include page="../footer.jsp" />