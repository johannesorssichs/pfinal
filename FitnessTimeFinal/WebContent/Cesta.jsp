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
<div style="width:60%;margin:auto;">
<h1>Cesta</h1>
<c:if test="${not empty sessionScope.carrito.productos}">
Este es el detalle de su pedido:<br/><br/>
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#Ref</th>
      <th scope="col">Artículo</th>
      <th scope="col">Categoría</th>
      <th scope="col">Uds</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="cesta" items="${sessionScope.carrito.productos}">
	<tr>
      <th scope="row">#${cesta.key.referencia}</th>
      <td>${cesta.key.nombre}</td>
      <td>${cesta.key.categoria}</td>
      <td>${cesta.value}</td>
    </tr>
	</c:forEach>	
	</table>
	<br/>
	<a href="FinCompra"><button type="button" class="btn btn-outline-info">Finalizar Compra</button></a>&nbsp;<a href="Portada.jsp"><button type="button" class="btn btn-outline-info">Volver a Tienda</button></a>
	</c:if>
	<c:if test="${empty sessionScope.carrito.productos}">
	No ha seleccionado ningún producto.<br/><br/>
	Gracias por confiar en nosotros.
	</c:if>
	<!--  form action="ServletCesta" method="post">
	<input type="submit" value="Finalizar Compra" name="boton" class="botones"><button type="submit" value="Volver a Tienda" name="boton" class="botones">
	</form-->
</div>
 <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>