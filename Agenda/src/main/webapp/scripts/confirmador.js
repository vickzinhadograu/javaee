/**
 * Confirmação de exclusão de um contato
 * @author Vitória Emanuelle
 */
function confirmar(idcon){
	let resposta = confirm("Deseja realemnte excluir este contato?")
	if(resposta===true){
		//alert(idcon)
		window.location.href="delete?idcon=" +idcon
		
	}
}