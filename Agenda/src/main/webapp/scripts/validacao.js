/**
 * Valiação de Formulário
 * @autor Vitória Emanuelle 
 * 
 */
function validar() {
	//alert('teste')
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value
	 
	 if (nome=== "")	{
 	alert("Preencha o campo nome!")
 	frmContato.nome.focus()
 	return false
 	}else if(fone=== "") {
		 alert("Preencha o campo fone!")
		 frmContato.fone.focus()
		 return false
	 }else{
		 document.forms["frmContatos"].submit()
	 }
	 
 	 
 	
}
