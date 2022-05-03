<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retirar Dinero</title>
<link rel="stylesheet"  href="css/alta.css">
</head>
<body>
<div class="divAlta">

	<h1>RETIRAR DINERO</h1>
	<form action="Draw" method="post">
		
		<h2>Numero De Cuenta</h2>
		<span><input type="number" name="numeroCuenta"
			placeholder="Numero Cuenta" required /></span>
		<h2>Cantidad</h2>
		<span><input type="number" name="cantidad"
			placeholder="Cantidad" required /></span>
		
		 <input type="submit"value="Retirar Dinero" />

	</form>
	
</div>
</body>
</html>