package railway;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/find_tickets")
public class Find_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pnr1 = request.getParameter("pnr");
		int pnr=Integer.parseInt(pnr1);
		RequestDispatcher dispatcher = null;
		
	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("select * from book_tickets where pnr = ?");
			pt.setInt(1, pnr); 
			ResultSet rs = pt.executeQuery();
			
			while (rs.next())
			{
				
				request.setAttribute("froms", rs.getString(1));
				request.setAttribute("tos", rs.getString(2));
				request.setAttribute("dates", rs.getString(3));
				request.setAttribute("fname", rs.getString(4));
				request.setAttribute("lname", rs.getString(5));
				request.setAttribute("email", rs.getString(6));
				request.setAttribute("phone", rs.getString(7));
				request.setAttribute("classtype", rs.getString(8));
				request.setAttribute("ntickets", rs.getInt(9));
				request.setAttribute("address", rs.getString(10));
				request.setAttribute("pnr", rs.getInt(11));
				request.setAttribute("tname", rs.getString(12));
				request.setAttribute("tnum", rs.getInt(13));
				request.setAttribute("departure", rs.getString(14));
				
				dispatcher = request.getRequestDispatcher("see_detail.jsp");
				dispatcher.forward(request, response);
			} 
				request.setAttribute("fstatus", "failed");
				dispatcher = request.getRequestDispatcher("delete/cancel.jsp");
				dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

}
