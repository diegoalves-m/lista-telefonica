
angular.module("listaTelefonica").controller("listaTelefonicaCtrl", function($scope, $http) {

    $scope.app = "Lista telefonica";
    $scope.message = "";
    $scope.contatos = [];
    $scope.operadoras = [];

    var carregarContatos = function() {
    	$http({
            method: 'GET',
            url: 'http://localhost:8080/listatelefonica/all'
            }).then(function successCallback(response) {
                $scope.contatos = response.data;
                
                if($scope.contatos.length == 0) {
            		$scope.message = "Sem registros";
            	} else {
            		$scope.message = "";
            	}
                
            }, function errorCallback(response) {
                $scope.message = "Servidor indisponivel";
        });
    	
    };

    var carregarOperadoras = function() {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/operadoras'
            }).then(function successCallback(response) {
                $scope.operadoras = response.data;
            }, function errorCallback(response) {
                $scope.message = "Servidor indisponivel";
        });
    
    };

    $scope.salvar = function (contato) {
        $http({
            method: 'POST',
            url: 'http://localhost:8080/listatelefonica',
            data: contato
            }).then(function successCallback(response) {
                delete $scope.contato;
                $scope.contatoForm.$setPristine();
                carregarContatos();   
            }, function errorCallback(response) {
                $scope.message = "Servidor indisponivel";
        });
    };

    $scope.excluir = function(contatos) {
    	contatos.forEach(function(contato) {
    		if(contato.selecionado) {
    			var id = contato.id;
    	    	$http({
    	            method: 'DELETE',
    	            url: 'http://localhost:8080/listatelefonica/' + id
    	            }).then(function successCallback(response) {
    	                carregarContatos();   
    	            }, function errorCallback(response) {
    	                $scope.message = "Servidor indisponivel";
    	        });
    		}
    	});
    };

    $scope.isContatoSelecionado = function(contatos) {
        return contatos.some(function(contato) {
            return contato.selecionado;
        });
    };

    carregarOperadoras();
    carregarContatos();

});