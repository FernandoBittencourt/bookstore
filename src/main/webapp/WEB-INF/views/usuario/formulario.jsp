<jsp:include page="../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
	<form action="adiciona" method="post">
		<input type="hidden" name="id" value="${usuario.id}" />
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
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="email">E-mail</label> 
				<input type="email" class="form-control" name="email" value="${usuario.email}" />
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="control-label" for="perfil">Perfil</label> 
				<select class="form-control" name="perfil">
					<c:forEach items="${perfis}" var="option">
						<option value="${option}">
							<c:out value="${option.titulo}"></c:out>
						</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<button type="submit" class="btn btn-default">Salvar</button>
	</form>
</div>
<jsp:include page="../footer.jsp" />