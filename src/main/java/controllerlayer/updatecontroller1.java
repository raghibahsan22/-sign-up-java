package controllerlayer;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modellayer.DAOservice1;
import modellayer.DAOservice1Impl;

@WebServlet("/update")
public class updatecontroller1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updatecontroller1() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		
	
	HttpSession session = request.getSession(false);
	if(session.getAttribute("email")!=null) {
	String email = request.getParameter("email");	
	String mobile = request.getParameter("mobile");
	request.setAttribute("email", email);
	request.setAttribute("mobile", mobile);
		
	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/updateregistration1.jsp");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");	
		String mobile = request.getParameter("mobile");
		
		DAOservice1 dao = new DAOservice1Impl();
		dao.connectDB();
		dao.updateregistration1(email , mobile);
		
		ResultSet result = dao.getAll();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/Listregistrartion.jsp");
		rd.forward(request, response);
	}

}
