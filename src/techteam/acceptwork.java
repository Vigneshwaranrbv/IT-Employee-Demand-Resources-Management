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
 * Servlet implementation class acceptwork
 */
@WebServlet("/acceptwork")
public class acceptwork extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pcode=request.getParameter("pcode");
		String ptitle=request.getParameter("ptitle");
		String status=request.getParameter("status");
		String sts="Started";
		try {
			
			String qur1="update demanddtl set statuss='"+sts+"' where pcode='"+pcode+"'";
			int r=database.getconnection().prepareStatement(qur1).executeUpdate();
			
			String qur2="insert into acceptwork values(?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur2);
			ps1.setString(1,pcode);
			ps1.setString(2,ptitle);
			ps1.setString(3,status);
			int i=ps1.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Project Work Process has been Started')</script></body></html>");
				RequestDispatcher rs = request.getRequestDispatcher("third.html");
				rs.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('Not start')</script></body></html>");
				RequestDispatcher rs=request.getRequestDispatcher("ttregister.html");
				rs.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
