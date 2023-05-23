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
@WebServlet("/teammointor")
public class teammointor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String pname=request.getParameter("pname");
		String req=request.getParameter("req");
		String des=request.getParameter("des");
		String dev=request.getParameter("dev");
		String test=request.getParameter("test");
		String maint = request.getParameter("maint");
         try {
        	 String qur="insert into ttstatus values(?,?,?,?,?,?)";
 			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
	
			ps1.setString(1, pname);
			ps1.setString(2, req);
			ps1.setString(3, des);
			ps1.setString(4, dev);
			ps1.setString(5, test);
			ps1.setString(6, maint);
			int i = ps1.executeUpdate();
			if(i > 0) {
				out.print("<html><body><script>alert('Project Updation Status')</script></body></html>");
				RequestDispatcher rs = request.getRequestDispatcher("third1.html");
				rs.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('not filled updation')</script></body></html>");
				RequestDispatcher rs=request.getRequestDispatcher("mointor.html");
				rs.include(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
