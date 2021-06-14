package controller;

//imported packages
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userdao;

import model.User;


@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting the parameters of user enter from sign in form
		
		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		
		//dao class instantiation
		
		userdao user = new userdao();
		
       boolean userexist = user.validate(username, password);
		
		
		try { //exceptions handled
			
			
			if(userexist == true)
			{
				// if it is exist, get the user details using UserLogin...
				User u1 = user.UserLogin(username, password);
				
				// set user details in session...
				HttpSession session = request.getSession();
				session.setAttribute("LoggedUser", u1);
				
				// Redirect the web page to home page...
				
				response.sendRedirect("homee.jsp");
				
			}
			
			else
			{
				// user not exist Redirect the web page to login page 
				response.sendRedirect("login.jsp");
			}
			
		
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
