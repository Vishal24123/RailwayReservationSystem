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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@WebServlet("/book_tickets")
public class Enquire_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from= request.getParameter("from");
		String to= request.getParameter("to");
		String  date = request.getParameter("date");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("u-M-d", Locale.ENGLISH);
        LocalDate date1 = LocalDate.parse(date, dtf);
        DayOfWeek dow = date1.getDayOfWeek();
        String day= dow.name();
        
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwaydb?useSSL=false&allowPublicKeyRetrieval=true","root","V1shal@24");
			PreparedStatement pt= con.prepareStatement("select * from traindb where froms = ? and tos = ? and frequency = ?");
			
			pt.setString(1, from); 
			pt.setString(2, to);
			pt.setString(3, day);
			
			ResultSet rs = pt.executeQuery();
			
			if (rs.next()) {
				session.setAttribute("status","success");
				request.setAttribute("estatus", "success");
				request.setAttribute("train_number",rs.getInt(1));
				request.setAttribute("train_name",rs.getString(2));
				request.setAttribute("departure",rs.getString(3));
				request.setAttribute("available",rs.getString(4));
				request.setAttribute("froms",rs.getString(5));
				request.setAttribute("tos", rs.getString(6));
				request.setAttribute("frequency",rs.getString(7));
				request.setAttribute("dates", date);
				request.setAttribute("day", day);
				//PrintWriter out= response.getWriter();
				//out.println ("before" + rs.getString(5)); 
				dispatcher = request.getRequestDispatcher("view.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("estatus", "failed");
				dispatcher = request.getRequestDispatcher("booking_cancellaton.jsp");
				dispatcher.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 		
	}

}
