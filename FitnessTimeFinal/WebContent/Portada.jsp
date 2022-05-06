<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script type='text/javascript' src="js/scripts.js"></script>
<title>${initParam.titulo}</title>
		<c:if test="${empty cookie.colorFondo}" >
		    <c:set var="fondo" value="${initParam.colorFondoDefault}"></c:set>
		</c:if>
		<c:if test="${not empty cookie.colorFondo}" >
		    <c:set var="fondo" value="${cookie.colorFondo.value}"></c:set>
		</c:if>
<link href="css/estilo${fondo}.css" type="text/css" rel="stylesheet" />
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="javascript:peticionAsincrona('ControlVistas?opcion=home', 'FotosInicio', 'false');">FitnessTIME</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="javascript:peticionAsincrona('ControlVistas?opcion=home', 'FotosInicio', 'false');">HOME <span class="sr-only">(current)</span></a>
      </li>
 	&nbsp;&nbsp;&nbsp;
     <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          PRODUCTOS
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="javascript:peticionAsincrona('ControlCategoria?categoria=hombre', 'FotosInicio', 'false');">Ropa Hombre</a>
          <a class="dropdown-item" href="javascript:peticionAsincrona('ControlCategoria?categoria=mujer', 'FotosInicio', 'false');">Ropa Mujer</a>
          <a class="dropdown-item" href="javascript:peticionAsincrona('ControlCategoria?categoria=equipacion', 'FotosInicio', 'false');">Equipaciones Oficiales</a>
          <a class="dropdown-item" href="javascript:peticionAsincrona('ControlCategoria?categoria=calzado', 'FotosInicio', 'false');">Calzado</a>
        </div>
      </li>
    </ul>
      <a href="CambiarFondo?fondo=claro"><button type="button" class="btn btn-outline-info">FONDO CLARO</button></a>&nbsp;&nbsp;
      <a href="CambiarFondo?fondo=oscuro"><button type="button" class="btn btn-outline-info">FONDO OSCURO</button></a>&nbsp;&nbsp;
      <c:if test="${empty sessionScope.usuario}">
      <a href="InicioSesion.jsp"><button type="button" class="btn btn-outline-info" onclick="javascript:peticionAsincrona('ControlVistas?opcion=login','FotosInicio','false')">LOGIN</button></a>&nbsp;
      </c:if>
      <c:if test="${not empty sessionScope.usuario}">
      <a href="javascript:peticionAsincrona('ControlVistas?opcion=perfil','FotosInicio','false')"><button type="button" class="btn btn-outline-info">${sessionScope.usuario.nombre}</button></a><!--svg class="bi bi-person-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd"/></svg></button></a-->&nbsp;
      </c:if>
      <button type="button" class="btn btn-outline-info" onclick="javascript:peticionAsincrona('ControlVistas?opcion=pagar','FotosInicio','false')"><svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" viewBox="0 0 512 512"><title>ionicons-v5-d</title><circle cx="176" cy="416" r="32"/><circle cx="400" cy="416" r="32"/><path d="M456.8,120.78A23.92,23.92,0,0,0,438.24,112H133.89l-6.13-34.78A16,16,0,0,0,112,64H48a16,16,0,0,0,0,32H98.58l45.66,258.78A16,16,0,0,0,160,368H416a16,16,0,0,0,0-32H173.42l-5.64-32H409.44A24.07,24.07,0,0,0,433,284.71l28.8-144A24,24,0,0,0,456.8,120.78Z"/></svg></button>
  </div>
</nav>
<div id="FotosInicio" style="width:90%; margin:auto;">
	  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
	  <ol class="carousel-indicators">
	    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
	    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
	    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
	  </ol>
	  <div class="carousel-inner">
	    <div class="carousel-item active">
	      <img src="images/imagen1.jpg" class="d-block w-100" alt="...">
	      <div class="carousel-caption d-none d-md-block">
	        <h5>FitnessTIME</h5>
	        <p>FÍSICAMENTE FUERTE, MENTALMENTE INDESTRUCTIBLE</p>
	      </div>
	    </div>
	    <div class="carousel-item">
	      <img src="images/imagen4.png" class="d-block w-100" alt="...">
	      <div class="carousel-caption d-none d-md-block">
	        <h5>ENTRENA, INSISTE, PERSISTE, ¡RESISTE!</h5>
	        <p>ENTRENA, INSISTE, PERSISTE, ¡RESISTE!</p>
	      </div>
	    </div>
	    <div class="carousel-item">
	      <img src="images/imagen5.png" class="d-block w-100" alt="...">
	      <div class="carousel-caption d-none d-md-block">
	        <h5>#YOMEQUEDOENCASA</h5>
	        <p>SI VAS A ESTAR EN CUARENTENA, APROVECHA PARA LLEVAR UNA VIDA FITNESS</p>
	      </div>
	    </div>
	  </div>
	  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	</div>
</div>
   <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>