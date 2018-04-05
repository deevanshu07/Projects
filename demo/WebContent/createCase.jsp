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
<script src="js/controller/caseController.js"></script>
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
	function validateInput(){
		return "www.google.com";
	}
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

			</div>
		</header>
		<div class="content_container" data-ng-controller="casecontroller">
				<div class="right_left_panel ">
					<div class="right_panel panelslide_right" id="right_panel_slide">
						<div class="content_header_panel">
							<div class="create_text">
								<p class="search_results">Submit Consumer Support Case</p>
								<div class="im-page-subtitle">Step 1: Enter Brief Problem Description</div>
								<div class="im-table">
								
								<table class="cCase" border="0" cellpadding="0" cellspacing="0" width="100%">
								  <thead>
									<tr>
									  <th colspan="2" class="im-first im-last">Enter Problem Summary </th>
									</tr>
								  </thead>
								  <tbody>
									<tr>
									  <td class="im-label im-first width-20">(<span class="im-required">*</span> required field) </td>
									  <td class="im-last width-70">&nbsp;</td>
									</tr>
									<tr>
									   <td class="im-label im-first width-20-vtop"> Problem Summary<span class="im-required">*</span> </td>
									  <td class="im-last width-70"><textarea rows="8" cols="40" data-ng-model="caseTitle"
										  name="caseTitle" id="caseTitle" class="xmleditfield" required="required"></textarea>
							
										<br>Enter a brief problem summary, you will be able to enter additional details later.</td>
									</tr>
									<tr>
									  <td colspan="2" class="text-align-padding-border-background1">
									  <button class="button-feature" type="submit"  data-ng-click="view()">Next »</button>
									    <button type="reset" class="button-feature">Cancel</button>
									 </td>
									</tr>
								  </tbody>
								</table>
								
								</div>
							</div>
							
						</div>
					</div>	
				</div>		
			


		</div>


	
	
	
	
	
	
	

</body>
</html>
