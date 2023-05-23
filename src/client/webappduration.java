package client;

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
 * Servlet implementation class webappduration
 */
@WebServlet("/webappduration")
public class webappduration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String name = request.getParameter("Name");
		String email = request.getParameter("email");
		String ptitle = request.getParameter("ptitle");
		String dlang = request.getParameter("dlang");
		String date = request.getParameter("date");
		String mdesc = request.getParameter("mdesc");
		String tapp[] = request.getParameterValues("s");
		String con = "";
		for(String hb : tapp) {
		 con = con.concat(hb).concat(", ");
		}
		//System.out.println(tapp[0]);
		//System.out.println(tapp[1]);
		
		
		String pltwork[] = request.getParameterValues("pltwork");
		String con1="";
		for(String hb1 : pltwork) {
			con1 = con1.concat(hb1).concat(","); 
		}
		String[] device = request.getParameterValues("device");
		String con2="";
		for(String hb2:device) {
			con2 = con.concat(hb2).concat(",");
		}
		String sts = "Requested";
		Random r = new Random();
		int id = r.nextInt(100);
		try {
			String qur="insert into webappreq  values(?,?,?,?,?,?,?,?,?,?,?)"; 
		PreparedStatement ps= database.getconnection().prepareStatement(qur);
           ps.setLong(1, id);
		   ps.setString (2,name);
		   ps.setString(3,email);
		   ps.setString(4,ptitle);
		   ps.setString(5,dlang);
		   ps.setString(6,date);
		   ps.setString(7,mdesc);
		   ps.setString(8,con);
		   ps.setString(9, con1);
		   ps.setString(10,con2);
		   ps.setString(11,sts);
		   int k=ps.executeUpdate();
		    if(k>0) {
		    	out.print("<html><body><script>alert('Project details filled Successfully')</script></body></html>");
		    	RequestDispatcher rd= request.getRequestDispatcher("webappreq.html");
		    	rd.include(request, response);
		    }
		    else {
		    	out.print("<html><body><script>alert('your Not update properly')</script></body></html>");
		    	RequestDispatcher rd = request.getRequestDispatcher("reqwebdur.html");
		    	rd.include(request, response);
		    }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}




