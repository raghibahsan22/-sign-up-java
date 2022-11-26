package controllerlayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import modellayer.DAOservice1;
import modellayer.DAOservice1Impl;


@WebServlet("/logincontroller1")
public class logincontroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public logincontroller1() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/signup.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DAOservice1 dao = new DAOservice1Impl();
		dao.connectDB();
		
		boolean status = dao.verifyLogin(email, password);
		
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/registration1.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "invalid login");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	rd.forward(request, response);
	}}


