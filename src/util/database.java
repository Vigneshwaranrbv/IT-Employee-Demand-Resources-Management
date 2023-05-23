package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class database
 */
@WebServlet("/database")
public class database extends HttpServlet {
	

	private static final long serialVersionUID = 1L;

	private static final String URL = "jdbc:mysql://localhost:3306/firstproject";
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
			
	public static Connection getconnection() throws SQLException {
		if (connection != null)
            return connection;
		else {
            try {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException e) 
            {
                e.printStackTrace();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            } 
            return connection;
        }
	}
}
