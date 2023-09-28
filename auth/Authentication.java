package auth;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.Constants;
import utility.DB;

/**
 * Servlet implementation class Sell_logreg
 */
@WebServlet("/Authentication")
public class Authentication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String em = request.getParameter("em");
		String pa = request.getParameter("pw");
		System.out.println(em);
		HttpSession session = request.getSession();

		try {
			
			if (em.equalsIgnoreCase(Constants.ADMIN_EMAIL) && pa.equalsIgnoreCase(Constants.ADMIN_PASS)) {
				session.setAttribute("uid", 1);
				session.setAttribute("Role", 1);
				response.getWriter().print("<html><body><script>alert('Admin Logged In Successfully');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE.jsp?us=ad");
				rd.forward(request, response);
			} else if (em.equalsIgnoreCase(Constants.RN_EMAIL) && pa.equalsIgnoreCase(Constants.RN_PASS)) {
				session.setAttribute("uid", 5);
				session.setAttribute("Role", 5);
				response.getWriter().print("<html><body><script>alert('Renovate Logged In Successfully');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE.jsp?us=ad");
				rd.forward(request, response);
			}
			else {
				System.out.println(em);
				String qry = "SELECT * FROM 1_users WHERE email='"+em+"' AND password='"+pa+"'";
				ResultSet rs = DB.getconnection().createStatement().executeQuery(qry);	
				System.out.println(pa);
				if(rs.next()) { 	
				
				String Role = rs.getString("role");
				System.out.println(Role);
				
				session.setAttribute("uid", rs.getString("userid")); //USERID
				session.setAttribute("uname", rs.getString("name")); //USERNAME
				session.setAttribute("uemail", rs.getString("email")); //USEREMAIL
				if(Role.equals("CLIENT")) {
					session.setAttribute("Role", 2);
					response.getWriter().print("<html><body><script>alert('Client Logged In Successfully');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE.jsp?us=cl");
					rd.forward(request, response);
				}else if (Role.equals("INQUIRY")){
					session.setAttribute("Role", 3);
					response.getWriter().print("<html><body><script>alert('Logged In Successfully');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE.jsp?us=in");
					rd.forward(request, response);
				}else if (Role.equals("WAREHOUSE")){
					session.setAttribute("Role", 4);
					response.getWriter().print("<html><body><script>alert('Logged In Successfully');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("HOMEPAGE.jsp?us=wa                                                                                                          ");
					rd.forward(request, response);
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp?st=na");
					rd.include(request, response);
				}
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?st=oth");
				rd.include(request, response);
			}
		}
				
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String n = request.getParameter("un");
		String e = request.getParameter("em");
		String pa = request.getParameter("pw");
		String ph = request.getParameter("ph");
		String ad = request.getParameter("ad");
		String role = request.getParameter("role");
		Random r = new Random();
		int id = r.nextInt(100000);
		System.out.println(n + " - " + e + " - " + ph + " - " + ad + " - ");

		try {
			String qry = "INSERT INTO 1_users (userid,name,email,password,phone,address,role) " + "VALUES('" + id
					+ "','" + n + "','" + e + "','" + pa + "','" + ph + "','" + ad + "','" + role + "')";
			int i = DB.getconnection().prepareStatement(qry).executeUpdate();
			if (i > 0) {
				System.out.println("Register Success !");
				response.getWriter().print("<html><body><script>alert('Registered Successfully');</script></body></html>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?st=s");
				rd.forward(request, response);
			} else {
				System.out.println("Register Failed !");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp?st=f");
				rd.include(request, response);
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

}
