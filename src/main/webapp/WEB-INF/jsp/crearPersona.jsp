<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 
    <title>Spring 3 MVC Series - Contact Manager</title>
 
 
<h2>Contact Manager</h2>
<form:form method="post" action="addContact.html">
 
    <table>
    <tbody>
    <tr>
        <td><form:label path="nombre">nombre</form:label></td>
        <td><form:input path="nombre"></form:input></td> 
    </tr>
    <tr>
        <td><form:label path="apellido">Last Name</form:label></td>
        <td><form:input path="apellido"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email"></form:input></td>
    </tr>
    <tr>
        <td><form:label path="edad">edad</form:label></td>
        <td><form:input path="edad"></form:input></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Contact">
        </td>
    </tr>
</tbody></table>    
     
</form:form>