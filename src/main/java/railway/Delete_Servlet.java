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

/**
 * Servlet implementation class Delete_Servlet
 */
@WebServlet("/delete_tickets")
public class Delete_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnr1 = request.getParameter("pnr");
		int pnr=Integer.parseInt(pnr1);
		HttpSession session = request.getSession();	
		RequestDispatcher dispatcher = null;
			Connection con = null;
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
				
				PreparedStatement pt= con.prepareStatement("DELETE from book_tickets where pnr= ?");
				pt.setInt(1, pnr); 
				int rs = pt.executeUpdate();
				
				if (rs> 0)
				{
					request.setAttribute("dstatus",  "success");
					dispatcher=request.getRequestDispatcher("viewDelete.jsp");					 
				}
				else
				{
					request.setAttribute("dstatus",  "failure");
					dispatcher=request.getRequestDispatcher("booking_cancellaton.jsp");					
				}
				dispatcher.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}
	}

}
