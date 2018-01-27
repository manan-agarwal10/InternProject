<!DOCTYPE html>
<html ng-app="appRegistration">
<head>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>
  <script>
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
		   "appId":1,
		  "applicationName":$scope.app_name,
	      "lastModifiedBy":1,
	      "lastModifiedDate":null
	  };
	  console.log("https://localhost:8080/ACLProject/users/"+data);    
	  var response = $http.post("http://localhost:8080/AccessControlListService/PostFormData",data);
	  console.log(data);
	  $scope.list.push(data);
	  }; 
	    
	  });
	    
	})();
  </script>
</head>
  <style>
  th, td {
    padding: 5px;
    text-align: left;
  }
</style>
<body ng-controller="MainController">
  <div style="text-align: center;padding-bottom: 5% ;width: 80%;margin: 0 20% 0 20%;background-color:#BEBEBE;">
  <header>
    <h1> Registring Application Form</h1>
  </header>
    <form style="text-align: center;" name="registerApp" ng-submit="save()"  style="height:10%">
      <div class="appName">
	  <label class='appNameLabel'> Application Name</label>
	  <input type="text" placeholder="Applicaion Name" id="app_name" required ng-model="app_name" />
	  </div>
	  <div class="adminId">
	  <label class='adminIdLabel'> AdminId</label>
	  <input type="text" placeholder="Admin Id" required id="admin_id" ng-model="admin_id" />
	  </div>
	  
      <input type="submit" value="Submit">
    </form>
  </div>

  <p>
  	Form Data:{{list}}
  </p>
</body>

</html>