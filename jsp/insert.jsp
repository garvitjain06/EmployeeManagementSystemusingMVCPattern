<html>
	<head>
		<title>Employee Registration</title>
	</head>
	<body bgcolor="#CCCCC">
		<center><h3>Insert Employee Information</h3></center>
		<hr>
		<BR>
		<BR>
		<h4>Employee Registration</h4>
		<BR>
		<form name="insertform" method="post" action="/EmployeeMVC/controller/ControllerServlet">
			<input type="hidden" name="opType" value="2">
			<table>
				<tr width="100">
					<td>Eid: <input type="text" size="20" name="Eid"></td>
					
				</tr> 
				<tr  width="100">
					<td>Employee Name: <input type="text" size="20" name="EmployeeName"></td>
					
				</tr> 
				<tr  width="100">
					<td>Address: <input type="text" size="20" name="Address"></td>
                                   
				</tr> 
                                <tr  width="100">
					<td>Designation: <input type="text" size="20" name="Designation"></td>
                                   
				</tr> 
                               
				<tr  width="100">
					
					<td>Phone:  <input type="text" size="20" name="Phnno"></td>
				</tr> 
				<tr  width="100">
					<td>salary: <input type="text" size="20" name="Salary"></td>
                                   
				</tr> 
				<tr><td><BR></td></tr>
				<tr>
					<td><input type="Submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
