<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"  href="css/login.css">
<link rel="icon" href="css/banco.png" type="image/x-icon">
</head>
<body>
	
			<h1>ACCESO A BANCA</h1>

			<div id="divCenter">

				<form action="Validate" method="post">
				
					<h2>Numero de Cuenta</h2>
					<span><input class="inputWidth"type="text" name="numeroCuenta" placeholder="Numero De Cuenta" required /></span>
					<h2>Acceder</h2>
					<span><input class="inputSubmit" type="submit" value="Acceder" /></span>

				</form>

			</div>
		
</body>
</html>