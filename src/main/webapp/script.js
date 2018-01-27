(function() {  
   var app = angular.module("appRegistration", []);
   
  app.controller("MainController",function($scope, $http) {
    
	$scope.app1=
	{
		app_name:"",
		admin_Id:""
	};
  $scope.list = [];
  $scope.save = function() {
  var data ={
      "app_name":$scope.app_name,
      "admin_id":$scope.admin_id
  };
  // console.log("https://localhost:8080/ACLProject/users/"+JSON.stringify(app1));    
	var response = $http.post('http://localhost:8080/AccessControlListService/PostFormData', data);
  console.log(data);
  $scope.list.push(data);
  }; 
    
  });
    
})();