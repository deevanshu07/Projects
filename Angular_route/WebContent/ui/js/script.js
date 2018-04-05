
var aiDemo = angular.module('aiDemo', [ 'ngRoute', 'ui.bootstrap','ngSanitize' ]);


aiDemo.config(function($routeProvider) {
	$routeProvider

		// route for the home page
		.when('/', {
			templateUrl : 'pages/home.html',
			controller  : 'ctrlSolrResults'
		})

		.when('/about', {
			templateUrl : 'pages/contentDetail.html',
			controller  : 'contactController'
		});
});


aiDemo.controller('ctrlSolrResults', function($scope, $http, $sce,$rootScope) {
	$scope.caseFormDisplay = false;
	$scope.searchURL = '/AI-Demo/jsps/searchWrapper.jsp';
	$scope.recURL = '/AI-Demo/jsps/recWrapper.jsp';
	$scope.recCaro = { interval: 5000, wrap: false };
	// options related to typeahead
	$scope.modelOptions = {
		debounce: {	default: 500, blur: 250 }
	};
	$scope.pageBack = 'landing';
	// guid generator to be used for creating a searchID for each search session
	$scope.guidGen = function() {
		var strOut = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
			var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
			return v.toString(16);
		});
		return strOut;
	};
	// this is a generic set of preferences and params used in SOLR requests
	$scope.config = {
		jsonpCallbackParam: 'JSON_CALLBACK',
		headers: { },
		// standard query params
		params: { q: '', start: 0, count: 10, sortField: 'score', filterQuery: '', searchId: $scope.guidGen(), callback: 'JSON_CALLBACK', sortBy: 'desc', ml: true },
		pref : { pageLayout: 'normal', container: 'container-fluid', fontSize: 1.3, docId: '', user: '1', filters: { display: false, type: 'left' } }
	};
	// stores selected filters
	$scope.aq = [];
	$scope.details = { response: { numfound:0 } };

	// not currently in use, for a future feature
	/*
	$scope.layouts = {
		left: { filterColumn: 'col-xs-12 col-sm-4 col-md-3 hidden-xs', resultsColumn: 'col-xs-12 col-sm-8 col-md-9', tileColumns: 2},
		filterBar: { filterColumn: 'hidden', resultsColumn: 'col-xs-12', tileColumns: 3},
		none: { filterColumn: 'hidden', resultsColumn: 'col-xs-12', tileColumns: 3}
	};
	*/
	$scope.detailColsDefault = {col1:'col-sm-4 col-md-3 hidden-xs',col2:'col-xs-12 col-sm-8 col-md-9'};
	$scope.detailColsOneResult = {col1:'hidden',col2:'col-xs-12'};
	$scope.detailCols = angular.copy($scope.detailColsDefault);

	$scope.filterCollapsed=[true,true,true,true,true];
	prefLoad();		
	$scope.$watch('config.params', function() { fetch(); }, true); // perform a search when some aspect of the search model changes
	$scope.$watch('config', function() { prefSave(); }, true); // save preferences when some aspect of preference changes, as these are both in what goes to the search api and purely UI elements, we are observing the entire config model
	
	// pagination related variables and functions
	$scope.total = 0; // default the number of results to 0
	$scope.pagination = { currentPage:  1 }; // default the page we are on to 1
	// function to alter the page we are on when the user clicks one of the pagination buttons
	$scope.pageChanged = function() {
		$scope.config.params.start = ($scope.pagination.currentPage==1) ? 0 : ($scope.pagination.currentPage-1)*$scope.config.params.count;
	};
	// what is the highest result number on the page
	$scope.pageMax = function() {
		return ((($scope.pagination.currentPage*$scope.config.params.count))>$scope.total) ? $scope.total : ($scope.pagination.currentPage*$scope.config.params.count);
	};
	
	
	$scope.formatDate = function(date){
		return (Object.prototype.toString.call(new Date(date)) === "[object Date]") ? new Date(date) : new Date(date.split("-").join("/"));
	};
	
	//Applying background images Dynamically
	var backgroundImageList=['loginbg.jpg'];
	var applyImage=backgroundImageList[Math.floor(Math.random() * backgroundImageList.length)];
	$rootScope.setBackground=function(){
		return{
			'background-image':'url(images/'+applyImage+')'
		}
	};
	
	
	function prefLoad() {
		//console.log($scope.layouts['left']);
		var strSrchPrefCookie = getCookie('srchPref');
		if (null!=strSrchPrefCookie && strSrchPrefCookie.length>0) {
			$scope.config = JSON.parse(strSrchPrefCookie);
			$scope.config.params.searchId = $scope.guidGen();
			//console.log(strSrchPrefCookie);
		}	
	}
	function prefSave() {
		if ($scope.config) {
			// don't save the question or filter
			var objPref = angular.copy($scope.config);
			objPref.params.q='';
			objPref.params.filterQuery='';
			objPref.pref.docId='';
			objPref.params.searchId='';
			setCookie('srchPref',JSON.stringify(objPref),7);
		}
	}
	$scope.caseFormInit = function() { 
		if ($scope.details && $scope.details.facet_counts && $scope.details.facet_counts.facet_fields) $scope.filterFields = angular.copy($scope.details.facet_counts.facet_fields);
		$scope.caseFormDisplay = true;
	};
	$scope.caseFormDestroy = function() { 
		$scope.caseFormDisplay = false;
		//console.log($scope.caseFormDisplay);
	};
	function fetch() {
		if ($scope.config.params && $scope.config.params.q.length>0) {
			$scope.pageBack = '';
			if ($scope.config.params.start===0) $scope.pagination.currentPage = 1;
			$http.jsonp($scope.searchURL,$scope.config)
				.then(function(response) {
					if ($scope.detail) $scope.detail = null;
					$scope.total = response.data.response.numFound;
					$scope.details = response.data;
					
					console.log($scope.details.facet_counts.facet_fields);
					
					// if there is only one response, let's jump directly to it
					if (response.data.response.numFound===1)  {
						$scope.detailCols = angular.copy($scope.detailColsOneResult);
						$scope.detail = response.data.response.docs[0];
						fetchRec(response.data.response.docs[0].id);
					} else {
						$scope.detailCols = angular.copy($scope.detailColsDefault);
					}
				});
		}
	}
	fetchRec(''); // retreive user recommendations when page is first loaded
	function fetchRec(itemId) {
		$scope.recs = null;
		var confRec = { params: { callback: 'JSON_CALLBACK' } };
		if (null==itemId || ''==itemId) {
			confRec.params.userId = $scope.config.pref.user; 
		} else {
			confRec.params.itemId = itemId;
		}
		$http.jsonp($scope.recURL,confRec)
			.then(function(response) {
				var ids = '';
				for(var i=0;i<response.data.length;i++) {
					ids += 'id:'+ ((response.data[i].itemId) ? response.data[i].itemId : response.data[i].recItemId) +' or ';
				}
				if (ids.length>0) {
					
					ids = ids.substring(0,ids.length-4);
					var confDocs = { params: { recs: ids, callback: 'JSON_CALLBACK' } };
					$http.jsonp($scope.searchURL,confDocs)
						.then(function(response) {
							$scope.recs = response.data;
							console.log('hhhhh');
							console.log($scope.recs);
						});
				} 
			});
		
	}
	$scope.fetchDetail = function(id){
		if (null!=id) {
			$scope.config.pref.docId = id;
			$scope.rsltsStart = (id-2>-1) ? id-2 : 0;
			$scope.rsltsEnd = $scope.rsltsStart+5;
			$scope.detail = $scope.details.response.docs[id];
			fetchRec($scope.detail.id);

			// track this clickthrough
			var clickConfig = { 
				params: { linkPosition: id, title: $scope.detail.title, docId: $scope.detail.id, searchId: $scope.config.params.searchId}
			};
			
			$http.get('/AI/jsps/clickthrough.jsp',clickConfig)
				.then(function(response) {
					//console.log(response.data);
				});
		} 
	};
	$scope.fetchDetailRemote = function(id){
		if (null!=id) {
			fetchRec(id);
			var conf = { params: { id: id, callback: 'JSON_CALLBACK', searchId: $scope.config.params.searchId } };
			$http.jsonp($scope.searchURL,conf)
				.then(function(response) {
					$scope.detail = response.data.response.docs[0];
				});			
		} 
	};
	$scope.detailClear = function(){ $scope.detail=''; $scope.config.pref.docId=''; $scope.recs=null; };
	$scope.setParam = function(param,val) {
		$scope.config.params.start=0;
		$scope.currentPage = 0;
		if(param=='pageLayout') {
			$scope.config.pref.pageLayout = val;
		} else if(param=='sortField') {
			$scope.config.params.sortField = val;
		} else if(param=='count') {
			$scope.config.params.count = val;
		} else if(param=='container') {
			$scope.config.pref.container = val;
		} else if(param=='user') {
			$scope.config.pref.user = val;
		} else if(param=='ml') {
			$scope.config.params.ml = val;
		}
	};
	$scope.toggleAQ = function(param,val) {
		$scope.config.params.start=0;
		if (!$scope.aq[param]) $scope.aq[param]=[]; 

		if ($scope.aq[param].indexOf(val)>-1) {
			var numValLoc = $scope.aq[param].indexOf(val);
			$scope.aq[param].splice(numValLoc,1);
		} else {
			$scope.aq[param].splice($scope.aq[param],0,val);
		}
		$scope.config.params.filterQuery = aqToString();
	};
	function aqToString() {
		//{!tag=doc}docType:("FAQ") AND {!tag=kb}kbType:("Knowledge Base" OR "YouTube")
		var strOut = '';
		if (fnObjSize($scope.aq)>0) {
			var key;
			for (key in $scope.aq) {
				if ($scope.aq[key].length>0) {
					var strChildren = '';
					for (var kid in $scope.aq[key]) strChildren += '"' + $scope.aq[key][kid] + '" OR ';
					strOut += '{!tag=' + key.replace('Type','') + '}' + key+ ':(' + strChildren.slice(0,-4) + ')';
				}
				strOut += ' AND ';
			}
			strOut = strOut.slice(0,-4);
		} 
		return strOut;
	}
	$scope.resultIndex = function(val) {
		var indexArray = $scope.details.response.docs.map(function(o){return o.id;});
		var resultIndex = indexArray.indexOf(val);
		return resultIndex;
	};
	$scope.select = function() {
		this.setSelectionRange(0, this.value.length);
	}
	$scope.validSearchFilter = function(val){ 
		return (null!= val && val.count>0) ? true : null; 
	}
	$scope.fetchSuggestion = function(val) {
		return $http.jsonp($scope.searchURL, {
			params: {q: val+'*', callback: 'JSON_CALLBACK'}
		}).then(function(data){
			return data.data.response.docs.map(function(item){
				return item.title;
			});
		});
	};
	$scope.trustSrc = function(src) {
		if (src.indexOf('youtube')>0) src = src.replace('watch?v=','embed/');
		return $sce.trustAsResourceUrl(src);
	};
	$scope.movieStars = function(num) {
		var stars = '';
		var numStarsRemaining = 5;
		var numWholeStars = Math.round(num/2);
		var binHalfStar = ((Math.round((num/2)*10)/10) % 1)>4;
		for (var i=0;i<numWholeStars;i++) { stars += '<i class="fa fa-star"></i>'; numStarsRemaining--; }
		if (binHalfStar) { stars += '<i class="fa fa-star-half-o"></i>'; numStarsRemaining--; }
		for (var i=0;i<numStarsRemaining;i++) stars += '<i class="fa fa-star-o"></i>';
		
		return stars;
	};	
	$scope.fileUpload = { loader: 'hidden', statusError: 'hidden', input: '' };
	$scope.fileUploader = function () {
		if ($scope.fileSearch) {
			$scope.fileUpload = { loader: '', statusError: 'hidden', input: 'hidden' };
			$http({
				method: 'POST',
				url: '/imagerecog/airest/services/image/upload',
				headers: {
					'Content-Type': undefined 
				},
				data: {
					file: $scope.fileSearch
				},
				transformRequest: function (data, headersGetter) {
					var formData = new FormData();
					angular.forEach(data, function (value, key) {
						formData.append(key, value);
					});
					//var headers = headersGetter();
					//delete headers['Content-Type'];
					return formData;
				}
			})
			.then(function (response) {
				$scope.fileUpload = { loader: 'hidden', statusError: 'hidden', input: '' };
				$scope.config.params.q=response.data.name;
				$('#imgUpload').modal('toggle');	
				//console.log(response);
			},function(response){
				// error
				$scope.fileUpload = { loader: 'hidden', statusError: 'error', input: '' };
			});
		}
	};
	$scope.uploadImg = function( files ) {
		$scope.fileSearch = files[0];
		$scope.fileUploader();
	};
})
.directive("rsltPanel", function() {
	return {
	
		template : '<div class="panel panel-default"><div class="panel-body"><img src="{{rslt.thumbnailImage}}" class="pull-right" style="max-width: 45px" ng-if="rslt.thumbnailImage" /><h3 class="panel-title"><a ng-click="fetchDetail(pos)">{{rslt.title}}</a></h3><rslt-meta rslt="rslt"></rslt-meta><p class="mb-1 excerpt" ng-bind-html="rslt.body.shortDescription"></p></div></div>',
		link: function (scope, element, attrs) {
			if(attrs.rslt){
				scope.rslt = scope.$eval(attrs.rslt);
			}
			if(attrs.pos){
				scope.pos = scope.$eval(attrs.pos);
			}
		}
	};
})
.directive("rsltMeta", function() {
	return {
		templateUrl : 'rsltMeta.htm',
		link: function (scope, element, attrs) {
			if(attrs.rslt) {
				// put entire result into this directive's scope
				scope.rslt = scope.$eval(attrs.rslt);
				//scope.num = Math.round((scope.rslt.vote_average/2)*10)/10;
				//scope.stars = scope.movieStars(scope.rslt.vote_average);
			}
		}
	};
})
.directive("rsltMovie", function() {
	return {
		templateUrl : 'rsltMovie.htm',
		link: function (scope, element, attrs) {
			if(attrs.rslt) 
				scope.rslt = scope.$eval(attrs.rslt);
		}
	};
})
.directive("rsltExcerpt", function() {
	return {
		template : '<p ng-bind-html="rslt.body.shortDescription"></p>',
		link: function (scope, element, attrs) {
			if(attrs.rslt) scope.rslt = scope.$eval(attrs.rslt);
			/*
			if(attrs.highlight && attrs.highlight.length>0) {
				var tmpObj = scope.$eval(attrs.highlight);
				if (tmpObj[scope.rslt.id] && tmpObj[scope.rslt.id].content) scope.rslt.excerpt = tmpObj[scope.rslt.id].content;
			}
			*/
		}
	};
});
// cookie methods to power the storing and reading of preferences
function setCookie(cname,cvalue,exdays) {
	let d = new Date();
	d.setTime(d.getTime() + (exdays*24*60*60*1000));
	let expires = "expires=" + d.toString();
	document.cookie = cname+"="+cvalue+"; "+expires;
}

function getCookie(cname) {
	let name = cname + "=";
	let ca = document.cookie.split(';');
	for(let i=0; i<ca.length; i++) {
		let c = ca[i];
		while (c.charAt(0)==' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}
function fnObjSize(obj) { var size = 0, key; for (key in obj) { if (obj.hasOwnProperty(key)) size++; } return size; }

$(function() {

	$(".search-settings").click(function() {
		//alert("sdf");
		$(this).find(".searchsettings-popup").on("click", function(e) {
			e.stopPropagation();
		})
		if (!$(this).find(".searchsettings-popup").is(":visible")) {
			$(this).find(".searchsettings-popup").fadeIn(100);
			$(this).find(".searchsettings-popup").animate({
				"top" : "65px"
			}, 350);
		} else {
			$(this).find(".searchsettings-popup").animate({
				"top" : "90px"
			}, 350);
			$(this).find(".searchsettings-popup").fadeOut(200);

		}

	});

	$(".mltogglebtn").click(function() {
		if ($(this).hasClass("disabled")) {
			$(this).removeClass("disabled").addClass("enabled");
		} else {
			$(this).removeClass("enabled").addClass("disabled");
		}
	})

	$.fn.switchactive = function(e) {
		//alert("hihihi");
		var def = {
			activeclass : 'active',
			inactiveclass : 'inactive',

		};
		var obj = $.extend(def, e);

		var thiss = $(this);
		thiss.addClass("switchactive");
		$(this).find("button").addClass("" + obj.inactiveclass + "")
		$(this).find("button").on(
				"click",
				function() {
					thiss.find("button").removeClass(
							"" + obj.activeclass + "").addClass(
							"" + obj.inactiveclass + "");
					if ($(this).hasClass("" + obj.inactiveclass + "")) {
						//alert(1);

						$(this)
								.removeClass(
										"" + obj.inactiveclass + "")
								.addClass("" + obj.activeclass + "")

					} else {
						//alert(2);
						$(this).removeClass("" + obj.activeclass + "")
								.addClass("" + obj.inactiveclass + "")
					}

				});

	}

	$(".sortby_inner").switchactive();

});
			