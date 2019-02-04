var myAngularApp = angular.module('myAngularApp', [])
myAngularApp.controller('mainController', function(){

  $scope.yourName = "Tom";

  $scope.users = [
    'Tom', 'Tim', 'Tam', 'Robert'
  ]

  $scope.logIt = function( ){
    console.log(scope.yourName);
  }


  $scope.validate = function(){
    return $scope.yourName.length > 3;
  }
}
