var app = angular.module('inventario', ["ngResource"]);

app.controller('InventarioController', ['$scope', '$http',

    function ($scope, $http) {
        $scope.getInventario= function () {
            $http.get('/inventario').success(function (data) {
                $scope.inventario = data;
            });
        }

    }]);


