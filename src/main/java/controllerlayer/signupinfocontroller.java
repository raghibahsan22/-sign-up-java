package controllerlayer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modellayer.DAOservice1;
import modellayer.DAOservice1Impl;

@WebServlet("/signupinfo")
public class signupinfocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public signupinfocontroller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
   DAOservice1 dao= new DAOservice1Impl();	
   dao.connectDB();
   dao.savelogininfo(email , password);
   
   request.setAttribute("msg", "signup succesfull!!!");
   
   RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view1/login.jsp");
   rd.forward(request, response);
   }

}
