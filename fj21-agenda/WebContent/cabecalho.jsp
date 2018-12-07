<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- usando taglib para usar um caminho absoluto a partir do WebContent -->
<!-- <img src="<c:url value="/imagens/caelum.png" />"/> -->

<!-- outra maneira -->
<c:url value="/imagens/caelum.png" var="logoUrl" />
<img src="${logoUrl}">

<h2>Agenda de Contatos do Cleberson Pauluci</h2>
<hr />