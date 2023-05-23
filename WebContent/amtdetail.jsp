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
  padding: 12px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 13px;
  margin: 2px 1px;
  cursor: pointer;
}						
</style>
  	<title>Client Payment List View</title> 
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
					<h2 class="heading-section" style="font-family:normal;">AMOUNT DETAILS</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
				<h6 class="h5 mb-4 text-center"><a  href="clienthomepg.html" class="button" style="font-family:normal;">HOME</a></h6>
					<div class="table-wrap" style="height:400px;overflow:auto;">
						<table class="table">
						  <thead class="thead-primary">
						    <tr style="font-family:normal;">
						      <th>ID</th>
						      <th>client Name</th>
						      <th>Project Name</th>						      
						      <th>Amount</th>
						     <th>Payment</th>	   		  
						    </tr>
						  </thead>
						  <%
						  ResultSet rs1=null;
						  try{
							  String qry2 = "Select * from amount"; 
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
							<td>
						      <form action="payments.jsp"  method="post">  
						   <input type="hidden" name="id" value="<%=rs1.getString(1) %>" > 
			               <input type="hidden" name="cname" value="<%=rs1.getString(2) %>" > 
			                <input type="hidden" name="pname" value="<%=rs1.getString(3) %>" > 
			                <input type="hidden" name="amt" value="<%=rs1.getString(4) %>" > 	      
						      <input type="submit" value="pay here" class=button > 						     						      
						      </form>
						      </td>						     
						      </tr>
						      
						      <tr>
						      <td>
						      <form action="download.jsp" method="post">
						      <input type="hidden" name="pname" value="<%=rs1.getString(3) %>" > 
						      </form>
						      </td>
						      </tr>
						  <%}
					   		} catch (Exception e) {
					
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

