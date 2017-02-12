<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<form action="efetuaLogin" method="post">
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="nome">Nome</label> 
				<input class="form-control" name="nome" value="${usuario.nome}" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="senha">Senha</label> 
				<input type="password" class="form-control" name="senha" value="${usuario.senha}" />
			</div>
		</div>		
		<button type="submit" class="btn btn-default">Entrar</button>
	</form>
</div>

<jsp:include page = "../footer.jsp" />