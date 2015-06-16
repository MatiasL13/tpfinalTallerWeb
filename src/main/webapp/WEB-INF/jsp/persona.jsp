
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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


<button><a href="/sitio/test/persona/crear">Cargar Contacto</a></button>