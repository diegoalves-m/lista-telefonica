angular.module("listaTelefonica").filter("name", function() {
	return function (input) {
		var listaNomes = input.split(" ");
		var nomesFormatados = listaNomes.map(function(nome) {
			if(/(da|de|dos|do|das)/.test(nome)) return nome;
			return nome.charAt(0).toUpperCase() + nome.substring(1).toLowerCase();
		});
		return nomesFormatados.join(" ");
	};
});