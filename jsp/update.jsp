<html>
	<head>
		<title>Update Employee Information </title>
	</head>
	<body bgcolor="#CCCCC">
		<center><h3>Update Employee Details</h3></center>
		<hr>
		<BR>
		<BR>
		<h4>Update Employee Details....!</h4>
		<BR>
		<form name="updateform" method="post" action="/EmployeeMVC/controller/ControllerServlet">
			<input type="hidden" name="opType" value="3">
			<table>
				<tr width="100">
					<td>Eid: <input type="text" size="20" name="Eid" required=""></td>
					
				</tr> 
				<tr  width="100">
					<td>EmployeeName: <input type="text" size="20" name="EmployeeName"></td>
				</tr> 
				
				
				<tr><td><BR></td></tr>
				<tr>
					<td><input type="Submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
