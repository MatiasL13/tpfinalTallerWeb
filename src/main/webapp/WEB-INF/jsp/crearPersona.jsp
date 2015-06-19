<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 
 

 <html>
 <head>
     <title>Cargar contacto</title>
     <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css"/>
 </head>
 <body>
 
 <legend>Contact Manager</legend>
 <div class="col-md-5 col-md-offset-3 center">
    <form:form method="post" action="addContact.html" class="">
 
   <div class="form-group">
   <form:label path="nombre">nombre</form:label>
        <form:input  class="form-control"path="nombre"></form:input> 
    </div>
        
    
    <div class="form-group"><form:label path="apellido">Last Name</form:label>
        <form:input  class="form-control"path="apellido"></form:input>
    </div>
        
    
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input class="form-control" path="email"></form:input>
    </div>
       
    <div class="form-group">
        <form:label path="edad">edad</form:label>
        <form:input  class="form-control"path="edad"></form:input>
    </div>
            <input class="btn btn-success" type="submit" value="Add Contact">
      
</tbody></table>    
     
</form:form>
 </div>

 </body>
 </html>
 
