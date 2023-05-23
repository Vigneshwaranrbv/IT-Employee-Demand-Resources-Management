package groupmanager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class manager
 */
@WebServlet("/manager")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 10737418240L,     // 10 GB
maxRequestSize = 10737418240L   // 100 gb
)
public class manager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	    Part part=request.getPart("file");		
				
	    String csvFilePath="E:/Work Space/firstproject/projectdata/employee.csv" + part.getSubmittedFileName();
	    part.write(csvFilePath);
	    
	    System.out.println(new File(csvFilePath).getCanonicalPath());
	    
		/*String csvFilePath ="D:/Work Space/secondproject/projectdata/Piece_Dimension.csv";*/
		
	    try {
			String qry = "LOAD DATA INFILE '"+csvFilePath+"'" + 
	   	 		      "INTO TABLE empupl FIELDS TERMINATED BY ','" + 
	   	 		      "OPTIONALLY ENCLOSED by '\"' LINES TERMINATED BY '\r\n' ignore 1 LINES";
			
			// "OPTIONALLY ENCLOSED by '\"' IGNORE 1 LINES (date1, feet, inflow, outflow, tmc)";
		   	 
		   	 
		   	 int i = util.database.getconnection().prepareStatement(qry).executeUpdate();
		    
		   
			if(i>0) {
				out.print("<html><body><script>alert('Uploaded Employee Details Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("gmhomepg.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('you not registered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("gmhomepg.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
