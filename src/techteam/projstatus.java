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
 * Servlet implementation class projstatus
 */
@WebServlet("/projstatus")
public class projstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    String req = request.getParameter("req");
	    String des = request.getParameter("des");
	    String dev = request.getParameter("dev");
	    String test = request.getParameter("test");
	    String maint = request.getParameter("maint");
	    try {
	    	String qur = "insert into projstatus value(?,?,?,?,?)";
	    	PreparedStatement ps = database.getconnection().prepareStatement(qur);
	    	ps.setString(1,req);
	    	ps.setString(2, des);
	    	ps.setString(3, dev);
	    	ps.setString(4, test);
	    	ps.setString(5, maint);
	    	int i = ps.executeUpdate();
	    	if(i>0) {
	    		out.print("<html><body><scrpit>alert('Update team formation')</script></body></html>");
	    		RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
	    		rd.include(request, response);
	    	}
	    	else {
	    		out.print("<html><body><scrpit>alert('not update ')</script></body></html>");
	    		RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
	    		rd.include(request, response);
	    	}
	    	
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    
	}

}
