<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>${initParam.titulo}</title>
</head>
<body>
<div style="width:80%;margin:auto">
<c:if test="${sessionScope.usuario.admin==0}">
<div style="text-align:center">
<h3>Perfil: ${sessionScope.usuario.usuario}</h3>
</div>
<br/><br/>
<table class="table table-borderless">
    <tr>
      <th scope="row">Nombre</th>
      <td>${sessionScope.usuario.nombre}</td>
    </tr>
    <tr>
      <th scope="row">Teléfono</th>
      <td>${sessionScope.usuario.telf}</td>
    </tr>
    <tr>
      <th scope="row">Dirección de Envío</th>
      <td>${sessionScope.usuario.direccion}, ${sessionScope.usuario.ciudad}, ${sessionScope.usuario.provincia}</td>
    </tr>
</table>
</div>
<div style="width:80%;margin:auto">
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
          Cambiar Contraseña
        </button>
      </h2>
    </div>
    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
       <jsp:include page="Modificar.jsp"/>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Ver Historial de Compras
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
      <jsp:include page="Historial.jsp"/>
      </div>
    </div>
  </div><br/>
   <a href="ModificarDatos?accion=eliminar"><button type="button" class="btn btn-outline-info">Eliminar Cuenta</button></a>&nbsp;&nbsp;<a href="Logout"><button type="button" class="btn btn-outline-info">Cerrar Sesión</button></a>
</div>
</c:if>
<!-- ADMIN -->
<c:if test="${sessionScope.usuario.admin==1}">
<br/><br/>
<div style="width:80%;margin:auto">
<div class="accordion" id="accordionExample">
  <div class="card">
    <div class="card-header" id="headingOne">
      <h2 class="mb-0">
        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
          Añadir Producto
        </button>
      </h2>
    </div>
    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordionExample">
      <div class="card-body">
       <jsp:include page="NuevoProducto.jsp"/>
      </div>
    </div>
  </div>
  <div class="card">
    <div class="card-header" id="headingTwo">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          Lanzar Oferta
        </button>
      </h2>
    </div>
    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
      <div class="card-body">
            <form action="ModificarProductos">
      <select class="custom-select" name="ofertaProducto">
      <option selected>Elija el Producto sobre el que desea lanzar una oferta</option>
      <c:forEach var="todos" items="${sessionScope.todosProductos}"> 
		  <option value="${todos.referencia}">${todos.referencia} - ${todos.nombre}</option>
	</c:forEach>
	</select><br/><br/>
	Nuevo Precio: <input type="text" class="form-control" id="nuevoPrecio" name="nuevoPrecio" style="width:20%"> <br/><br/>
	<input type="submit" class="btn btn-outline-info" name="action" value="Lanzar Oferta">
	</form>
      </div>
    </div>
  </div>
   <div class="card">
    <div class="card-header" id="headingThree">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          Dar de Baja un Producto
        </button>
      </h2>
    </div>
    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
      <div class="card-body">
      <form action="ModificarProductos">
      <select class="custom-select" name="removeProducto">
      <option selected>Elija el Producto que desea eliminar</option>
      <c:forEach var="todos" items="${sessionScope.todosProductos}"> 
		  <option value="${todos.referencia}">${todos.referencia} - ${todos.nombre}</option>
	</c:forEach>
	</select><br/><br/>
	<input type="submit" class="btn btn-outline-info" name="action" value="Eliminar Producto">
	</form>
      </div>
    </div>
  </div>
    <div class="card">
    <div class="card-header" id="headingFour">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          Modificar Producto
        </button>
      </h2>
    </div>
    <div id="collapseFour" class="collapse" aria-labelledby="headingFour" data-parent="#accordionExample">
      <div class="card-body">
      <form action="ModificarProductos">
      <select class="custom-select" name="modificarProducto">
      <option selected>Elija el Producto que desea modificar</option>
      <c:forEach var="todos" items="${sessionScope.todosProductos}"> 
		  <option value="${todos.referencia}">${todos.referencia} - ${todos.nombre}</option>
	</c:forEach>
	</select><br/><br/>
	   <div class="form-group col-md-6">
      <label for="nombreProd">Nombre Producto</label>
      <input type="text" class="form-control" id="nombreProd" name ="nombreProd">
    </div>
	<div class="form-group">
	    <label for="descripcion">Descripcion</label>
	    <textarea class="form-control" id="descripcion" rows="3" name="descripcion"></textarea>
   </div>
   <input type="submit" class="btn btn-outline-info" name="action" value="Modificar Producto">
	</form><br/><br/>
      </div>
    </div>
  </div>
       <div class="card">
    <div class="card-header" id="headingFive">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          Ver Productos más Comprados
        </button>
      </h2>
    </div>
    <div id="collapseFive" class="collapse" aria-labelledby="headingFive" data-parent="#accordionExample">
      <div class="card-body">
      <jsp:include page="ProductosPopulares.jsp"/> 
      </div>
    </div>
  </div>
      <div class="card">
    <div class="card-header" id="headingSix">
      <h2 class="mb-0">
        <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
          Ver Días de más Compras
        </button>
      </h2>
    </div>
    <div id="collapseSix" class="collapse" aria-labelledby="headingSix" data-parent="#accordionExample">
      <div class="card-body">
      <jsp:include page="DiasPopulares.jsp"/> 
      </div>
    </div>
  </div>
</div><br/>
<a href="Logout"><button type="button" class="btn btn-outline-info">Cerrar Sesión</button></a>
</c:if>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>