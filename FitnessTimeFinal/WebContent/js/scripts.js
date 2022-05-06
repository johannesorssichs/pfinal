function validarCampos() 
{
	if((document.formulario.user.value.length===0)||(document.formulario.pwd.length===0))
		{
			document.getElementById("mensajeError").innerHTML="Rellene los campos obligatorios";
			return false;
		}
}

function peticionAsincrona(url, div, update)
{
    var xmlHttpReq = new XMLHttpRequest();
    xmlHttpReq.onreadystatechange=function()
    {
        if (xmlHttpReq.readyState === 4 && xmlHttpReq.status === 200)
        {
        	
            document.getElementById(div).innerHTML = xmlHttpReq.responseText;
            if(update)
                mostrarActualizacion('actualizado');
        }
    };

    xmlHttpReq.open('GET', url, true); 
    xmlHttpReq.send();    
}    

function peticionAsincronaPOST(url, idDiv, data)
{
    var xmlHttpReq = new XMLHttpRequest();
    xmlHttpReq.onreadystatechange=function()
    {
        if (xmlHttpReq.readyState === 4 && xmlHttpReq.status === 200)
            document.getElementById(idDiv).innerHTML = xmlHttpReq.responseText;
    };

    xmlHttpReq.open('POST', url, true); 
    xmlHttpReq.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xmlHttpReq.send(data);
}



