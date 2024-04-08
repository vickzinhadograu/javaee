<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    <% 
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
    %>
    	<%--for (int i =0; i<lista.size(); i++) {
    	out.println(lista.get(i).getIdcon());
    	out.println(lista.get(i).getNome());
    	out.println(lista.get(i).getFone());
    	out.println(lista.get(i).getEmail());
    }
   	--%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda De Contatos</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="icon" href="imagem/agenda1.png">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	
	
	<a href="novo.html" class="Botao1">Novo contato</a>
	
	<a href="report" class="Botao2">Relatorio</a>
	
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>	
		</thead>
		<tbody>
		<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getIdcon() %> </td>
				<td><%=lista.get(i).getNome() %></td>
				<td><%=lista.get(i).getFone() %></td>
				<td><%=lista.get(i).getEmail() %></td>
				
				<td><a href="select?idcon=<%= lista.get(i).getIdcon()%>" class="Botao1">Editar</a></td>
				<td><a href="javascript:confirmar(<%= lista.get(i).getIdcon() %>)" id="BotaoDeletar">Deletar</a></td>
				
			</tr>	
		<%}%>
			
		</tbody>		
	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>