<%@page import="com.iijp.service.GetDepartments"%>
<%@page import="com.iijp.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC  >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

  <title>photo_style</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
  <link rel="stylesheet" type="text/css" href="style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="modernizr-1.5.min.js"></script>
</head>

<body>
<%
if(session.getAttribute("employee_name")==null)
{
	response.sendRedirect("New folder/form.jsp");
}

%>
  <div id="main">
    <header>
      <div id="logo">
        <div id="logo_text">
          <!-- class="logo_colour", allows you to change the colour of the text -->
          <h1><font size=5px><a href="">INFOGAIN JOB<span class="logo_colour">PORTAL</span></a></font></h1>
          <img src="logo.jpg" height=60 width=220/>
        </div>
      </div>
      <nav>
        <ul class="sf-menu" id="nav">
          <li class="selected"><a href="Employee.jsp">Home</a></li>
         <li><a href="Organise.html">Organisation chart</a></li>
          <li><a href="#">JOBS</a>
            <ul>
              <li><a href="#">Jobs By Location</a>
              <ul>
			  <%
			  GetDepartments get=new GetDepartments();
			  ArrayList<Branch> branch=get.getBranch();
			  ArrayList<String> jobnames=get.getJobNames();
			  ArrayList<Departments> departments=get.getdepartments();
			  for(Branch b:branch)
			  {
			  %>
			   
                  <li><a href="./BranchServlet?user=<%=b.getBranch_id() %>"><%=b.getBranch_name() %> </a></li>
                  
               
                <%
               }
                %>
                </ul>
				</li>
              <li><a href="#">Jobs By Designation</a>
              <ul>
              <%
              for(String j:jobnames)
			  {
              %>
                
                  <li><a href="./DesignationServlet?user=<%=j %>"><%=j %> </a></li>
                  
                
                <%
			  }
                %>
                </ul>
              </li>
              <li><a href="#">Jobs By Departments</a>
               <ul>
              <%
              for(Departments d:departments)
              {
              
              %>
			  
                  <li><a href="./DepartmentServlet?user=<%=d.getDepartment_id() %>"><%=d.getDepartment_name() %> </a></li>

                 <%
              }
              %>	
              </ul>  
			  </li>
        
            </ul>
          </li>
		   <li><a href="View.jsp">View Profile</a></li>
		    
          <li><a href="contact.html">Contact Us</a></li>
          
           <li><a href="./InboxServlet?user=<%=(String)session.getAttribute("employee_name") %>">Inbox</a></li>
       
		     
			  <li><a href="./Logoutservlet">Log Out</a></li>
       
        </ul>
      </nav>
    </header>
    <div id="site_content">
      <div id="sidebar_container">
        <div class="gallery">
          <ul class="images">
            <li class="show"><img width="450" height="450" src="1.jpg" alt="photo_one" /></li>
            <li><img width="450" height="450" src="2.jpg" alt="photo_two" /></li>
            <li><img width="450" height="450" src="3.jpg" alt="photo_three" /></li>
          </ul>
        </div>
      </div>
      <div id="content">
        <h1>Welcome Mr.<%=(String)session.getAttribute("employee_name") %></h1>
		<img src="<%=(String)session.getAttribute("employee_name")%>.jpg" height=200 width=200>
        <p><font size=4px> Employee Id</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=session.getAttribute("user") %></p>
		 <p><font size=4px> Designation</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)session.getAttribute("designation") %></p>
		  <p><font size=4px> Department</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(String)session.getAttribute("department_name") %></p>
          <!--  <a href="postjobs/ProfileEdit.jsp"><input type="button" value="Edit Profile"  /></a> -->
  
  <%
if(!(session.getAttribute("success")==null))
{
String success=(String)session.getAttribute("success");
%><h3><%=success %><%} %></h3>
         <%
if(!(session.getAttribute("success1")==null))
{
String success=(String)session.getAttribute("success1");
%><h3><%=success %><%} %></h3>
      </div>
    </div>
    <footer>
      <p>Copyright &copy; 2015 Infogain Corporation. All rights reserved.</p>
    </footer>
  </div>
  <p>&nbsp;</p>
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="jquery.js"></script>
  <script type="text/javascript" src="jquery.easing-sooper.js"></script>
  <script type="text/javascript" src="jquery.sooperfish.js"></script>
  <script type="text/javascript" src="image_fade.js"></script>
  <script type="text/javascript">
    $(document).ready(function() {
      $('ul.sf-menu').sooperfish();
    });
  </script>
</body>

</html>