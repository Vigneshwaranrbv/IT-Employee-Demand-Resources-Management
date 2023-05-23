package client;

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
 * Servlet implementation class clientquery
 */
@WebServlet("/clientquery")
public class clientquery extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String cname=request.getParameter("cname");
		String email=request.getParameter("email");
		String pname=request.getParameter("pname");
		String query=request.getParameter("query");
		try {
			String qur="insert into clientquery values(?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,cname);
			ps1.setString(2,email);
			ps1.setString(3,pname);
			ps1.setString(4,query);
			int i=ps1.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('thank you for response')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("clienthomepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not filled')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("clientquery.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
