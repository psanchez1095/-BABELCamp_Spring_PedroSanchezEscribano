<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet"  href="css/login.css">
</head>
<body>
	
			<h1>LOGIN</h1>

			<div id="divContentDer">

				<form action="Validar" method="post">
				
					<h2>Correo / Nombre de Usuario</h2>
					<span><input type="text" name="usuario" placeholder="Correo / Nombre de Usuario" required /></span>
					<h2>Contraseña</h2>
					<span><input type="password" name="password" placeholder="Contraseña" required /></span>
					<h2>Acceder</h2>
					<span><input type="submit" value="Acceder" /></span>

				</form>

			</div>
</body>
</html>