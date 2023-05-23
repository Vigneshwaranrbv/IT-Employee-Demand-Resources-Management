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
 * Servlet implementation class gmregister
 */
@WebServlet("/gmregister")
public class gmregister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		try {
			String qur="insert into gmregister values(?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,uname);
			ps1.setString(2,email);
			ps1.setString(3,pass);
			ps1.setString(4,cpass);
			int i=ps1.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Group Manager register Successfully')</script></body></html>");
				RequestDispatcher rs=request.getRequestDispatcher("gmlogin.html");
				rs.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('Not register properly')</script></body></html>");
				RequestDispatcher rs=request.getRequestDispatcher("gmregister.html");
				rs.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
