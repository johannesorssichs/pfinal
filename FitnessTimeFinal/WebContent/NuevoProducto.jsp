<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<head>
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width:50%;margin:auto">
<h3>Nuevo Producto</h3>
<form action="ModificarProductos">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="nombreProd">Nombre Producto</label>
      <input type="text" class="form-control" id="nombreProd" name ="nombreProd">
    </div>
    <div class="form-group col-md-6">
      <label for="precio">Precio</label>
      <input type="text" class="form-control" id="precio" name="precio">
    </div>
  </div>
<div class="form-group">
    <label for="descripcion">Descripcion</label>
    <textarea class="form-control" id="descripcion" rows="3" name="descripcion"></textarea>
  </div>
      <div class="form-group">
        <label class="control-label">Categoria</label>
        <select class="form-control" id="categoria" name="categoria">
        <option value="hombre">Hombre</option>
        <option value="mujer">Mujer</option>
        <option value="calzado">Calzado</option>
        <option value="equipacion">Equipación</option>
      </select>
    </div>
  <input type="submit" class="btn btn-primary" name="action" value="Añadir">
</form>
</div>
<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>