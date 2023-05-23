package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class Reqduration
 */
@WebServlet("/Reqduration")
public class Reqduration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	    
		String email = request.getParameter("email");
		String projtitle = request.getParameter("ptitle");
		String pupdate = request.getParameter("pupdate");
		String sts = "request";
		Random r = new Random();
		int id = r.nextInt(100);
		   
	    
		try {
			String qur="insert into clupdation values(?,?,?,?,?)";
			String qur1="select * from webappreq where email=?";
			
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
			
			ps1.setString(1, email);
			ResultSet rs =ps1.executeQuery(); 
			if(!rs.first() ) {
				
					out.print("<html><body><script>alert('Email will be wrong')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("webappreq.html");
					rd.include(request, response);
				 return ;
			}
			
			ps.setLong(1,id);
			ps.setString(2,email);
			ps.setString(3,projtitle);
			ps.setString(4,pupdate);
			ps.setString(5,sts);
			int i=ps.executeUpdate();
			
			out.print("<html><body><script>alert('Second Updation sucessfully')</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("webappreq.html");
			rd.include(request, response);
			
			
			/*if(rs == ps1) {
				out.print("<html><body><script>alert('Second Updation sucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("webappreq.html");
				rd.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('unsucessfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("webappreq.html");
				rd.include(request, response);
			}*/
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
