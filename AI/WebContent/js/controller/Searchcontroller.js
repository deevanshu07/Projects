/**
 * 
 */

app.controller('Searchcontroller',function($scope,solrstorage,$log,$http,$location){
	//Contains search results.
	$scope.documentList ="";
	$scope.filterCollapsed=[true,true,true,true,true];
	//$scope.author='Darlene Fisher';
	//Number of document found in search result.
	$scope.numFound=0;
	$scope.start=0;
	$scope.range = 1;
	
	$scope.facetChange = '';
	//Used for search query
	$scope.search='';
	
	//Number of Search Results per page.
	$scope.rows = 10;
	$scope.count = -1;
	//FilterQuery
	$scope.facet = '';
	$scope.filterQuery = '';
	$scope.msg = "All Search Results";
	$scope.selectedDTFacet = [];
	$scope.selectedKBFacet = [];
	$scope.selectedProFacet = [];
	
	$scope.selectedFilters=[];
	$scope.config = {
			jsonpCallbackParam: 'JSON_CALLBACK',
			headers: { },
			// standard query params
			params: {filterQuery: '',start: 0 }
		};
	
	var searchObject = getParameterByName('test');
	alert(searchObject);
	console.log(searchObject);
	$scope.loading = "loading";
	var promise = solrstorage.getData("",$scope.start,$scope.rows);
	promise.then(function(response){
		$scope.loading = "";
		$scope.documentList = response.response.docs;
		
		$scope.numFound = response.response.numFound;
		$scope.last3months = response.facet_counts.facet_queries.last3Months;
		$scope.lastYear=response.facet_counts.facet_queries.lastYear;
		$scope.highlight=response.highlighting;
		$scope.docTypeFacet = response.facet_counts.facet_fields;
		$scope.kbTypeFacet = response.facet_counts.facet_fields;
		$scope.productFacet = response.facet_counts.facet_fields;
		$scope.start = response.response.start;
	});
	
	//method for Pagination
	$scope.pagination = function(start){
		$scope.loading = "loading";
		$scope.documentList = "";
		$scope.start=(start-1)*$scope.rows;
		var promise2 = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise2.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			$scope.last3months = response.facet_counts.facet_queries.last3Months;
			$scope.lastYear=response.facet_counts.facet_queries.lastYear;
							
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	
	//method For searching a Specific term.
	$scope.searching = function(){
		$log.info('searching');
		$scope.focus = false;
		$scope.documentList = "";
		$scope.selectedDTFacet = [];
		$scope.selectedKBFacet = [];
		$scope.selectedProFacet = [];
		$scope.loading = "loading";
		$scope.range = 1;
		$scope.facet = '';
		$scope.sortOrder="";
		$scope.start=0;
		$scope.dateRange=0;
		$scope.correctlySpelled = true;
		//alert($scope.myVar);
		var promise3 = solrstorage.getData($scope.search,0,$scope.rows);
		promise3.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			$scope.last3months = response.facet_counts.facet_queries.last3Months;
			$scope.lastYear=response.facet_counts.facet_queries.lastYear;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
		$scope.kbTypeFacet = response.facet_counts.facet_fields;
		$scope.productFacet = response.facet_counts.facet_fields;
			
			$scope.start = response.response.start;
			$scope.loading = "";
			if( response.spellcheck.correctlySpelled != undefined)
				$scope.correctlySpelled = response.spellcheck.correctlySpelled;
			if(response.spellcheck.suggestions[1].suggestion[0].word != undefined)
				$scope.suggestedWord = response.spellcheck.suggestions[1].suggestion[0].word;
		});
	};
	
	$scope.resultPerPage = function(){
		$log.info($scope.rows);
		$scope.loading = "loading";
		$scope.documentList = "";
		$scope.start = 0;
		$scope.range = 1;
		var promise4 = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise4.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	
	//method For Applying Filters to search results.
	$scope.filterSearch = function(){
		$scope.start=0;
		$scope.pagination(0);
	};
	
	
	$scope.insertDTFacet = function(facet){
		if(facet != undefined || facet != ''){
			$scope.selectedDTFacet = arrayUtil($scope.selectedDTFacet, facet);
			
			//console.log($scope.selectedDTFacet);
			$scope.filterQuery = aqToString();
			$scope.fetchResultForFacet($scope.filterQuery);
	
			
		}
	};
	
	$scope.insertKBFacet = function(facet,facetName){
		//console.log("Before facet");
		//alert(facet);
		//console.log(facetName);
		//console.log("After facet");
		if(facet != undefined || facet != ''){
			
			//alert("Inside IF FUNCTIION");
			$scope.selectedKBFacet = arrayUtil($scope.selectedKBFacet, facet);
	
			$scope.config.params.start=0;
			if (!$scope.selectedFilters[facetName]){
				$scope.selectedFilters[facetName]=[]; 
			}
			if ($scope.selectedFilters[facetName].indexOf(facet)>-1) {
				var numValLoc = $scope.selectedFilters[facetName].indexOf(facet);
				$scope.selectedFilters[facetName].splice(numValLoc,1);
			} else {
				$scope.selectedFilters[facetName].splice($scope.selectedFilters[facetName],0,facet);
			}

			$scope.filterQuery = aqToString();
			
			$scope.fetchResultForFacet($scope.filterQuery);
			
			$scope.config.params.filterQuery = aqToString();
			$scope.config.params.filterQuery1 = aqToString1();
			
		}
	};
	
	function aqToString() {
		//{!tag=doc}docType:("FAQ") AND {!tag=kb}kbType:("Knowledge Base" OR "YouTube")
		var strOut = '';
		if (fnObjSize($scope.selectedFilters)>0) {
			var key;
			
			
			for (key in $scope.selectedFilters) {
				//alert("KEY=="+key);
				if ($scope.selectedFilters[key].length>0) {
					var strChildren = '';
					
					for (var kid in $scope.selectedFilters[key]) {
						//alert($scope.selectedFilters[key]);
						strChildren += '"' + $scope.selectedFilters[key][kid] + '" OR ';
					}
					strOut += '{!tag=' + key + '}' + key+ ':(' + strChildren.slice(0,-4 )+ ')';
					
				}
				strOut += ' AND ';
			}
			strOut = strOut.slice(0,-4);
		} 
		
		return toUnicode(strOut);
	}
	
	function aqToString1() {
		//{!tag=doc}docType:("FAQ") AND {!tag=kb}kbType:("Knowledge Base" OR "YouTube")
		var strOut = '';
		if (fnObjSize($scope.selectedFilters)>0) {
			var key;
			
			
			for (key in $scope.selectedFilters) {
				//alert("KEY=="+key);
				if ($scope.selectedFilters[key].length>0) {
					var strChildren = '';
					
					for (var kid in $scope.selectedFilters[key]) {
						//alert($scope.selectedFilters[key]);
						strChildren += '"' + $scope.selectedFilters[key][kid] + '" OR ';
					}
					strOut += '{!tag=' + key + '}' + key+ ':(' + strChildren.slice(0,-4 )+ ')';
					
				}
				strOut += ' AND ';
			}
			strOut = strOut.slice(0,-4);
		} 
		
		return strOut;
	}
	
	function toUnicode(theString) {
		  var unicodeString = '';
		  for (var i=0; i < theString.length; i++) {
		    var theUnicode = theString.charCodeAt(i).toString(16).toUpperCase();
		    while (theUnicode.length < 4) {
		      theUnicode = '0' + theUnicode;
		    }
		    theUnicode = '\\u' + theUnicode;
		    unicodeString += theUnicode;
		  }
		  console.log(unicodeString);
		  return unicodeString;
		}
	function fnObjSize(obj) { var size = 0, key; for (key in obj) { if (obj.hasOwnProperty(key)) size++; } return size; }
	$scope.insertProFacet = function(facet){
		if(facet != undefined || facet != ''){
			$scope.selectedProFacet = arrayUtil($scope.selectedProFacet, facet);
			$scope.filterQuery = $scope.createFQ();
			$scope.fetchResultForFacet($scope.filterQuery);
		}
	};
	$scope.fetchResultForFacet = function(facet){
		var promise5 = '';
		$scope.loading = "loading";
		$scope.start = 0;
		$scope.documentList = "";
		$scope.numFound = "";
		$scope.range = 1;
		if(facet == ''){
			//alert("IF CONDITION");
			$scope.config.params.filterQuery1=[];
			$scope.selectedDTFacet = [];
			$scope.selectedKBFacet = [];
			$scope.selectedProFacet = [];
			promise5 = solrstorage.getData($scope.search,$scope.start,$scope.rows,'',$scope.dateRange,$scope.sortOrder);
	
			allFacetChange = true;
			$scope.facet = '';
		}
			else{
				//alert("ELSE CONDITION");
				$scope.facet = facet;
				promise5 = solrstorage.getData($scope.search,$scope.start,$scope.rows,facet,$scope.dateRange,$scope.sortOrder);
				
			}
		
		
		promise5.then(function(response){
			
			$scope.documentList = response.response.docs;		
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			$scope.last3months = response.facet_counts.facet_queries.last3Months;
			$scope.lastYear=response.facet_counts.facet_queries.lastYear;
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			

			$scope.start = response.response.start;
			$scope.loading = "";
			//alert("Everything done");
		});
		
		
	};
	
	$scope.dateRangeFilter = function(){
		var promise6 = '';
		$scope.loading = "loading";
		$scope.start = 0;
		$scope.documentList = "";
		$scope.numFound = "";
		promise6 = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise6.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			$scope.last3months = response.facet_counts.facet_queries.last3Months;
			$scope.lastYear=response.facet_counts.facet_queries.lastYear;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	$scope.sorting = function(){
		var promise7 = '';
		$scope.loading = "loading";
		$scope.start = 0;
		$scope.documentList = "";
		$scope.range = 1;
		$scope.numFound = "";
		//alert(sort);
		$scope.sortOrder=sort;
		promise7 = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise7.then(function(response){
			$scope.documentList = response.response.docs;
			
			
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	
	$scope.sortingNew = function(sort){
		var promise7 = '';
		$scope.loading = "loading";
		$scope.start = 0;
		$scope.documentList = "";
		$scope.range = 1;
		$scope.numFound = "";
		//alert(sort);
		$scope.sortOrder=sort;
		//alert($scope.sortOrder);
		promise7 = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise7.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	
	$scope.getResults = function(){
		var promise = solrstorage.getData($scope.search,$scope.start,$scope.rows,$scope.facet,$scope.dateRange,$scope.sortOrder);
		promise.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			
			$scope.docTypeFacet = response.facet_counts.facet_fields;
			$scope.kbTypeFacet = response.facet_counts.facet_fields;
			$scope.productFacet = response.facet_counts.facet_fields;
			
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	
/*	$scope.createFQ1 = function(facetName){
		var filters = 0;
		var filterQuery = '';
		

		if(createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet) != ''){
			
			filterQuery = filterQuery + createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet);
			filters++;
		}
		if(createFilterQuery("{!tag=lb}label", $scope.selectedKBFacet) != ''){
			
			
			if(filters == 1){
			
				filterQuery = filterQuery + " AND "+createFilterQuery("{!tag=Countries}Countries", $scope.selectedKBFacet);
				
				filters++;
			} else{
				if(facetName.match("Countries")){
					filterQuery = filterQuery+createFilterQuery("{!tag=Countries}Countries", $scope.selectedKBFacet);
					filters++;
				}
				
				else if(facetName.match("Genres")){
					filterQuery = filterQuery+createFilterQuery("{!tag=Genres}Genres", $scope.selectedKBFacet);
					filters++;
				}
				
				else if(facetName.match("Languages")){
					filterQuery = filterQuery+createFilterQuery("{!tag=Languages}Languages", $scope.selectedKBFacet);
					filters++;
				}
				
				
			}
		}
		if(createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet) != ''){
			if(filters == 1 || filters == 2){
				filterQuery = filterQuery + " AND "+createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet);
			} else{
				filterQuery = filterQuery + createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet);
			}
			
		}
		return filterQuery;
	};*/
	
/*	$scope.createFQ = function(){
		var filters = 0;
		var filterQuery = '';

		if(createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet) != ''){
			
			filterQuery = filterQuery + createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet);
			filters++;
		}
		if(createFilterQuery("{!tag=lb}label", $scope.selectedKBFacet) != ''){
			
			
			if(filters == 1){
				filterQuery = filterQuery + " AND "+createFilterQuery("{!tag=Countries}Countries", $scope.selectedKBFacet);	
				filters++;
			} else{	
				filterQuery = filterQuery+createFilterQuery("{!tag=Countries}Countries", $scope.selectedKBFacet);
				filters++;
			}
		}
		if(createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet) != ''){
			if(filters == 1 || filters == 2){
				filterQuery = filterQuery + " AND "+createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet);
			} else{
				filterQuery = filterQuery + createFilterQuery("{!tag=tag}tag", $scope.selectedProFacet);
			}
			
		}
		return filterQuery;
	};*/
	
	$scope.clickThrough = function(linkPosition,topicTitle,docId,searchId){
		/*alert(docId);
		alert(topicTitle);*/
		//$log.info("linkPosition= "+linkPosition+" Start= "+$scope.start);
		var clickThroughPromise = solrstorage.clickThrough(linkPosition,topicTitle,docId,searchId);
		clickThroughPromise.then(function(response){
			$log(response.data);
		});
	};

	$scope.suggestion = function(){
		var firstTop = $scope.search;
		$log.info($scope.searchKeywordSuggestion);
		if($scope.searchKeywordSuggestion != undefined && $scope.searchKeywordSuggestion.length!=0){
			firstTop = $scope.searchKeywordSuggestion[0].name; 
		}
		$http.get('searchsuggestion.jsp?q='+firstTop)
	    .then(function(response){
	    	$log.info("rr"+response.data.response.docs[0].topicTitle);
	    	var i = response.data.response.docs;
	    	var t ='';
	    	var titles = [];
	    	//log
	    	for(x in i){
	    	$log.info(x);
	    	$log.info(response.data.response.docs[x].topicTitle);
	    	$scope.searchSuggestion = facetArrayToObj(response.data.response.docs[x].topicTitle);
	    	
	    	arrayUtil(titles,response.data.response.docs[x].topicTitle);
	    	t = response.data.response.docs[x].topicTitle;
	    	$scope.searchSuggestion = titles;
	    	}
	    	$log.info('lll'+$scope.searchSuggestion);
	      
	    });
	};
	
	$scope.getSuggestions = function(){
		$log.info("in get Suggestion()"+$scope.search);
		var suggestPromise = solrstorage.getSuggestion($scope.search);
		$log.info('suggestPromise'+suggestPromise);
		suggestPromise.then(function(response){
			$log.info(response);
			//$scope.searchKeywordSuggestion=facetArrayToObj(response.facet_counts.facet_fields.product_custom_suggestion);
			
			/*var term = response.suggest.mySuggester;
			for(firstKey in term);
			$log.info(firstKey);
			$log.info("suggestions for search keyword"+response.suggest.mySuggester[firstKey].suggestions);
			$scope.searchKeywordSuggestion = response.suggest.mySuggester[firstKey].suggestions;*/
			/*if($scope.searchKeywordSuggestion != undefined || $scope.searchKeywordSuggestion.length != 0){
				$http.get('searchsuggestion.jsp?q='+$scope.searchKeywordSuggestion[0].term)
			    .then(function(response){
			    	 $scope.searchSuggestion = facetArrayToObj(response.data.facet_counts.facet_fields.kbType);
			      
			    });
			}*/
		});
	};
	$scope.setSearchKeywordAndSearch = function(term){
		$scope.search = term;
		$scope.searching();
	};
	$scope.setSearchKeyword = function(term){
		$log.info("In Search Keyword method");
		$scope.search = term;
		//$scope.suggestion();
		//$scope.getSuggestions();
	};
	$scope.onkeypress = function(key){
		$log.info(key);
		$scope.focus = true;
		if(key == 13){
			if($scope.count == -1 || $scope.search==''){
				$scope.count = -1;
				$scope.searching();
				$scope.focus = false;
			}else{
				if($scope.searchSuggestion[$scope.count].name != undefined && $scope.searchSuggestion[$scope.count].val != 0){
					
					$scope.suggestionFacetSearch($scope.searchSuggestion[$scope.count].name);
					$scope.count = -1;
				}
			}
		}
		if(key == 40){
			$scope.count = $scope.count + 1;
			 if($scope.count == $scope.searchSuggestion.length)
				 $scope.count = 0;
		}
		else if(key == 38){
			$scope.count = $scope.count - 1;
			if($scope.count < 0){
				$scope.count = $scope.searchSuggestion.length - 1;
			}
		}
	};
	$scope.setCount = function(index){
		$scope.count = index;
	};
	
	$scope.validSearchFilter = function(val){ 
		return (null!= val && val.count>0) ? true : null; 
	}
	
	$scope.suggestionFacetSearch = function(facet){
		$log.info('facet name ' + facet);
		$log.info('Enter into Suggestion Facet Search');
		$scope.focus = false;
		$scope.facet = '';
		$scope.dateRange=0;
		$scope.selectedDTFacet = [];
		$scope.selectedKBFacet = [];
		$scope.selectedProFacet = [];
		if(facet != undefined || facet != ''){
			$scope.selectedKBFacet = arrayUtil($scope.selectedKBFacet, facet);
			$scope.filterQuery = aqToString();
			$scope.fetchResultForFacet($scope.filterQuery);
		}
	};
	
	
	function getParameterByName(name) {
	    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
	    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
	        results = regex.exec(location.search);
	    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
	}
});



