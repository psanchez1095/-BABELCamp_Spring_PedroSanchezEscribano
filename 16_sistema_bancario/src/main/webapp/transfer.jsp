<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transferir Dinero</title>
<link rel="stylesheet" href="css/alta.css">
<link rel="icon" href="css/banco.png" type="image/x-icon">
</head>
<body>
	<div class="divAlta">

		<h1>TRANSFERIR DINERO</h1>

		<form action="Transfer" method="post">

			<h2>Numero De Cuenta Origen</h2>
			<span><input type="number" name="numeroCuentaOrigen"
				placeholder="Numero De Cuenta Origen" required /></span>
			<h2>Numero De Cuenta Destino</h2>
			<span><input type="number" name="numeroCuentaDest"
				placeholder="Numero De Cuenta Destino" required /></span>
			<h2>Cantidad a Transferir</h2>
			<span><input type="number" name="cantidad"
				placeholder="Cantidad" required /></span> <input type="submit"
				value="Transferir Dinero" />

		</form>
	</div>
</body>
</html>