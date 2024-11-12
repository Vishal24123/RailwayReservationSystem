package railway;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class Book_Tickets_Servlet
 */
@WebServlet("/buy_tickets")
public class Book_Tickets_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String no_of_tickets1 = request.getParameter("quantity");
		int no_of_tickets=Integer.parseInt(no_of_tickets1);
		String phone = request.getParameter("phone");
		String address = request.getParameter("addr");
		String type = request.getParameter("type");
		String froms= (String) request.getAttribute("froms");
		String tos=request.getParameter("tos");
		String date=request.getParameter("dates");
		String tname=request.getParameter("tname");
		//String tnum1=request.getParameter("tnum");
		//int tnum=Integer.parseInt(tnum1);
		String departure= request.getParameter("departure");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		int pnr= (int) (Math.random()%100000+100000);
		
		PrintWriter out= response.getWriter();
		out.println ("froms"+froms); 
		out.println ("tos"+tos); 
		out.println ("date"+date);
		out.println ("fname"+fname); 
		out.println ("lname"+lname); 
		out.println ("email"+email); 
		out.println ("phone"+phone); 
		out.println ("type"+type); 
		out.println ("no_of_tickets"+no_of_tickets); 
		out.println ("address"+address); 
		out.println ("pnr"+pnr); 
		out.println ("tname"+tname); 
		//out.println ("tnum"+tnum); 
		out.println ("departure"+departure); 
		
	}}
/*		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("insert into book_tickets(froms, tos, dates, fname, lname, email, phone, classtype, ntickets, address, pnr, tname, tnum, departure) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pt.setString(1, froms);
			pt.setString(2, tos);
			pt.setString(3, date);
			pt.setString(4, fname);
			pt.setString(5, lname);
			pt.setString(6, email);
			pt.setString(7,phone);
			pt.setString(8,type);
			pt.setInt(9,no_of_tickets );
			pt.setString(10, address);
			pt.setInt(11, pnr);
			pt.setString(12, tname);
			pt.setInt(13, tnum);
			pt.setString(14, departure);
			
			int rowCount = pt.executeUpdate();
			dispatcher = request.getRequestDispatcher("booking_cancellation.jsp");
			if (rowCount > 0) {
				request.setAttribute("bstatus", "success");
				dispatcher = request.getRequestDispatcher("booking_cancellation.jsp");
			} else {
				request.setAttribute("bstatus",  "failure");
				dispatcher = request.getRequestDispatcher("tickets_booking.jsp");
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

}*/
