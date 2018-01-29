<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="main.css" >

<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.js">
    </script>
<title>ACL</title>

<script >

var app = angular.module('ACL',[]);

app.controller('ACLController', function($scope,$http,$window){

$scope.login =  function()
{
console.log($scope.userName+" " + $scope.password);

var req = {
 method: 'POST',
 url: 'http://localhost:8080/AccessControlListService/validateLogin' , 


data: { adminId:null ,adminName: $scope.userName , adminPassword : $scope.password }
}



$http(req).then(function(response){

 console.log("RRRR"+response.data);
if(response.data === "true"){
alert("login successful");
 $window.location.href = "AdminPage.html";
 }
 else{
  alert("sorry !! Wrong Credentials" );
   $window.location.href = "index.html";

  }

 
console.log($scope.password +" " + $scope.userName+" " +response.data.adminId)
},
 function(){
 alert("sorry !! Wrong Credentials" );
 console.log("error")
 });

}

});

</script>

</head>



<body ng-app="ACL" ng-controller="ACLController" style="background-color: #76b852;">
<div style="width:600px;background-color: #9DC26F; margin:100 auto; padding: 50px 50px 50px 50px; border: 2px solid ">

<label>UserName : <input type="text" id="text_user"  ng-model="userName"></label><br><br>


<label>Password : <input type="password"   ng-model="password"></label><br><br>


<input type="button" ng-click="login()" value ="login" style="width:270px;background-color:#00FF00"><br>


</div>



</body>
</html>

