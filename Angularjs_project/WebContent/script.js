var app = angular.module("myApp", []);
app.directive("w3TestDirective", function() {
	return {
		template : "I am in a constructor"
	};
});
app.run(function($rootScope) {
    $rootScope.color = 'blue';
});
app.controller("myController", function($scope) {
	
	$scope.names = [ {
		name : "Deevanshu",
		country : "India"
	}, {
		name : "Dev",
		country : "USA"
	}, {
		name : "Deven",
		country : "China"
	} ];
});

