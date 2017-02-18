<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<h2><span class="glyphicon glyphicon-piggy-bank"></span> Finalizando a compra:</h2>
	
	<h3>Comprador:</h3> <span>${comprador}</span>
	<h3>Total a ser pago:</h3> <span>${carrinho.precoComDesconto}</span>  	
   	
   	
	<h3><span class="glyphicon glyphicon-credit-card"></span> Dados do Cartão:</h3>
  	<div class="row">
		<div class="form-group">
   			<label class="control-label" for="numero">Número do cartão</label>
			<input type="text" class="form-control" name="numero"/>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
   			<label class="control-label" for="cvv">CVV</label>
			<input type="text" class="form-control" name="cvv"/>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
   			<label class="control-label" for="validade">Data de validade</label>
			<input type="date" class="form-control" name="validade"/>
		</div>
	</div>
	<div class="row">
		<div class="form-group">
   			<label class="control-label" for="endereco">Endereço da entrega</label>
			<input type="text" class="form-control" name="endereco"/>
		</div>
	</div>
	
	<a href="<%=request.getContextPath()%>/compra/confirmar"  class="btn btn-book" role="button">Confirmar</a>		
</div>
<jsp:include page = "../footer.jsp" />