package techteam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class projectappRej
 */
@WebServlet("/projectappRej")
public class projectappRej extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("hd");
		String sts="Approved";

		try {
			String qur="update sendprojdetail set status='"+sts+"' where id='"+a+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
			
			if(sts.equals("rejected")) 
			{
				
				out.print("<html><body><script>alert('Project has been reject')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("third.html");
				rd.include(request, response);			    			
			}
			else 
			{								
				 out.print("<html><body><script>alert('Project has been accept')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("third.html");
			     rd.include(request, response);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
