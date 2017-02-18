<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h2><span class="glyphicon glyphicon-ok-circle"></span> Compra finalizada!</h2>
	<h3>Obrigado, ${usuario}.</h3>
	<h3>Volte Sempre...</h3>
	<br>
	
	<a href="<%=request.getContextPath()%>"  class="btn btn-book" role="button">Voltar para a loja...</a>
</div>
<jsp:include page = "../footer.jsp" />