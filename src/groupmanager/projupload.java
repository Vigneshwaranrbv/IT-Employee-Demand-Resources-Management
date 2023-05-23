package groupmanager;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.database;

/**
 * Servlet implementation class projupload
 */

@WebServlet("/projupload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class projupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("zip");
		PrintWriter out=response.getWriter();
		String pname = request.getParameter("pname");
		 Part part = request.getPart("zip"); 
		   try {
			  
			   String qur = "insert into fileupload values(?,?)";
			
			   PreparedStatement ps = database.getconnection().prepareStatement(qur);
			   InputStream is = part.getInputStream();
			   ps.setString(1, pname);
			  
				ps.setBinaryStream(2, is);
				
			   int i = ps.executeUpdate();
			   System.out.println("print");
			   if(i>0) {
				   out.print("<html><body><script>alert('File updation sucessfully')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
					rd.include(request, response); 
			   }
			   else {
				   out.print("<html><body><script>alert('This file not supported')</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("tthomepg.html");
					rd.include(request, response);
			   }
		   }catch(Exception e) {
			   e.printStackTrace();
		   }
		   
	}

}
