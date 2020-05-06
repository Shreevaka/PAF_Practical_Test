<%@page import="model.Hospital"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospitals Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/hospitals.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">

				<h1 align="center">Hospitals Management</h1>

				<form id="formHospital" name="formHospital">
					
					Hospital Name: 
					<input id="hosName" name="hosName" type="text" class="form-control form-control-sm">
					
					<br> Hospital Address: 
					<input id="hosAddress" name="hosAddress" type="text" class="form-control form-control-sm">
					
					<br> Hospital Phone No: 
					<input id="hosPhoneNo" name="hosPhoneNo" type="text" class="form-control form-control-sm">
					
					<br> Hospital Email: 
					<input id="hosEmail" name="hosEmail" type="text" class="form-control form-control-sm">
					
					<br> No Of Rooms: 
					<input id="hosNoOfRooms" name="hosNoOfRooms" type="text" class="form-control form-control-sm">
					
					<br> 
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
					<input type="hidden" id="hidhosIDSave" name="hidhosIDSave" value="">
				</form>
				

					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
				<br>
		
				<div id="divHospitalsGrid">
					<%
						Hospital hospitalObj = new Hospital();
						out.print(hospitalObj.readHospitals());
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>