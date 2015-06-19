<html>
<head>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
	<title></title>
</head>
<body>
<div>
<div>
	<legend>Lista de Contactos</legend>
</div>
	<div class="col-md-10 col-md-offset-1 center">
	<table class="table">
	<tr>
		<td>nombre</td>
		<td>apellido</td>
		<td>edad</td>
		<td>email</td>
	</tr>
	<c:forEach  items="${personas}" var="dato">
	<tr>
		<td>${dato.nombre}</td>
		<td>${dato.apellido}</td>
		<td>${dato.edad}</td>
		<td>${dato.email}</td>
	</tr>
	</c:forEach>

	</table>


	</div>
</div>


<button class="btn btn-success"><a href="/sitio/test/persona/crear">Cargar Contacto</a></button>

</body>
</html>