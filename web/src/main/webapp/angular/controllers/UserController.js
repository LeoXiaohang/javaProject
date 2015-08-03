//angular.module('javaProjectApp', [])
//.controller('userController', function ($scope, $http) {
//        $http.get('/web/hello').success(function(data) {
//            $scope.persons = data;
//        });
//    });

angular.module('javaProjectApp', [])
    .controller('userController', ['$scope', '$http',
        function ($scope, $http) {
            $http.get('/web/hello').success(function(data) {
                $scope.persons = data;
            });
        }]);

angular.module('javaProjectApp', [])
    .controller('deleteController', ['$scope', '$http',
    function ($scope, $http) {
        $http.get('phones/phones.json').success(function(data) {
            $scope.phones = data;
        });

        $scope.orderProp = 'age';
    }]);