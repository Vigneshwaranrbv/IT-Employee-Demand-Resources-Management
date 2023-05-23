package admi;

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
 * Servlet implementation class amtdetails
 */
@WebServlet("/amtdetails")
public class amtdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String a = request.getParameter("hd");
		String sts= "paid";
		
		try {
			String qur="update amount set status='"+sts+"' where id='"+a+"'";
			int r=database.getconnection().prepareStatement(qur).executeUpdate();
		
			
			if(r > 0) {
				
			     out.print("<html><body><script>alert('your Transaction successfully Paid')</script></body></html>");
			     RequestDispatcher rd = request.getRequestDispatcher("adminhomepg.html");
			     rd.include(request, response);
			
			}else {
				out.print("<html><body><script>alert('Transaction failed ')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("amtdetails.jsp");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
