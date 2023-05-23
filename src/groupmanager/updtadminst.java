package groupmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class updtadminst
 */
@WebServlet("/updtadminst")
public class updtadminst extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("hd");
		String sts= request.getParameter("status");
		
		try {
			
			String qur="update demand set status='"+sts+"' where id='"+a+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
			
			if(sts.equals("rejected")) {
				
				out.print("<html><body><script>alert('Demand is reject')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("second1.html");
				rd.include(request, response);
			}
			else {
				
				out.print("<html><body><script>alert('Demand has been accept ')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("demanddetail.jsp");
			     rd.include(request, response);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
