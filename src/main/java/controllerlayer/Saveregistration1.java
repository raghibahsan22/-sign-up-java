package controllerlayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modellayer.DAOservice1;
import modellayer.DAOservice1Impl;

@WebServlet("/savereg1")
public class Saveregistration1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Saveregistration1() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/registration1.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		
		String name = request.getParameter("name");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		DAOservice1 dao = new DAOservice1Impl();
		dao.connectDB();
		dao.Saveregistration1(name, city ,email, mobile);
		request.setAttribute("msg", "record saved successfully...");
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/registration1.jsp");
		rd.forward(request, response);
	}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
		

}
}
