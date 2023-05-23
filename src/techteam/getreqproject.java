package techteam;

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
 * Servlet implementation class getreqproject
 */
@WebServlet("/getreqproject")
public class getreqproject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String team = request.getParameter("team");
		String ptitle = request.getParameter("ptitle");
		String number = request.getParameter("number");
		String dlang = request.getParameter("dlang");
		String date = request.getParameter("date");
		String edate = request.getParameter("date");
		try {
			String qur="insert into getreqproject values(?,?,?,?,?,?)";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			ps.setString(1, team);
			ps.setString(2, ptitle);
			ps.setString(3, number);
			ps.setString(4, dlang);
			ps.setString(5, date);
			ps.setString(6, edate);
			int i = ps.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Project details Starting Updated')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
				rd.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('Not update properly')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("getrequirement.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
