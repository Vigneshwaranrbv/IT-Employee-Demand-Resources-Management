<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page isELIgnored="false"%>
<%@page import="util.database"%>

<!doctype html>
<html lang="en">
  <head>
  <style>
 .button {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}						
</style>
  	<title>Client company Status View</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css14/style.css">
 <style>
body {
background-image: url("images/cs1.jpg");
background-repeat: no-repeat, repeat;
background-size: 1350px 900px;

}
 
</style>
	</head>
	<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section" style="font-family:normal;">CLIENT DETAILS VERIFICATION</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<h6 class="h5 mb-4 text-center"><a  href="gmhomepg.html" class="button" style="font-family:normal;">HOME</a></h6>
					<div class="table-wrap" style="height:400px;overflow:auto;">
						<table class="table">
						  <thead class="thead-primary">
						    <tr style="font-family:normal;">
						      <th>UserName</th>
						      <th>Email</th>
						      <th>Ph num</th>
						      <th>Address</th>
						       <th>Postal cd</th>
						        <th>Oname</th>
						         <th>com lic</th>
						          <th>Reg num</th>
						           
						    </tr>
						  </thead>
						  
						  
						  <%
						  ResultSet rs1=null;
						  try{
							  String qry2 = "Select * from clientregistration"; 
						    	 rs1 = database.getconnection().createStatement().executeQuery(qry2);
						    	while(rs1.next())
						    	{
						  %>
						  <tbody>
						    <tr>
						      <td><%=rs1.getString(1) %></td>
						      <td><%=rs1.getString(2) %></td>
						      <td><%=rs1.getString(3) %></td>
						      <td><%=rs1.getString(4) %></td>
						      <td><%=rs1.getString(5) %></td>
						      <td><%=rs1.getString(6) %></td>
						      <td><%=rs1.getString(7) %>></td>
						      <td><%=rs1.getString(8) %></td>
						    </tr>
						  <%}
					   		} catch (SQLException e) {
					
					e.printStackTrace();
				}	%>
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js14/jquery.min.js"></script>
  <script src="js14/popper.js"></script>
  <script src="js14/bootstrap.min.js"></script>
  <script src="js14/main.js"></script>

	</body>
</html>

