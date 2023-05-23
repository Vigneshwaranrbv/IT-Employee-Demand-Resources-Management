package client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;

import util.database;


@WebServlet("/filedownload")
public class filedownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
    public filedownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/zip");
	    String pname = request.getParameter("pname");
		try {
			String qur = "select * from amount where pname=?";
			PreparedStatement ps = database.getconnection().prepareStatement(qur);
            ps.setString(1, pname);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				byte[] barr=rs.getBytes("Project file");
				processResponse(response, barr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
		String HEADER_KEY = "content-Disposition";
		  String HEADER_VALUE = "attachment; filename=\"%s\"";
		  String HEADER_FILE_NAME="filename.zip";
		
	
	private void processResponse(HttpServletResponse response, byte[] barr) throws IOException {
		response.setHeader(HEADER_KEY, String.format(HEADER_VALUE, HEADER_FILE_NAME));
		IOUtils.copy(new ByteArrayInputStream (barr),response.getOutputStream());
		
	}

	
}
