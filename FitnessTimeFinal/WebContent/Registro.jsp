<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<header><a href="Portada.jsp">Volver a Inicio</a></header>
<body>
<form action="Registro" method="post">
<div style="width:70%;margin:auto;margin-top:50px;">
 <div style="float:left;margin:20px;padding-top:110px;text-align:center;"> 
 <img src="images/logojpg.jpg" class="logo" style="width:15vw;height:15vw;border-radius:20px">
</div>
 <div style="float:left;margin:20px;padding-top:40px">
    <div class="form-group"> 
        <label for="full_name_id" class="control-label">Nombre</label>
        <input type="text" class="form-control" id="full_name_id" name="nombre" placeholder="Juan Pérez">
    </div>
    <div class="form-group"> 
        <label for="email_id" class="control-label">Usuario</label>
        <input type="text" class="form-control" id="email_id" name="user" placeholder="juanperez">
    </div>
    <div class="form-group"> 
   		<label for="pwd_id" class="control-label">Contraseña</label>
    	<input type="password" class="form-control" id="pwd_id" name="pwd">
    </div>
    <div class="form-group"> 
   		<label for="movil_id" class="control-label">Teléfono Móvil</label>
    	<input type="text" class="form-control" id="movil_id" name="movil">
    </div></br>
    <div class="form-group" style="text-align:center"> <!-- Submit Button -->
        <button type="submit" class="btn btn-primary">Registrarse</button>
    </div> 
 </div>
 <div style="float:left;margin:20px;padding-top:40px">    
    <div class="form-group"> 
        <label for="street1_id" class="control-label">Dirección</label>
        <input type="text" class="form-control" id="street1_id" name="dir" placeholder="Calle, nº, piso, escalera">
    </div>                                                 
    <div class="form-group"> 
        <label for="city_id" class="control-label">Ciudad</label>
        <input type="text" class="form-control" id="city_id" name="ciudad" placeholder="Vitoria">
    </div>                                                              
    <div class="form-group">
        <label for="comunidad_id" class="control-label">Provincia</label>
        <select class="form-control" id="state_id" name="provincia">
            <option value="Alaba">Álaba</option>
            <option value="Albacete">Albacete</option>
            <option value="Alicante">Alicante</option>
            <option value="Almeria">Almeria</option>
            <option value="Asturias">Asturias</option>
            <option value="Avila">Ávila</option>
            <option value="Badajoz">Badajoz</option>
            <option value="Baleares">Baleares</option>
            <option value="Barcelona">Barcelona</option>
            <option value="Burgos">Burgos</option>
            <option value="Caceres">Cáceres</option>
            <option value="Cadiz">Cádiz</option>
            <option value="CiudadReal">Ciudad Real</option>
            <option value="Cordoba">Córdoba</option>
            <option value="Coruña">Coruña</option>
            <option value="Cuenca">Cuenca</option>
            <option value="Gerona">Gerona</option>
            <option value="Granada">Granada</option>
            <option value="Huesca">Huesca</option>
            <option value="Jaen">Jaén</option>
            <option value="LaRioja">La Rioja</option>
            <option value="LasPalmas">Las Palmas</option>
            <option value="Leon">León</option>
            <option value="Lerida">Lérida</option>
            <option value="Lugo">Lugo</option>
            <option value="Madrid">Madrid</option>
            <option value="Malaga">Málaga</option>
            <option value="Melilla">Melilla</option>
            <option value="Murcia">Murcia</option>
            <option value="Navarra">Navarra</option>
            <option value="Orense">Orense</option>
            <option value="Palencia">Palencia</option>
            <option value="Pontevedra">Pontevedra</option>          
            <option value="Salamanca">Salamanca</option>
            <option value="Segovia">Segovia</option>
            <option value="Sevilla">Sevilla</option>
            <option value="Soria">Soria</option>
            <option value="Tarragona">Tarragona</option>
            <option value="Tenerife">Tenerife</option>
            <option value="Teruel">Teruel</option>
            <option value="Toledo">Toledo</option>
            <option value="Valencia">Valencia</option>
            <option value="Valladolid">Valladolid</option>
            <option value="Vizcaya">Vizcaya</option>
            <option value="Zamora">Zamora</option>
            <option value="Zaragoza">Zaragoza</option>
        </select>                    
    </div>    
    <div class="form-group"> <!-- Zip Code-->
        <label for="zip_id" class="control-label">Código Postal</label>
        <input type="text" class="form-control" id="zip_id" name="cp" placeholder="#####">
    </div>             
 </div>      
</form>
<label id="mensajeError" style="color:red">${requestScope.mensajeError}</label>
   <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
  </body>
</html>