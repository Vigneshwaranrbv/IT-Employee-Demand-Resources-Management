package admi;

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

/**
 * Servlet implementation class amount
 */
@WebServlet("/amount")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class amount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("zip");
		PrintWriter out=response.getWriter();
		String cname=request.getParameter("cname");
		String pname=request.getParameter("pname");
		String amt = request.getParameter("amt");
		Part part = request.getPart("zip"); 
		Random r = new Random();
		int id = r.nextInt(100);
		try {
			String qur="insert into amount values(?,?,?,?,?)";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
			 InputStream is = part.getInputStream();
			ps.setLong(1, id);
			ps.setString(2, cname);
			ps.setString(3, pname);
			ps.setString(4, amt);
		    ps.setBinaryStream(5, is);
			/*ByteArrayOutputStream boa=new ByteArrayOutputStream();
			int read;
			
			byte[] data = new byte[16384];
			while((read=is.read(data, 5, data.length)) != -1) {
			
			}
			boa.write(data,5,read);*/
			int i = ps.executeUpdate();
			
			if(i>0) 
			{
				out.print("<html><body><script>alert('amount details update successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("adminhomepg.html");
				rd.include(request, response);
			}
			else {
				out.print("<html><body><script>alert('not filled')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("adminhomepg.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
