/**
 * 
 */

app.controller('Searchcontroller',function($scope,solrstorage,$log,$http){
	//Contains search results.
	$scope.documentList ="";
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
	$scope.loading = "loading";
	var promise = solrstorage.getData("",$scope.start,$scope.rows);
	promise.then(function(response){
		$scope.loading = "";
		$scope.documentList = response.response.docs;
		
		$scope.numFound = response.response.numFound;
		$scope.last3months = response.facet_counts.facet_queries.last3Months;
		$scope.lastYear=response.facet_counts.facet_queries.lastYear;
		$scope.highlight=response.highlighting;
		$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		console.log($scope.docTypeFacet);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
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
							
				$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
				
			
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
			
			$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
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
			
				
				$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
				
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
			$scope.filterQuery = $scope.createFQ();
			$scope.fetchResultForFacet($scope.filterQuery);
			
			
		}
	};
	
	$scope.insertKBFacet = function(facet){
		if(facet != undefined || facet != ''){
			$scope.selectedKBFacet = arrayUtil($scope.selectedKBFacet, facet);
			$scope.filterQuery = $scope.createFQ();
			$scope.fetchResultForFacet($scope.filterQuery);
			
		}
	};
	
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
			$scope.selectedDTFacet = [];
			$scope.selectedKBFacet = [];
			$scope.selectedProFacet = [];
			promise5 = solrstorage.getData($scope.search,$scope.start,$scope.rows,'',$scope.dateRange,$scope.sortOrder);
			allFacetChange = true;
			$scope.facet = '';
		}
			else{
				$scope.facet = facet;
				promise5 = solrstorage.getData($scope.search,$scope.start,$scope.rows,facet,$scope.dateRange,$scope.sortOrder);
				
			}
		promise5.then(function(response){
			$scope.documentList = response.response.docs;
			$scope.numFound = response.response.numFound;
			$scope.highlight=response.highlighting;
			$scope.last3months = response.facet_counts.facet_queries.last3Months;
			$scope.lastYear=response.facet_counts.facet_queries.lastYear;
			
			$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
			$scope.start = response.response.start;
			$scope.loading = "";
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
			
			$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
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
			
			$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
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
			
		$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
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
			
			$scope.docTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.field);
		$scope.kbTypeFacet = facetArrayToObj(response.facet_counts.facet_fields.label);
		$scope.productFacet = facetArrayToObj(response.facet_counts.facet_fields.tag);
			
			$scope.start = response.response.start;
			$scope.loading = "";
		});
	};
	$scope.createFQ = function(){
		var filters = 0;
		var filterQuery = '';
		if(createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet) != ''){
			filterQuery = filterQuery + createFilterQuery("{!ex=ge}genresNames", $scope.selectedDTFacet);
			filters++;
		}
		if(createFilterQuery("{!tag=lb}label", $scope.selectedKBFacet) != ''){
			if(filters == 1){
				filterQuery = filterQuery + " AND "+createFilterQuery("{!tag=lb}label", $scope.selectedKBFacet);
				filters++;
			} else{
				filterQuery = filterQuery+createFilterQuery("{!tag=lb}label", $scope.selectedKBFacet);
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
	};
	
	$scope.clickThrough = function(linkPosition,title,docId,searchId){
		/*alert(docId);
		alert(title);*/
		//$log.info("linkPosition= "+linkPosition+" Start= "+$scope.start);
		var clickThroughPromise = solrstorage.clickThrough(linkPosition,title,docId,searchId);
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
	    	$log.info("rr"+response.data.response.docs[0].title);
	    	var i = response.data.response.docs;
	    	var t ='';
	    	var titles = [];
	    	//log
	    	for(x in i){
	    	$log.info(x);
	    	$log.info(response.data.response.docs[x].title);
	    	$scope.searchSuggestion = facetArrayToObj(response.data.response.docs[x].title);
	    	
	    	arrayUtil(titles,response.data.response.docs[x].title);
	    	t = response.data.response.docs[x].title;
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
			$scope.filterQuery = $scope.createFQ();
			$scope.fetchResultForFacet($scope.filterQuery);
		}
	};
	
	
	
});



