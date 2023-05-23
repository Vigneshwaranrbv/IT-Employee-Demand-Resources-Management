package techteam;

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
 * Servlet implementation class ttlogin
 */
@WebServlet("/ttlogin")
public class ttlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String e=request.getParameter("email");
		String p=request.getParameter("password");
		try {
			String qur="select * from ttregister where email=? and password=?";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,e);
			ps1.setString(2, p);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				out.print("<html><body><script>alert('Teach Team login Successfully') </script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
				rd.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('Incorrect email and password') </script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("ttlogin.html");
				rd.include(request, response);
			}
		}catch(Exception E) {
			System.out.println(E);
		}
	}

}
