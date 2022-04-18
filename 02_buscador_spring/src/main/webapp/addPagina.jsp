<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Añadir Pagina</title>
</head>
<body>
<form action="AddPagina" method="post">
  <input type="text" name="direccion" placeholder="URL Página"><br>
  <input type="text"  name="tematica"  placeholder="Tematica">
  <br>
  <input type="text" name="descripcion"  placeholder="Descripción">
  <br>
  <br>
  <input type="submit" value="Añadir Página">
</form>
</body>
</html>