<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="common.data.* ,common.db.* , common.constants.*,controller.*" %>

<html>
<head>
<title>Employee Management Details</title>
</head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<body>
	<h2>Displaying Employee Details </h2>
	<h3>
	<%
		try
                {
		 	
					EmployeeDetails userReg= (EmployeeDetails)session.getAttribute( "userRegData" ) ; 
					ResultSet rs1= (ResultSet) session.getAttribute( "result" ) ; 
                                        
                                                out.println("<table><tr><th>EID</th><th>Employee Name</th><th>Address</th><th>Designation</th><th>Phoneno</th><th>Salary</th></tr>");
				while(rs1.next()){	
					 
			      
  			                out.println("<tr><td>"+rs1.getString(1)+"</td><td>"+rs1.getString(2)+"</td><td>"+rs1.getString(3)+"</td><td>"+rs1.getString(4)+"</td><td>"+rs1.getString(5)+"</td><td>"+rs1.getString(6)+"</td></tr>"); 
			               }
                                      
  		        
			 
			out.println("</table>");
         		
		}
		catch(Exception e)
		{ out.println(e);} 
	
	%>
	</h3>


                  <a href ="http://localhost:8080/EmployeeMVC/controller/ControllerServlet?opType=5">Return to Home Page
		</a>
	</body>
</html>


