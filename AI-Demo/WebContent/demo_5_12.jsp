<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Infogain Support</title>
<link href="css/roboto.css"	rel="stylesheet">
<link
	href="css/jquery-ui.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css"
	href="font-awesome-4.7.0/css/font-awesome.css">

<script
	src="js/jquery.min.js"></script>
<script src="js/68d3820c49.js"></script>
<script src="js/jquery-ui.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/angular.min.js"></script>
<script src="js/angular-route.js"></script>
<script src="js/app.js"></script>
<script src="js/util/function.js"></script>
<script src="js/filter/filters.js"></script>
<script src="js/services/webservice.js"></script>
<script src="js/controller/Searchcontroller.js"></script>

<script>
$( window ).load(function() { $(".footer_area").delay("8000").fadeIn();})

	$(document).ready(function() {
		$("#filter").click(function() {
			$("#slider").toggleClass("panelslide fadeInRight");
			$("#acc-header-2 i").removeClass("fa-angle-down");
		});
		
		$(".accord input").click(function(){
		    $(".footer_area").delay("80000000").fadeIn();
		});
		

		$("#acc-header-1").click(function() {
			$("#acc-header-2 i").removeClass("fa-angle-down");
			$("#acc-header-3 i").removeClass("fa-angle-down");
			$("#acc-header-4 i").removeClass("fa-angle-down");

			$(".p-hide").addClass("p-open");
			$(".p-hide2, .p-hide3 ,.p-hide4 ").removeClass("p-open");
		});

		$("#acc-header-2").click(function() {
			$("#acc-header-2 i").addClass("fa-angle-down");
			$("#acc-header-3 i").removeClass("fa-angle-down");
			$("#acc-header-4 i").removeClass("fa-angle-down");
			$(".p-hide2").addClass("p-open");
			$(".p-hide, .p-hide3").removeClass("p-open");
		});

		$("#acc-header-3").click(function() {
			$("#acc-header-3 i").addClass("fa-angle-down");
			$("#acc-header-2 i").removeClass("fa-angle-down");
			$(".p-hide3").addClass("p-open");
			$(".p-hide2, .p-hide ").removeClass("p-open");
		});
		
		$("#acc-header-4").click(function() {
			$("#acc-header-4 i").addClass("fa-angle-down");
			$("#acc-header-3 i").removeClass("fa-angle-down");
			$(".p-hide4").addClass("p-open");
			$(".p-hide2, .p-hide ").removeClass("p-open");
		});

		

		$("#filter").click(function() {
			$("#right_panel_slide").toggleClass("panelslide_right trans");
		});

		$("#normal_view").click(function() {
			$("#normal_view").addClass("active");
			$(".right_panel_box p").addClass("fadeInUp");
			$(".right_panel_box h2").addClass("fadeInUp");
			$("#grid_view_btn").removeClass("active");
			$(".right_panel_box").removeClass("grid_view zoomIn");

		});

		$(document).ready(function() {
			$(".right_panel_box p").addClass("fadeInUp");
			$(".right_panel_box h2").addClass("fadeInUp");
		});

		$("#grid_view_btn").click(function() {
			$(".right_panel_box p").removeClass("fadeInUp");
			$(".right_panel_box h2").removeClass("fadeInUp");
			$(".right_panel_box").addClass("grid_view zoomIn");
			$("#grid_view_btn").addClass("active");
			$("#normal_view").removeClass("active zoomIn");

		});

		$('.all_input').bind('click', function() {
			if ($('input[type=checkbox]').attr('checked')) {
				$('input[type=checkbox').removeAttr('checked');
			} else {
				$('input[type=checkbox').attr('checked', 'checked');
			}
		});

		$('.first_input').bind('click', function() {
			if ($('.first_child_input').attr('checked')) {
				$('.first_child_input').removeAttr('checked');
			} else {
				$('.first_child_input').attr('checked', 'checked');
			}
		});

		$('.secound_input').bind('click', function() {
			if ($('.secound_child_input').attr('checked')) {
				$('.secound_child_input').removeAttr('checked');
			} else {
				$('.secound_child_input').attr('checked', 'checked');
			}
		});
		$('.third_input').bind('click', function() {
			if ($('.third_child_input').attr('checked')) {
				$('.third_child_input').removeAttr('checked');
			} else {
				$('.third_child_input').attr('checked', 'checked');
			}
		});
		
		$('#mp').bind('click', function() {
			$("#mp").toggleClass("active");
			$("#mr").removeClass("active");
		});
		$('#mr').bind('click', function() {
			$("#mr").toggleClass("active");
			$("#mp").removeClass("active");
		});
	});
</script>
</head>

<body data-ng-app="solr" data-ng-controller="Searchcontroller">
	<div class="Main_Support_panel">
		<header>
			<div class="header_content">
				<div class="logo">
					
					<span >&nbsp; </span>	
				</div>
				

				
			</div>
			
			<div class="content_top_area">
				<div class="filter_area filter_partition_area">
					<a id="filter" class="filter-btn"><i class="fa fa-filter"
						aria-hidden="true"></i></a>
						<div class="merge_area">
						<!--  <input type="text" size="16"  placeholder="Search"/> --> 
						<input type="text" class="form-control" id="usr" data-ng-model="search" data-ng-keyup="onkeypress($event.keyCode) || suggestion()  || getSuggestions()"
	      			data-ng-focus="focus = true" data-ng-blur="count=-1" placeholder="Search">
						<!--  
						<select>
							<option value="volvo">All Categories</option>
							<option value="saab">Saab</option>
							<option value="mercedes">Mercedes</option>
							<option value="audi">Audi</option>
						</select>
						
						-->
						<button type="button" class="search_btn  btn-cust-style btn-primary"  data-ng-click="searching()">
							<span class="glyphicon glyphicon-search fa fa-search" ></span>
						</button>					
						</span>
						<div class="search-sug" data-ng-show="search != '' && focus == true">
			    			<div data-ng-repeat="facet in searchSuggestion"  data-ng-show="facet.val !=0" data-ng-class="{'back-cust': $index == count}"  data-ng-mouseleave="setCount(-1)" data-ng-click="setSearchKeyword(facet)" >
			    			<span style="padding-left:5px;font-size:16px;">
			    			<span data-ng-class=" facet.val != 0 ? 'cust-color-blue' : 'cust-color-gray'">{{facet}}</span>
			    			<span class="pull-right" data-ng-show="$index == 0" style="font-size:12px;padding-right:5px;font-weight:400">search suggestion</span></span></div>
			    			<!-- <div style="margin-bottom:-15px;"></div> -->
			    			
			    		<!-- 	<div style="margin-top:-15px;"></div> -->
			    		<!-- 	<div data-ng-repeat="searchKeywords in searchKeywordSuggestion|limitTo:5" data-ng-click="setSearchKeyword(searchKeywords.name)"><span style="padding-left:5px;font-weight:400;color:gray;font-size:16px;" data-ng-bind-html="searchKeywords.name | highlightPartOfText:search"></span></div> -->
			    			<!-- <div style="margin-bottom:5px;"></div> -->
			    		</div>
						
						
					</div>
				</div>
		<!--  		<div class="filter_partition_areaN">
					<div class="merge_area">
						  <input type="text" size="16"  placeholder="Search"/>
						<input type="text" class="form-control" id="usr" data-ng-model="search" data-ng-keyup="onkeypress($event.keyCode) || suggestion()  || getSuggestions()"
	      			data-ng-focus="focus = true" data-ng-blur="count=-1" placeholder="Search">
						<!--  
						<select>
							<option value="volvo">All Categories</option>
							<option value="saab">Saab</option>
							<option value="mercedes">Mercedes</option>
							<option value="audi">Audi</option>
						</select>
						
						
						<button type="button" class="search_btn  btn-cust-style btn-primary"  data-ng-click="searching()">
							<span class="glyphicon glyphicon-search fa fa-search" ></span>
						</button>
						
						</span>
						<div class="search-sug" data-ng-show="search != '' && focus == true">
			    			<div data-ng-repeat="facet in searchSuggestion"  data-ng-show="facet.val !=0" data-ng-class="{'back-cust': $index == count}"  data-ng-mouseleave="setCount(-1)" data-ng-click="setSearchKeyword(facet)"><span style="padding-left:5px;font-size:16px;"><span data-ng-class=" facet.val != 0 ? 'cust-color-blue' : 'cust-color-gray'">{{facet}}</span><span class="pull-right" data-ng-show="$index == 0" style="font-size:12px;padding-right:5px;font-weight:400">search suggestion</span></span></div>
			    			<div style="margin-bottom:-15px;"></div>
			    			<hr/>
			    			<div style="margin-top:-15px;"></div>
			    			<div data-ng-repeat="searchKeywords in searchKeywordSuggestion|limitTo:5" data-ng-click="setSearchKeyword(searchKeywords.name)"><span style="padding-left:5px;font-weight:400;color:gray;font-size:16px;" data-ng-bind-html="searchKeywords.name | highlightPartOfText:search"></span></div>
			    			<div style="margin-bottom:5px;"></div>
			    		</div>
					</div> -->
				</div>

			</div>
		</header>
		<div class="content_container">


			<div class="right_left_panel ">
				<div class="left_panel fadeInLeft panelslide" id="slider" style="overflow:auto;">

					<div class="acc-toggle">
						<div>
							<!--   <h3 id="acc-header-1"><input type="checkbox" class="all_input" id="test1" name="level-11" /> 
<label for="test1">All</label></h3> -->

							<h3 id="acc-header-1" class="accord">
								<input type="checkbox" class="all_input" value="" name="level-1" id="test1" data-ng-click="fetchResultForFacet('')" data-ng-checked="facet == ''">
								<label for="test1">All Sources</label>
								<!--  <span class="pull-right">({{kbTypeFacet|totalDocument}})</span> -->
								
								<!--  
									<input type="checkbox" class="all_input" name="level-1" id="test1" /><label for="test1">All</label> 
									<span class="pull-right">({{kbTypeFacet|totalDocument}})</span>
								-->
							</h3>
						</div>
						<div>
							<h3 id="acc-header-2" class="accord">
								<input class="first_input" type="checkbox" name="level-1"
									id="test2" /> <label for="test2">Label</label> <i
									class="fa fa-angle-right " aria-hidden="true"></i>
							</h3>
							<ul class="p-hide2 accord">
								<label class="labelStyle" data-ng-repeat="facet in kbTypeFacet" data-ng-show="facet.val != 0">
								<li><input type="checkbox" id="{{facet.name}}" value="" data-ng-click="insertKBFacet(facet.name)" data-ng-checked="facet.name|isFacetChecked:selectedKBFacet">
								<label for="{{facet.name}}"></label><span>{{facet.name}} ({{facet.val}})</span>
								</li>
								</label>
							</ul>
						</div>
						<div>
							<h3 id="acc-header-3" class="accord">
								<input class="secound_input" type="checkbox" name="level-3"
									id="test3" /> <label for="test3">Forum</label><i
									class="fa  fa-angle-right " aria-hidden="true"></i>
							</h3>
							<ul class="p-hide3 accord">
								<label class="labelStyle" data-ng-repeat="facet1 in docTypeFacet" data-ng-show="facet1.val != 0">
									<li><input type="checkbox" id="{{facet1.name}}" value="" data-ng-click="insertDTFacet(facet1.name)" data-ng-checked="facet1.name|isFacetChecked:selectedDTFacet">
									<label for="{{facet1.name}}"></label><span>{{facet1.name}} ({{facet1.val}})</span>
									</li>
								</label>
								
							</ul>
						</div>
						<div>
							<h3 id="acc-header-4" class="accord">
								<input class="third_input" type="checkbox" name="level-4"
									id="test4" /> <label for="test4">Tags</label><i
									class="fa  fa-angle-right " aria-hidden="true"></i>
							</h3>
							<ul class="p-hide4 accord">
								<label class="labelStyle" data-ng-repeat="facet2 in productFacet" data-ng-show="facet2.val != 0">
									<li><input type="checkbox" id="{{facet2.name}}" value="" data-ng-click="insertProFacet(facet2.name)" data-ng-checked="facet2.name|isFacetChecked:selectedProFacet">
									<label for="{{facet2.name}}"></label><span>{{facet2.name}} ({{facet2.val}})</span>
									</li>
								</label>
								
							</ul>
						</div>
					</div>

				</div>
				<div class="right_panel panelslide_right" id="right_panel_slide">
					<div class="right_panel_top">
						<div class="page-breadcrumbs">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Search - Windows</li>
							</ol>
						</div>
						<div class="content_header_panel">
							<div class="search_text">
								<p class="search_results">{{msg}}</p>
								<p>About {{numFound}} Records</p>
								<p class="didM"><span data-ng-show="numFound == 0 && !correctlySpelled" style="font-size:16px;color:#636c72;">Did You mean <span class="spellcheck-word-style" data-ng-click="setSearchKeywordAndSearch(suggestedWord)">{{suggestedWord}}</span></span></p>
							</div>
							
						</div>
					
						
					<div class="content_header_panel_right">
							<div class="galery_change_icon">
								<span><i id="normal_view" class="fa fa-list "
									aria-hidden="true"></i></span>  <span id="grid_view_btn" class="colage active"><i
									class="fa fa-ellipsis-v" aria-hidden="true"></i><i
									class="fa fa-ellipsis-v" aria-hidden="true"></i><i
									class="fa fa-ellipsis-v" aria-hidden="true"></i></span>
							</div>
							<div class="sort_area">
								<span>Sort By</span>
								<ul>
									<li id="mp"><a href="#" data-ng-model="sortOrder" data-ng-click="sortingNew('kudosCount_desc')" >With ML</a></li>
									<li id="mr"><a href="#" data-ng-model="sortOrder" data-ng-click="sortingNew('score_desc')">Without ML</a></li>
								</ul>
							</div>

						</div>
					</div>
					<div class="panel_area">
						
						<div class="right_panel_box grid_view zoomIn {{doc.cssClass}}" data-ng-repeat="doc in documentList">
						<span class="box-date">Updated on {{doc.last_edit_time | date: 'yyyy-MM-dd' }} </span>
							<a href="articleDetail.jsp?id={{doc.id}}" data-ng-if="!(doc.id | isUrl)"
								target="_blank" style="text-decoration: none"><h2
									class="window_heading"
									data-ng-bind-html="highlight | extractTitle:doc.id:doc.topicTitle"
									data-ng-click="clickThrough($index+1+start,doc.topicTitle,doc.id,101)"></h2></a>
							<p class="meta">
								<span class="_mb" ng-show='{{doc["[elevated]"]}}'> Ad</span> <!-- <b>Forum:</b>
								<span  data-ng-repeat ="x in doc.label">{{x}}{{$last ? '' : ', '}}</span> | --> <b>Kudos:</b> {{doc.kudosCount}} |
								<span class="_mb" ng-show='{{doc["[elevated]"]}}'> Ad</span> <b>Views:</b> {{doc.viewsCount}}
							</p>
							
							
						</div>



						<!-- 
<div class="right_panel_box" >
<span class="box-date">Updated on 2017-01-11</span>
<h2 class="window_heading">Windows window</h2>
<p>You can use the <strong>Windows window</strong> to maintain a list to <strong>local windows users</strong> and groups for each You can use the <strong>local Window</strong>. You can use the Windows window to maintain a list to local windows users and groups for each You can use the <strong>local Window</strong>......</p>
<p class="secound_heading">ONTAP* 9.0 Cluster Management Using OnCommand* System Manager</p>
<ul>
<li><img src="images/adobe.PNG"></li>
<li><img src="images/embaded.PNG"></li>
<li><img src="images/excel.PNG"></li>
<li><img src="images/popup.PNG"></li>
</ul>
<p>Applicable Products are <span>ONTAP 9</span></p>
<p><span>Administration Guide in <span>Product Documentation</span></p>
</div>
 -->


					</div>
					
					<div class="row" data-ng-show="numFound != 0 && numFound > rows"">
						<p>&nbsp;&nbsp;</p>
								<!-- <div>
								<ul class="pagination" >
								    <li  data-ng-class="{'disabled': range == 1}" data-ng-show="range != 1">
								      <a class="pagerStyle" data-aria-label="Previous" data-ng-click="range = range - 10">
								        <span data-aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <li data-ng-repeat="n in [] | range:range:numFound:rows" data-ng-class="{'active': (n-1) == start/rows}"><a class="pagerStyle" data-ng-click="pagination(n)">{{n}}</a></li>
								    <li  data-ng-class="{'disabled': (range+9)*rows >= numFound}" data-ng-hide="(range+9)*rows >= numFound">
								      <a  class="pagerStyle" data-aria-label="Next" data-ng-click="range = range + 10">
								        <span data-aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							   </ul>
							   <div class="pull-right right_nav" data-ng-show="numFound != 0">
									<div class="margin-top: 15px;">
								    
								      <div style="margin-top:12px">
								      <label for="sel1" class="sel1">Result Per Page :</label>
								      <select class="form-control" id="sel1" class="sel1" data-ng-model="rows" data-ng-change="resultPerPage()">
								        <option value="10" data-ng-selected="rows == 10">10</option>
								        <option value="25" data-ng-selected="rows == 25">25</option>
								        <option value="50" data-ng-selected="rows == 50">50</option>
								        <option value="100" data-ng-selected="rows == 100">100</option>
								      </select>
								      </div>
									</div>
								</div>
							   
							   </div> -->
								<!-- <ul class="pagination pull-right">
			  					    <li data-ng-class="{'active': rows == 10}"><a class="pagerStyle" data-ng-click="resultPerPage(10)">10</a></li>
								    <li data-ng-class="{'active': rows == 20}"><a class="pagerStyle" data-ng-click="resultPerPage(20)">20</a></li>
								    <li data-ng-class="{'active': rows == 30}"><a class="pagerStyle" data-ng-click="resultPerPage(30)">30</a></li> 
			  					</ul> -->
			  					
			  					<ul class="pagination" >
								    <li  data-ng-class="{'disabled': range == 1}" data-ng-show="range != 1">
								      <a class="pagerStyle" data-aria-label="Previous" data-ng-click="range = range - 10">
								        <span data-aria-hidden="true">&laquo;</span>
								      </a>
								    </li>
								    <li data-ng-repeat="n in [] | range:range:numFound:rows" data-ng-class="{'active': (n-1) == start/rows}"><a class="pagerStyle" data-ng-click="pagination(n)">{{n}}</a></li>
								    <li  data-ng-class="{'disabled': (range+9)*rows >= numFound}" data-ng-hide="(range+9)*rows >= numFound">
								      <a  class="pagerStyle" data-aria-label="Next" data-ng-click="range = range + 10">
								        <span data-aria-hidden="true">&raquo;</span>
								      </a>
								    </li>
							   </ul>
			  					
			  					<div class="pull-right right_nav" data-ng-show="numFound != 0">
									<div style="margin-top: 15px;">
								    
								      <div style="margin-top:10px">
								      <label for="sel1" class="sel1">Result Per Page :</label>
								      <select class="form-control" id="sel1" class="sel1" data-ng-model="rows" data-ng-change="resultPerPage()">
								        <option value="10" data-ng-selected="rows == 10">10</option>
								        <option value="25" data-ng-selected="rows == 25">25</option>
								        <option value="50" data-ng-selected="rows == 50">50</option>
								        <option value="100" data-ng-selected="rows == 100">100</option>
								      </select>
								      </div>
									</div>
								</div>
  					
						</div>
					
					
				</div>

			</div>


		</div>
		
		
		<footer class="footer_area">
		<div class="navigation_footer">
			<div align="center">
				<span> Copyright © Infogain  </span>
			</div>

		</div>
	</footer>

	
	
	
	
	
	
	

</body>
</html>
