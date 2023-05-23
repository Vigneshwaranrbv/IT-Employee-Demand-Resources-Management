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
 * Servlet implementation class employee
 */
@WebServlet("/employee")
public class employee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String team=request.getParameter("team");
		String emp1=request.getParameter("emp");
		String emp2=request.getParameter("emp1");
		String emp3=request.getParameter("emp2");
		/*String sts=request.getParameter("sts");*/
		try {
			String qur="insert into employee values(?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
			ps1.setString(1,team);
			ps1.setString(2,emp1);
			ps1.setString(3,emp2);
			ps1.setString(4,emp3);
			/*ps1.setString(5, sts);*/
			int i=ps1.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Employee details filled successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("third.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('Employee not filled ')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("employee.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
