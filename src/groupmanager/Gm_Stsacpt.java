package groupmanager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.database;

/**
 * Servlet implementation class Gm_Stsacpt
 */
@WebServlet("/Gm_Stsacpt")
public class Gm_Stsacpt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String pcode = request.getParameter("pcode");
		String sts = request.getParameter("statuss");

		

		try {
			//this code is status updation process
			if (sts.equals("rejected")) {
				/*
				 * String qur="delete from demanddtl where pcode='"+a+"'"; boolean r1 =
				 * database.getconnection().prepareStatement(qur).execute();
				 */
				out.print("<html><body><script>alert ('Group Manager does not accept')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("demanddetail.jsp");
				rd.include(request, response);

			} else {
				String qur2 = "update demanddtl set statuss='" + sts + "' where pcode='" + pcode + "'";
				int r = database.getconnection().prepareStatement(qur2).executeUpdate();
				out.print("<html><body><script>alert('Group Manager accept the demand')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("second1.html");
				rd.include(request, response);
			}
			
			
			String domain = request.getParameter("domain");
			String empcount = request.getParameter("empcount");
			//System.out.println(domain +" " + " " + empcount);
			
			String qur1 = "select * from empupl";
			Statement ps1 = database.getconnection().createStatement();
			ResultSet j = ps1.executeQuery(qur1);
			if(j.next()) {
				
				/*String empid=j.getString(1);
				String empname=j.getString(2);
				String domain1= j.getString(3);
				String exp=j.getString(4);
				String wrkst=j.getString(5);
				String pcount=j.getString(6);
				String pstatus=j.getString(8);	*/
             /*
			String empid = request.getParameter("empid");
			String domain1 = request.getParameter("domain1");
			String empid1 = request.getParameter("empid1");
			String empname = request.getParameter("empname");
			String desg = request.getParameter("desg");
			String exp1 = request.getParameter("exp1");
			String wrkst = request.getParameter("wrkst");
			String pcount = request.getParameter("pcount");
			*/
				
			//System.out.println(domain1+domain);	
			
			if (domain.equalsIgnoreCase("Front-end Developer")||domain.equalsIgnoreCase("BacK-end Developer")||domain.equalsIgnoreCase("Database")) {
				
				//    System.out.println(domain1 + empcount);
			
					String qur2 = "Select * from empupl where domain='"+domain+"' order by pstatus DESC limit "+empcount+"";
					Statement ps2 = database.getconnection().createStatement();
					ResultSet k = ps2.executeQuery(qur2);        
					
					while(k.next()) {
					
						String qur3 = "insert into requestemp values(?,?,?,?,?,?,?)";
						PreparedStatement ps3 = database.getconnection().prepareStatement(qur3);
						
						ps3.setString(1, k.getString(1));
						ps3.setString(2, k.getString(2));
						ps3.setString(3, k.getString(3));
						ps3.setString(4, k.getString(4));
						ps3.setString(5, k.getString(5));
						ps3.setString(6, k.getString(6));
						ps3.setString(7, k.getString(8));
						int i1  = ps3.executeUpdate();
						if(i1>0) {
							String qur="delete from empupl where empid='"+k.getString(1)+"'"; 
							int i2 = database.getconnection().prepareStatement(qur).executeUpdate(); 
						}
					}
					
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
