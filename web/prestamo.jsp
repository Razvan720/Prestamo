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
		<form action="prestamo" method="POST">


			<p> Nombre <input type="text" name="nombre" value="${nombre}"></p>
			<p> Cantidad que solicita <input type="text" name="cantidad" value="${cantidad}"></p>
			<p> Interes <input type="text" name="interes" value="${interes}"></p>
			<p> Tiempo(meses) <select name="tiempo">
					<c:forEach items="${meses}" var= "mes">
						<c:if test = "${mes == tiempo}">
							<option  value="${mes}" selected >${mes}</option>
						</c:if>
						<c:if test = "${mes != tiempo}">
							<option value="${mes}" >${mes}</option>
						</c:if>

					</c:forEach>
				</select></p>
			<input type="submit" value="Enviar">
		</form>

		<c:if test = "${prestamo != null}">
			<h1>Importe total del Prestamo : ${prestamo}</h1>
		</c:if>
    </body>
</html>
