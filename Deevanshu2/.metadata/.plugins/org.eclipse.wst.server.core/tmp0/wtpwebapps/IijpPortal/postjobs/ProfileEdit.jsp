<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>


<title>Insert title here</title>
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7; IE=EmulateIE9">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
 <link rel="shortcut icon" href=http://www.freshdesignweb.com/wp-content/themes/fv28/images/icon.ico />
    <link rel="stylesheet" type="text/css" href="style.css" media="all" />
     <link rel="stylesheet" type="text/css" href="register.css" media="all" />
    <link rel="stylesheet" type="text/css" href="fdw-demo.css" media="all" />
</head>
<body bgcolor="black">

<header>
		<div id="sash-container" >
			<div class="hide-sash-top" ></div>
			<div class="hide-sash-left"></div>
			<!-- <div class="sash-shadow-top"></div>
			<div class="sash-shadow-left"></div>
			<div class="hide-sash-shadow-top"></div>
			<div class="hide-sash-shadow-left"></div> -->
			<div id="sash">
				<p>INFOGAIN<strong></strong></p>
			</div>
		</div>
    	</header>
    		<h1><font color="lightgrey">EDIT YOUR PROFILE..</font></h1>
			<!-- <div id="progress">"Progress" element is not yet recognized by Webkit browsers, div used.
				<div id="progress-indicator-container">
					<div id="progress-indicator">
						<div id="progress-canvas"></div>
					</div>
				</div>
				
			</div> -->
    	
	
	
	<div class="container">
     <!--  <div class="freshdesignweb-top"><h3>Start filling out the form</h3></div><div class="clr"></div> --> 
      <br><br> 
      <div  class="form">
    		<form id="contactform" action="../EditProfileservlet"> 
    			<p class="contact"><label for="position">Update Skills</label></p> 
    			<input id="name" name="eskills" placeholder="Skills" type="text" required > 
    			 
    			<p class="contact"><label for="department">Add more projects</label></p> 
    			<input id="email" name="eprojects" placeholder="Projects" type="text" required> 
                
                <p class="contact"><label for="username">Add Certifications</label></p> 
    			<input id="username" name="eaddress" placeholder="Certification"  type="text" required> 
    			 
                <p class="contact"><label for="experience">Update phone number</label></p> 
    			<input  id="experience" name="phone" placeholder="Phone Number"  type="text" required> 
                
              
    			<!-- <p class="contact"><label for="salary">Expected Salary</label></p> 
            <input id="phone" name="salary" placeholder="Salary" required type="text"> <br> -->
        
	 <input class="buttom" name="submit" id="submit" tabindex="5" value="Update Profile" type="submit"> 	 
   </form> 
  </div>       
          </div>
           
<script type="text/javascript">
//<![CDATA[
(function() {
var _analytics_scr = document.createElement('script');
_analytics_scr.type = 'text/javascript'; _analytics_scr.async = true; _analytics_scr.src = '/_Incapsula_Resource?SWJIYLWA=2977d8d74f63d7f8fedbea018b7a1d05&ns=1';
var _analytics_elem = document.getElementsByTagName('script')[0]; _analytics_elem.parentNode.insertBefore(_analytics_scr, _analytics_elem);
})();
// ]]>
</script></body>
</html>