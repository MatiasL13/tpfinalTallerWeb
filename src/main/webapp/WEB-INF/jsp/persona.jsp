<html>
<head>

	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<td>Acciones</td>
	</tr>
	<c:forEach  items="${personas}" var="dato">
	<tr>
		<td>${dato.nombre}</td>
		<td>${dato.apellido}</td>
		<td>${dato.edad}</td>
		<td>${dato.email}</td>
		<td>
			    <form:form method="post" action="deleteContact.html" class="col-md-6" >
			        <form:input type="hidden"class="form-control" path="id" value="${dato.id}"></form:input>
					<input class="btn btn-danger col-md-12 " type="submit" value="Eliminar">
			    </form:form>
			    <form:form method="post" action="crear" class="col-md-6" >
			        <form:input type="hidden"class="form-control" path="id" value="${dato.id}"></form:input>
					<input class="btn btn-info col-md-12" type="submit" value="Modificar">
			    </form:form>
		</td>
	</tr>
	</c:forEach>

	</table>


	</div>
</div>


<button class="btn btn-success col-md-2 col-md-offset-9 "><a href="/sitio/test/persona/crear">Cargar Contacto</a></button>

</body>
</html>