package techteam;

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
 * Servlet implementation class demanddetail
 */
@WebServlet("/demanddetail")
public class demanddetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String pcode=request.getParameter("pcode");
		String ptitle=request.getParameter("ptitle");
		String status=request.getParameter("status");
		String cstage=request.getParameter("cstage");
		String pmang=request.getParameter("pmang");
		String sdate=request.getParameter("sdate");
		String cdate=request.getParameter("cdate");
		String bgt=request.getParameter("bgt");
		String emp=request.getParameter("emp");
		String pty=request.getParameter("pty");
		String date=request.getParameter("date");
		String addempcount=request.getParameter("addempcount");
		String sts="Requested";
		/*Random r = new Random();
		int id = r.nextInt(100);*/
		
		try {
			String qur1="insert into demanddtl values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps1 = database.getconnection().prepareStatement(qur1);
			ps1.setString(1,pcode);
			ps1.setString(2,ptitle);
			ps1.setString(3,status);
			ps1.setString(4,cstage);
			ps1.setString(5,pmang);
			ps1.setString(6,sdate);
			ps1.setString(7,cdate);
			ps1.setString(8,bgt);
			ps1.setString(9,emp);
			ps1.setString(10,pty);
			ps1.setString(11,date);
			ps1.setString(12,addempcount);
			ps1.setString(13, sts);
			int i=ps1.executeUpdate();
			
			if(i>0) {
				/*String qur2="delete from demand where pcode='"+pcode+"'"; 
				int i2 = database.getconnection().prepareStatement(qur2).executeUpdate(); */
				out.print("<html><body><script>alert('Project demand details send to Group Manager ')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("third.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('Demand not Filled')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("demanddetails.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
