package railway;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user_email = request.getParameter("username");
		String user_pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("select * from user_details where email = ? and password = ?");
						
			pt.setString(1, user_email); 
			pt.setString(2, user_pwd); 
			
			ResultSet rs = pt.executeQuery();
			
			if (rs.next()) {
			
				session.setAttribute("name", rs.getString("email"));
				dispatcher = request.getRequestDispatcher("booking_cancellaton.jsp");
			} else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 	
	}

}
