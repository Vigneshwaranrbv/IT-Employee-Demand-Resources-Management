package admi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class adminlogin
 */
@WebServlet("/adminlogin")
public class adminlogin extends HttpServlet{
private static final long serialVersionUID = 1L;


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pw = response.getWriter();
	
	String email = request.getParameter("email");
	String pass = request.getParameter("password");
	
	
	String Mail = "admin@gmail.com";
	String Pass = "admin";

   	 if(email.equals(Mail) && pass.equals(Pass)){
		pw.println("<html><body><script>alert('Admin Login Successfully')</script></body></html>");
		RequestDispatcher rd2 = request.getRequestDispatcher("adminhomepg.html");
		rd2.include(request,response);
		
		
		
	}
	else
	{
		pw.println("<html><body><script>alert('Incorrect email or password..!!')</script></body></html>");
		RequestDispatcher rd2 = request.getRequestDispatcher("adminlogin.html");
		rd2.include(request,response);
		
	}
   	 
	
	
	
}

}
