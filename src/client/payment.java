package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class payment
 */
@WebServlet("/payment")
public class payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String id = request.getParameter("id");
		String cname = request.getParameter("cname");
		String pname=request.getParameter("pname");
		String name=request.getParameter("name");
		String cnumber=request.getParameter("cnumber");
	    String paid=request.getParameter("paid");
		
		try {
			String qur = "insert into payment values(?,?,?,?,?,?)";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			ps.setString(1, id);
			ps.setString(2, cname);
			ps.setString(3, pname);
			ps.setString(4, name);
			ps.setString(5, cnumber);
			ps.setString(6, paid);
			 int k=ps.executeUpdate();
			 
			    if(k>0) {
			    	out.print("<html><body><script>alert('Payment successfull')</script></body></html>");
			    	RequestDispatcher rd= request.getRequestDispatcher("download.jsp");
			    	rd.include(request, response);
			    }
			    else {
			    	out.print("<html><body><script>alert('Transaction failed')</script></body></html>");
			    	RequestDispatcher rd = request.getRequestDispatcher("payment.html");
			    	rd.include(request, response);
			    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}










