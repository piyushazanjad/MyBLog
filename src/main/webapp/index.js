
(function () {
	
'use strict';

var app = angular.module('BlogApplication', ['ngRoute']);

app.controller('BlogController',['$http','$scope', function ($http, $scope) {

	 $("#blog").hide();
	 $("#post_blog").hide();
	 $("#logout").hide();
	// $("#login").show();
	 
	 $scope.author_name="";
	$scope.all_blogs = [];
	// $('#datetimepicker1').datetimepicker();

	$http({
        method: 'GET',
        url: 'webapi/blogs/getblogs',
        contentType: "application/json; charset=utf-8",
        dataType: "application/json",
//        data: {
//        	"author":$scope.author,
//    		"blog":$scope.blog
//        }
//       
    }).then(function successCallback(response) {
        $scope.all_blogs=response.data;
   
        
    }, function errorCallback(response) {

    });
	
	
	$scope.view_blogs = function () {
	
	$http({
        method: 'GET',
        url: 'webapi/blogs/getblogs',
        contentType: "application/json; charset=utf-8",
        dataType: "application/json",
//        data: {
//        	"author":$scope.author,
//    		"blog":$scope.blog
//        }
//       
    }).then(function successCallback(response) {
        $scope.all_blogs=response.data;
   
        
    }, function errorCallback(response) {

    });
	}
	
	$scope.postBlog = function () {
		//alert("fUNCTION CALLED..!! ");
		
		console.log($scope.username_login);
		
		//author_name= $scope.username_login;
//		$scope.author= $scope.username;
//		$scope.blog_author_name = $scope.author;
//		
		
		$http({
            method: 'POST',
            url: 'webapi/blogs/postblogs',
            contentType: "application/json; charset=utf-8",
            dataType: "application/json",
            data: {
            	"author":$scope.author,
        		"blog":$scope.blog
            }
           
        }).then(function successCallback(response) {
            
            window.alert("Blog posted successfully..!! ");
            
            
            
        }, function errorCallback(response) {

        });
    }
	
	$scope.signup = function () {
		alert("fUNCTION CALLED..!! ");
		$http({
            method: 'POST',
            url: 'webapi/userprofile/signup',
            contentType: "application/json; charset=utf-8",
            dataType: "application/json",
            data: {
            	"fname":$scope.fname,
        		"lname":$scope.lname,
        		"username":$scope.username,
        			"password":$scope.password
            }
           
        }).then(function successCallback(response) {
            
            window.alert("User registered successfully..!! ");
           
            
        }, function errorCallback(response) {

        });
    }
	
	$scope.signin = function () {
		alert("fUNCTION CALLED..!! ");
		$http({
            method: 'GET',
            url: 'webapi/userprofile/signin' + "/" + $scope.username_login + "/"+ $scope.password_login,
            contentType: "application/json; charset=utf-8",
            dataType: "application/json",
                       
        }).then(function successCallback(response) {
            
//        	alert(response.data[1]);
//          window.alert("Login Successfull");
    console.log(response.data);
            
         
        	if(response.data==$scope.username_login)
        		{
        		 window.alert("Login Successfull");
        		 $("#blog").show();
        		 $("#post_blog").show();    //for hiding section
        		 $("#sign_up").hide();
        		 $("#signup").hide();  //for hiding section
        		 $("#login").hide();
        		 $("#signin").hide();   //for hiding section
        		 $("#logout").show();
        		 $scope.author=response.data;   
        		 console.log($scope.author_name); 
//        		 $scope.username="";
//        		 $scope.password="";
        		}
        	else{
        		 window.alert("Login Unsuccessfull. Please try again..!!! ");
        		 
        		 
        	}
        	
        }, function errorCallback(response) {

        });
    }
	
	$scope.login_div =function(){
		 $("#login").hide();
	}
	
	$scope.log_out = function(){
		 $("#blog").hide();
		 $("#post_blog").hide();    //for hiding section
		 $("#sign_up").show();
		 $("#signup").show();  //for hiding section
		 $("#login").show();
		 $("#signin").show();  
		 $("#logout").hide();
		 $scope.username="";
		 $scope.password="";
	}
	
	
}]);
})();