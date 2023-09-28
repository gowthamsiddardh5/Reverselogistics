package inquriy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.DB;

/**
 * Servlet implementation class iq_register
 */
@WebServlet("/iq_register")
public class iq_register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String cpass=request.getParameter("cpass");
		
	
		try {
			String qur="insert into iq_register values(?,?,?,?)";
			PreparedStatement ps1 = DB.getconnection().prepareStatement(qur);
			
			ps1.setString(1,name);			
			ps1.setString(2,email);
			ps1.setString(3,pass);
			ps1.setString(4,cpass);		
			int i=ps1.executeUpdate();
			
			if(i>0) {
				out.print("<html><body><script>alert('Register Successfully')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("iq_login.html");
				rd.include(request,response);
			}
			else {
				out.print("<html><body><script>alert('your not registered')</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("iq_register.html");
				rd.include(request, response);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
