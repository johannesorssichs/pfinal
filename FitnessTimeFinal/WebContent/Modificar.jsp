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
<div style="width:40%;margin:auto;margin-top:50px;">
<div style="text-align:center;">
<img src="images/logojpg.jpg" class="logo" style="width:10vw;height:10vw;border-radius:20px"><br/><br/>
</div>
<label style="color:green">${requestScope.mensajeCambio}</label>
<form role="form" action="ModificarDatos" name="formulario" method="post">
  <div class="form-group">
    <label for="email">Nueva Contraseņa:</label>
    <input type="password" class="form-control" name="pwd" id="pwd">
  </div>
    <div class="form-group">
        <button type="submit" class="btn btn-primary">Cambiar Contraseņa</button>
    </div>
</form>
</div>
   <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>