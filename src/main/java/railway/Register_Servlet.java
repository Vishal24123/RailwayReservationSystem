package railway;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class Register_Servlet
 */
@WebServlet("/register")
public class Register_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name= request.getParameter("name");
		String phone= request.getParameter("phone");
		String email= request.getParameter("email");
		String password= request.getParameter("pass1");
		String repassword= request.getParameter("pass2");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		 int test=password.compareTo(repassword);
		 if(test==0) {
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("insert into user_details(name, phone, email, password) values (?,?,?,?)");
			pt.setString(1, name);
			pt.setString(2, phone);
			pt.setString(3, email);
			pt.setString(4, password);
			
			int rowCount = pt.executeUpdate();
			
			if (rowCount > 0) {
				request.setAttribute("rstatus", "success");
				dispatcher = request.getRequestDispatcher("index.jsp");
			} else {
				request.setAttribute("rstatus",  "failure");
				dispatcher = request.getRequestDispatcher("sign_up.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		 else {
			 request.setAttribute("rstatus", "password mismatch");
			 dispatcher = request.getRequestDispatcher("sign_up.jsp");
		 }
		 dispatcher.forward(request, response);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
