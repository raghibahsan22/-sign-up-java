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

@WebServlet("/listall")
public class Listregistrtion extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Listregistrtion() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
		DAOservice1 dao = new DAOservice1Impl();
		dao.connectDB();
		ResultSet result = dao.getAll();
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/Listregistrartion.jsp");
		rd.forward(request, response);	
	
	} else {
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
		
	}

}
