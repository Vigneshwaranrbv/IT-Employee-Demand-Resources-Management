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
  background-color:DodgerBlue;
  border: none;
  color: white;
  padding: 13px 28px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}						
</style>
  	<title>Project Details</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css14/style.css">
 <style>
body {
background-image: url("images/cs2.jpg");
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
					<h2 class="heading-section" style="font-family:normal;"> PROJECT DETAILS</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<h6 class="h5 mb-4 text-center"><a  href="second.html" class="button" style="font-family:normal;">HOME</a></h6>
					<div class="table-wrap" style="height:400px;overflow:auto;">
						<table class="table">
						  <thead class="thead-primary">
						    <tr style="font-family:normal;">
						    <th>ID</th>
						      <th>Name</th>
						      <th>Email</th>
						      <th>Project Title</th>
						      <th>Developing Language</th>
						      <th>Finishing Date</th>
						      <th>Project description</th>
						      <th>Type application</th>
						      <th>Platform work</th>
						      <th>Device Type</th>
						      <th>Action</th>
						    </tr>
						  </thead>
						  
						  
						  <%
						  ResultSet rs1=null;
						  try{
							  String qry2 = "Select * from webappreq"; 
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
						      <td><%=rs1.getString(7) %></td>
						      <td><%=rs1.getString(8) %></td>
						      <td><%=rs1.getString(9) %></td>
						      <td><%=rs1.getString(10) %></td>
						      
						      <td>
						      <form action="sendprojsuff.jsp"  method="post"> 
						      <input type="hidden" name="id" value="<%=rs1.getString(1) %>" > 
						       <input type="hidden" name="Name" value="<%=rs1.getString(2) %>" >
						       <input type="hidden" name="email" value="<%=rs1.getString(3) %>" >
						       <input type="hidden" name="ptitle" value="<%=rs1.getString(4) %>" >
						       <input type="hidden" name="dlang" value="<%=rs1.getString(5) %>" >
						       <input type="hidden" name="date" value="<%=rs1.getString(6) %>" >
						       <input type="hidden" name="mdesc" value="<%=rs1.getString(7) %>" >
						       <input type="hidden" name="tapp" value="<%=rs1.getString(8) %>" >
						       <input type="hidden" name="pltwork" value="<%=rs1.getString(9) %>" >
						       <input type="hidden" name="device" value="<%=rs1.getString(10) %>" >
						       <input type="submit" value="CLICK HERE" class="button1" style='background-color:yellow;color:black;font-family:normal;'> 
						       </form>
						       </td>	
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
	<style>
.button1 {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 8px 23px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  margin: 3px 1px;
  cursor: pointer;
}						
</style>
</html>