<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<c:if test="${empty sessionScope.historial}">
	<h4 class="display-4 text-xs-center m-y-3 text-muted" id="speakers">Aún no has realizado ninguna compra</h4>
</c:if>
<c:if test="${not empty sessionScope.historial}">
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Fecha</th>
      <th scope="col">Artículo</th>
      <th scope="col">Uds Totales</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="h" items="${sessionScope.historial}">
	<tr>
      <th scope="row">${h.fecha}</th>
      <td>${h.producto.nombre}</td>
      <td>${h.uds}</td>
    </tr>
	</c:forEach>	
	</table>
</c:if>

 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>