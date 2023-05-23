package client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.database;
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 100   // 100 MB
)

@WebServlet("/clienthomeregister")
public class clienthomeregister extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Uname=request.getParameter("uname");
		String Email=request.getParameter("em");
		String Ph = request.getParameter("ph");
		String add = request.getParameter("add");
		String oname = request.getParameter("oname");
		String Clic = request.getParameter("comlic");
		String Regnum = request.getParameter("regnum");
		String sts="request";
		
		Random r = new Random();
		int id = r.nextInt(100);
       
		try {
			String qur="insert into clientregistration values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur);
		
			ps1.setLong(1, id);
			ps1.setString(2,Uname);
			ps1.setString(3,Email);
			ps1.setString(4,Ph);
			ps1.setString(5, add);
			ps1.setString(6, oname);
			ps1.setString(7, Clic);
			ps1.setString(8, Regnum);
			ps1.setString(9, sts);
			int i=ps1.executeUpdate();
			if(i>0) {
				out.print("<html><body><script>alert('Thank you for registration')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("webappreq.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not register')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("clientregistration.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
