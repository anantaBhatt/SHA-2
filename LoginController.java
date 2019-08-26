package src.controller;
import java.io.IOException;
import src.helpers.UserHelper;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.pojos.*;

import src.controller.*;
/**
 * Servlet implementation class LoginController
 */
@WebServlet ("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private HttpSession session;
       private String url;
       private int loginAttempts;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		if(request.getParameter("logout") !=null){
			logout();
			url="index.jsp";
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		session=request.getSession();
		
		if(session.getAttribute("loginAttempts")==null){
			loginAttempts=0;
		}
		
		if(loginAttempts>2){
			String errorMessage="Error: Number of login Attempts Exceeded";
			request.setAttribute("errorMessage",errorMessage);
			url= "index.jsp";
		}else
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			
			SHA256Digest pws= new SHA256Digest();
			String hash= pws.sha(password);
			
			UserHelper uh= new UserHelper();
			User user=uh.authenticateUser(username, hash);
			System.out.println("USEr"+ user.getUsername());
			if(user!=null){
				session.invalidate();
				session=request.getSession(true);
				session.setAttribute("user", user);
				url="UserAccount.jsp";
			}
			else
			{String errorMessage="Error: Unrecognised Username or Password<br> Login attempts remaining:"+(3-(loginAttempts));
			request.setAttribute("errorMessage", errorMessage);
			session.setAttribute("loginAttempts", loginAttempts++);
			url="index.jsp";
		}
	}
RequestDispatcher dispatcher = request.getRequestDispatcher(url);
dispatcher.forward(request,response);
	}
public void logout()
{
	session.invalidate();
	}
}
