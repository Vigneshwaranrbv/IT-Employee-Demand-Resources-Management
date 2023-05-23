package techteam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class TrainingDataUpload
 */
@WebServlet("/TrainingDataUpload")
public class TrainingDataUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest r, HttpServletResponse rs) throws ServletException, IOException {

	     String csvFilePath = "D:/COMPLETE PROJE/firstproject/projectdata/demandmanage.csv";
	     
	     try {
	    	 String qry = "LOAD DATA INFILE '"+csvFilePath+"'" + 
	    	 		      "INTO TABLE demand status FIELDS TERMINATED BY ','" + 
	    	 		      "OPTIONALLY ENCLOSED by '\"'";
	    	 // "OPTIONALLY ENCLOSED by '\"' IGNORE 1 LINES (date1, feet, inflow, outflow, tmc)";
	    	 int i = util.database.getconnection().prepareStatement(qry).executeUpdate();
	    	 if(i>0) {
	    		 rs.sendRedirect("#");
	    	 }else {
	    		 rs.sendRedirect("#");
	    	 }
	    	 
	     }catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     
	     		
	}
}

