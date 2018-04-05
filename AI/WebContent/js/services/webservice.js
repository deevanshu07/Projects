/**
 * 
 */

app.service('solrstorage', function ($http,$q,$log) {
	
	var url = "NewFile.jsp?";
	var ques;
	
	this.getData = function(query,start,rows,facet,range,order){
		var defer = $q.defer();
		if(query =="" || query == undefined)
			query = "solrStart="+start+"&noOfResults="+rows;
		else{
			ques = query;
			query = "query="+query+"&solrStart="+start+"&noOfResults="+rows;
		}
		if(facet != undefined && facet!= ''){
			query = query+"&filterQuery="+facet;
		}
		if(range != undefined && range != ''){
			query = query +"&dateRangeMappingValue="+range;
		}
		if(order != undefined && order!= ''){
			var str = order.split('_');
			var mlApplied = str[0];
			//alert(mlApplied);
			query = query+"&order="+str[1]+"&sortField="+str[0];
			//if( mlApplied == "kudosCount"){
				//if(ques!= undefined || ques == "")
				//{
					//query=query+"&rq={!ltr%20model=lethiumModel%20reRankDocs=200%20efi.user_query="+ques+"}&fl=*,[features],score";
				//}
			//} 
			//else if( mlApplied === "score")
			//{
				// query = query+"&order="+str[1]+"&sortField="+str[0];
			//}
		}
		
		
		
		//alert( 'q ' + query);
		$http.get(url+query)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    	$log.info(response.data);
	    });
		return defer.promise;
	};
	
	this.initData = function(start,rows){
		var defer = $q.defer();
		var query = "solrStart="+start+"&noOfResults="+rows;
		$http.get(url+query)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
	this.clickThrough = function(linkPosition,title,docId,searchId){
		$log.info('In click Through Service {\n'+'linkPosition:'+linkPosition+'\ntitle:'+title+'\ndocId:'+docId+'\nsearchId:'+searchId+'\n}');
		var defer = $q.defer();
		docId = encodeURI(docId);
		$http.get("clickthrough.jsp?"+"linkPosition="+linkPosition+"&title="+title+"&docId="+docId+"&searchId="+searchId)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
	this.getSuggestion = function(q){
		$log.info('in get suggestion');
		var defer = $q.defer();
		$http.get("NewFile2.jsp?"+"q="+q)
	    .then(function(response) {
	    	defer.resolve(response.data);
	    });
		return defer.promise;
	};
	
});