
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
	

                    <form name="displayform" method="post" action="/EmployeeMVC/controller/ControllerServlet">
		<input type="hidden" name="opType" value="1">
		     <tr width="100">
					<td>Eid: <input type="text" size="20" name="Eid"></td>
					
				</tr> 
				<tr><td><BR></td></tr>
				<tr>
					<td><input type="Submit" value="Submit"></td>
				</tr>
                     </form>
                  <a href ="http://localhost:8080/EmployeeMVC/controller/ControllerServlet?opType=5">Return to Home Page
		</a>
	</body>
</html>


