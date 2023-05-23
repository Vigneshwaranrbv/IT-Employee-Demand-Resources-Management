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
 * Servlet implementation class updateview
 */
@WebServlet("/updateview")
public class updateview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("hd");
		String sts=request.getParameter("status");
		
		try {
			String qur="update clupdation set status='"+sts+"' where id='"+a+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
		
			
			if(sts.equals("rejected")) {
				
				out.print("<html><body><script>alert('client updation is reject ')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("updateapprove.jsp");
				rd.include(request, response);
				
			    
			
			}else {
				
				 out.print("<html><body><script>alert('client project updation is accept ')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("third.html");
			     rd.include(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
