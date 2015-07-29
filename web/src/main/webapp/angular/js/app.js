var phonecatApp = angular.module('phonecatApp', ['ngRoute']);
javaProjectApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/hello', {
                templateUrl: 'angular/.html',
                controller: 'PhoneListCtrl'
            }).
            otherwise({
                redirectTo: '/hello'
            });
    }]);