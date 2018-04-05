/**
 * 
 */
app.service('solrstorage', function ($http,$q) {
	
	var url = "http://localhost:8983/solr/Schneider/select?defType=dismax&qf=title^10 content^5&wt=json&fl=*,score&facet=true&facet.field=kbType&facet.field=docType&facet.field=product&facet.mincount=1&hl=true&hl.fl=title,content&hl.fragsize=300&hl.simple.pre=<b>&hl.simple.post=</b>";
	
	
	this.getData = function(){
		var defer = $q.defer();
		
		$http.get(url+"&q.alt=*")
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
	this.getDataWithStart = function(start,search){
		var defer = $q.defer();
		$http.get(url+"&start="+start+search)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
	this.getDataWithFacet = function(start,search,facet){
		var defer = $q.defer();
		$http.get(url+"&start="+start+search+facet)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	this.getDataSearchTerm = function(search){
		var defer = $q.defer();
		$http.get(url+"&q="+search)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
	this.getSolrData = function(search,facet,perPage,start,sort){
		
	};
	
});

