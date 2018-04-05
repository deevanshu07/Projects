/**
 * 
 */

app.service('solrstorage', function ($http,$q,$log) {
	var url = "NewCase.jsp?";
	
	this.getData = function(query){
		
		query="q="+query;
		var defer = $q.defer();
		$http.get(url+query)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    	$log.info(response.data);
	    });
		return defer.promise;
	};
	
	
});