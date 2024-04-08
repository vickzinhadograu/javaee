<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda de Contatos</title>
<link rel="icon" href="imagem/telefone.png">
<link rel="icon" href="imagem/contato.jpg">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	
	<h1>Criar Novo Contato</h1>
	<img alt="agenda" src="imagem/contato.jpg">
	<form name = "frmContato" action="editar">
	<table>
	<tr> 
		<td><input type="text" class="Caixa3" name="idcon" readonly value="<% out.print(request.getAttribute("idcon")); %>">
		
		</td>
	</tr>
		<tr>
		 	<td><input type="text" class="Caixa1" name="nome" value="<% out.print(request.getAttribute("nome"));%>"> </td>
		</tr>
		<tr>
		 	<td><input type="text" class="Caixa2" name="fone" value="<% out.print(request.getAttribute("fone"));%>"> </td>
		</tr>
		<tr>
		 	<td><input type="text" class="Caixa1" name="email" value="<% out.println(request.getAttribute("email"));%>">  </td>
		</tr>
	</table>
		<input type="submit" value="Editar" class="Botao1" onclick="validar()">
		
	</form>
	<script type="text/javascript" src="scripts/validacao.js"></script>
</body>
</html>