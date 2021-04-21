function validarCampos() {
	if(document.getElementById("nome").value == '') {
		alert("Informe o Nome!");
		return false;
	} else if(document.getElementById("setor").value == '') {
		alert("Informe o Setor!");
		return false;
	} else if(document.getElementById("salario").value == '') {
		alert("Informe o Salario!");
		return false;
	} else if(document.getElementById("email").value == '') {
		alert("Informe o Email!");
		return false;
	}else if(document.getElementById("idade").value == '') {
		alert("Informe a Idade!");
		return false;
	}
	return true;
}
