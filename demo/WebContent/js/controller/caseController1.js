
app.controller('casecontroller1',function($scope,solrstorage,$log,$http,$window,$q,$location){

	var promise4 = solrstorage.getData($scope.caseTitle);
	promise4.then(function(response){
		
		console.log(response.response.docs);
		var defer = $q.defer();
		var message = response.response.docs;
		for ( var msg in message) {
			// if(message[msg].topicTitle ==
			// "tSchemaComplianceCheck tripping due to
			// misread of Excel input")
			$scope.messages = message[msg];

		}
		console.log($scope.messages);
	});
});




/*app
		.controller(
				'casecontroller',
				function($scope, $log, $http) {

					var url = "";
					url = "http://bigdata1vm1:8983/solr/talend/select?indent=on&wt=json&fl=topicTitle,topicBody&q=";
					$scope.view = function() {
						url += $scope.caseTitle;
						console.log(url);

						// var a = url + $('textarea#caseTitle').val();

						alert("got response");
						$http.get(url).then(function(response) {
							var defer = $q.defer();
							var message = response.data.response.docs;
							for ( var msg in message) {
								// if(message[msg].topicTitle ==
								// "tSchemaComplianceCheck tripping due to
								// misread of Excel input")
								$scope.messages = message[msg];

								// alert(JSON.stringify(data));

							}

						});
					}
				});*/
