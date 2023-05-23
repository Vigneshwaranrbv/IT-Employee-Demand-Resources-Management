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
 * Servlet implementation class teamwork
 */
@WebServlet("/teamwork")
public class teamwork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String ptitle = request.getParameter("ptitle");
		String team = request.getParameter("team");
		String req = request.getParameter("req");
		String des = request.getParameter("des");
		String dev = request.getParameter("dev");
		String test = request.getParameter("test");
		String maint = request.getParameter("maint");
		
		try {
			String qur = "insert into team values(?,?,?,?,?,?,?)";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			ps.setString(1, ptitle);
			ps.setString(2, team);
			ps.setString(3, req);
			ps.setString(4, des);
			ps.setString(5, dev);
			ps.setString(6, test);
			ps.setString(7, maint);
			
			
			
			int i = ps.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Send team Formation to technical lead')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("gmhomepg.html");
				rd.include(request, response);
			}else
			{
				out.print("<html><body><script>('not send formation')</script></body></html>");
				RequestDispatcher rd= request.getRequestDispatcher("teamgroup.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
