<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/estilo.css">
<script type='text/javascript' src="js/scripts.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin:auto;width:80%">
	<h1 class="display-4 text-xs-center m-y-3 text-muted" id="speakers">Categoria: ${sessionScope.categoria}</h1>
	<c:forEach var="productos" items="${sessionScope.productos}">
			<div class="card" style="width:18rem;float:left;margin:20px">
		      <div class="card-body">
	   			 <h5 class="card-title">${productos.nombre}</h5>
	   			 <p class="card-text">${productos.descripcion}</p>
	   			 <p class="card-text">${productos.precio} EUR</p>
	   			 <a href="javascript:peticionAsincrona('ControlCarrito?ref=${productos.referencia}', 'FotosInicio', 'true');"><button type="button" class="btn btn-outline-info">Añadir a Carrito</button></a>
	 		 </div>
		    </div>
	</form>
    </c:forEach>
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>