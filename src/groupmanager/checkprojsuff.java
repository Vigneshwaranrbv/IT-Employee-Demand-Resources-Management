package groupmanager;

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
 * Servlet implementation class checkprojsuff
 */
@WebServlet("/checkprojsuff")
public class checkprojsuff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String email = request.getParameter("email");
		String ptitle = request.getParameter("ptitle");
		String dlang = request.getParameter("dlang");
		String date = request.getParameter("date");
		String mdesc = request.getParameter("mdesc");
		String tapp = request.getParameter("tapp");
		String pltwork = request.getParameter("pltwork");
		String device = request.getParameter("device");
		String sts="request";
		
		try {
			String qur="insert into sendprojdetail values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			
			ps.setString(1,id);
			ps.setString(2,Name);
			ps.setString(3, email);
			ps.setString(4, ptitle);
			ps.setString(5,dlang);
			ps.setString(6,date);
			ps.setString(7,mdesc);
			ps.setString(8,tapp);
			ps.setString(9,pltwork);
			ps.setString(10, device);
			ps.setString(11, sts);
			
			int i = ps.executeUpdate();
			if(i>0) {
				out.println("<html><body><script>alert('Application Details fill Successfully ')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("second.html");
				rd.forward(request, response);
			}
			else
			out.print("<html><body><script>alert('Not filled')</script></body></html>");
			RequestDispatcher rd = request.getRequestDispatcher("second.html");
			rd.include(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
