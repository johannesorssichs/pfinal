<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<script type='text/javascript' src="js/scripts.js"></script>
<title>FitnessTime</title>
</head>
<body>
<header><a href="Portada.jsp">Volver a Inicio</a></header>
<div style="width:40%;margin:auto;margin-top:50px;">
<div style="text-align:center;">
<img src="images/logojpg.jpg" class="logo" style="width:15vw;height:15vw;border-radius:20px"><br/><br/>
</div>
<label id="mensajeError" style="color:red">${requestScope.mensajeError}</label>
<form role="form" action="Login" name="formulario" onsubmit="javascript:return validarCampos()" method="post">
  <div class="form-group">
    <label for="email">Usuario:</label>
    <input type="text" class="form-control" name="user" id="user">
  </div>
  <div class="form-group">
    <label for="pwd">Contraseña:</label>
    <input type="password" class="form-control" name="pwd" id="pwd">
  </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Acceder</button>&nbsp;&nbsp;&nbsp;<input type="radio" name="admin" value="true">Acceder como Administrador
    </div>
</form>
    ¿Aún no eres cliente? <a href="Registro.jsp">¡Regístrate!</a>
</div>
   <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>