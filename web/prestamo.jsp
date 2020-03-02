<%-- 
    Document   : prestamo
    Created on : 02-mar-2020, 19:20:56
    Author     : DAW209
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Banco Razvan</h1>
		<p> Nombre <input type="text" name="nombre"></p>
		<p> Cantidad que solicita <input type="text" name="cantidad"></p>
		<p> Interes <input type="text" name="interes"></p>
		<p> Tiempo(meses) <select>
			<c:forEach items="${meses}" var= "mes">
				<option>${mes}</option>
		
		</c:forEach>
			</select></p>
    </body>
</html>
