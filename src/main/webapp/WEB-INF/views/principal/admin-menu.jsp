<jsp:include page = "../header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="container">
	<div class="container">
  	<div class="row">
    	<h1><a class="admin-menu-item" href="<%=request.getContextPath()%>/livro/lista">Livros</a></h1>
    </div>
    <div class="row">
    	<h1><a class="admin-menu-item"  href="<%=request.getContextPath()%>/usuario/lista">Usuários</a></h1>
    </div>
    <div class="row">
    	<h1><a class="admin-menu-item" href="<%=request.getContextPath()%>/cupom/lista">Cupons</a></h1>
    </div>
    </div>
</div>

<jsp:include page = "../footer.jsp" />