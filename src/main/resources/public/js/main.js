var app = angular.module("springBootPetProject", []);
app.controller("AppCtrl", function ($scope, $http) {
    $scope.websites = [];

    $http.get('http://localhost:8099/api/stackoverflow/stackExchange').success(function (data) {
        $scope.websites=data;
    });


});

app.controller("AppCtrlDB", function ($scope, $http) {
    $scope.websites = [];

    $http.get('http://localhost:8099/api/stackoverflow/db').success(function (data) {
        $scope.websites=data;
    });


});