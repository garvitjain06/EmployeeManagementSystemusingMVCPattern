<html>
	<head>
		<title>Delete Employee Information</title>
	</head>
	<body bgcolor="#CCCCC">
		<center><h3>Delete Employee Information</h3></center>
		<hr>
		<BR>
		<BR>
		<h4>Delete Employee details...!</h4>
		<BR>
		<form name="deleteform" method="post" action="/EmployeeMVC/controller/ControllerServlet">
			<input type="hidden" name="opType" value="4">
			<table>
				<tr width="100">
					<td>Eid: <input type="text" size="20" name="Eid" required=""></td>
			
				</tr> 
				<tr><td><BR></td></tr>
				<tr>
					<td><input type="Submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
